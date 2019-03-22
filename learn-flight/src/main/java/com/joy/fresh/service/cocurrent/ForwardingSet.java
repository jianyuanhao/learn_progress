package com.joy.fresh.service.cocurrent;

/**
 * Created by jianyuanhao on 18-4-6.
 */
import java.util.*;


public class ForwardingSet<E> implements Set<E>{
    private final Set<E> s;

    public ForwardingSet(Set<E> s){
        this.s = s;
    }

    @Override
    public int size() {return this.s.size();}

    @Override
    public void clear() {this.s.clear();}

    @Override
    public boolean isEmpty() {return this.s.isEmpty();}

    @Override
    public boolean contains(Object o) {return this.s.contains(o);}

    @Override
    public Iterator<E> iterator() {return this.s.iterator();}

    @Override
    public Object[] toArray() {return this.s.toArray();}

    @Override
    public <T> T[] toArray(T[] a) {return this.s.toArray(a);}

    @Override
    public boolean add(E e) {return this.s.add(e);}

    @Override
    public boolean remove(Object o) {return this.s.remove(o);}

    @Override
    public boolean containsAll(Collection<?> c) {return this.s.containsAll(c);}

    @Override
    public boolean addAll(Collection<? extends E> c) {return this.s.addAll(c);}

    @Override
    public boolean retainAll(Collection<?> c) {return this.s.removeAll(c);}

    @Override
    public boolean removeAll(Collection<?> c) {return this.s.retainAll(c);}
}
