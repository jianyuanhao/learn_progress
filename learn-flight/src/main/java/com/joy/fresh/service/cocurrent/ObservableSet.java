package com.joy.fresh.service.cocurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianyuanhao on 18-4-6.
 */

public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }
        /**
         * 完美的带同步的list
         * CopyOnWriteArrayList，这是专门为此定制的。
         * 这是ArrayList的一种变体，通过重新拷贝整个底层数组，
         * 在这里实现所有的写操作。由于内部数组永远不会改动，因此迭代不需要锁定，速度也非常快。如果大量的使用，CopyOnWriteArrayList的性能将大受影响，
         * 但是对于观察者列表来说却是很好的，因为他们几乎不改动，并且经常遍历
         */
//    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<SetObserver<E>>();
//
//    public void addObserver(SetObserver<E> observer) {
//        observers.add(observer);
//    }
//
//    public boolean removeObserver(SetObserver<E> observer) {
//        return observers.remove(observer);
//    }
//
//    private void notifyElementAdded(E element) {
//        for (SetObserver<E> observer : observers) {
//            observer.added(this, element);
//        }
//    }

//    private void notifyElementAdded(E element) {
//        synchronized (observers) {
//            for (SetObserver<E> observer : observers)
//                observer.added(this, element);
//        }
//    }

    /**
     * 如何解死锁：快照．通过将外来方法的调用移出同步代码块来解决这个问题通常并不太难，
     * 对于notofyElementAdded方法，这还设计给observers列表拍张“快照“,
     * 然后没有锁也可以安全的遍历这个列表了，进过这一修改，前面两个例子运行起来便在也不会出现异常或者死锁了：
     * @param element
     */
    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;

        synchronized (observers) {
            snapshot = new ArrayList<SetObserver<E>>(observers);
        }

        for(SetObserver<E> observer : snapshot){
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);
        return result;
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());
        /**
         * This is ok.
         */
        // set.addObserver(new SetObserver<Integer>() {
        // public void added(ObservableSet<Integer> s, Integer e) {
        // System.out.println(e);
        // }
        // });

        /**
         *
         What:并发异常:
         Why:问题在于，当notifyElementAdded调用观察者的added方法时，
         他正处于遍历objservers列表的过程中。added方法调用可观察集合的removeObserver方法，
         从而调用observers.remove方法。现在我们有麻烦了。我们正企图在遍历列表的过程中，
         将一个元素从列表中删除，这是非法的，notifyElementAdded方法中的迭代式在一个同步块中，
         可以防止并发修改，但是无法防止迭代线程本身回调到可观察的集合中，也无法防止修改它的observers列表
         Exception in thread "main" java.util.ConcurrentModificationException at
         java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901) at
         java.util.ArrayList$Itr.next(ArrayList.java:851) at
         ObservableSet.notifyElementAdded(ObservableSet.java:34) at
        ObservableSet.add(ObservableSet.java:43) at
         ObservableSet.main(ObservableSet.java:73)
         */
        
//        set.addObserver(new SetObserver<Integer>() {
//            @Override
//            public void added(ObservableSet<Integer> set, Integer element) {
//                System.out.print(element + " ");
//                if (element == 23) {
//                    set.removeObserver(this);
//                }
//            }
//        });

        /**
         * How? 并发异常：another thread
         * What?　死锁．How:
         *0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 发生死锁
         * 这一次我们没有遇到异常，而是遭到死锁。后台线程调用set.removeObserver，
         * 他企图锁定observers，但他无法获得该锁，因为主线程已经没有锁了。
         * 在这期间，主线程一直在等待后台程序来完成对观察者的删除，这正是造成死锁的原因。
         */
//        set.addObserver(new SetObserver<Integer>() {
//
//            @Override
//            public void added(final ObservableSet<Integer> set, Integer element) {
//                System.out.print(element + " ");
//                if (element == 23) {
//                    ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//                    final SetObserver<Integer> observer = this;
//                    try {
//                        executorService.submit(new Runnable() {
//                            @Override
//                            public void run() {
//                                set.removeObserver(observer);
//                            }
//                        }).get();
//                    } catch (ExecutionException ex) {
//                        System.out.println(ex.getMessage());
//                        throw new AssertionError(ex.getCause());
//                    } catch (InterruptedException ex) {
//                        System.out.println(ex.getMessage());
//                        throw new AssertionError(ex.getCause());
//                    } catch(Exception ex){
//                        System.out.println(ex.getMessage());
//                        throw new AssertionError(ex.getCause());
//                    }
//                    finally {
//                        System.out.println("finally!");
//                        executorService.shutdown();
//                    }
//                }
//            }
//        });


        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
