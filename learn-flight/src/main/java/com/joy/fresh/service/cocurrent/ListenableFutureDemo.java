package com.joy.fresh.service.cocurrent;

/**
 * Created by jianyuanhao on 18-4-16.
 */
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.SettableFuture;
import org.springframework.util.CollectionUtils;

public class ListenableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // testRateLimiter();
        testListenableFuture();
        // 首先通过MoreExecutors类的静态方法listeningDecorator方法初始化一个ListeningExecutorService的方法，
        // 然后使用此实例的submit方法即可初始化ListenableFuture对象
        final ListeningExecutorService executorService = MoreExecutors
                .listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });

        AsyncFunction<Integer, String> queryFunction = new AsyncFunction<Integer, String>() {
            public ListenableFuture<String> apply(final Integer rowKey) {
                return executorService.submit(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return rowKey.toString();
                    }
                });
            }
        };
        ListenableFuture<String> queryFuture = Futures.transform(listenableFuture, queryFunction, executorService);

        try {
            System.out.println(queryFuture.get().getClass() + queryFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private void doFareCallback(final String searchContext, List<String> fareInfoWrappers) {
        // 每次回调时,new一个future并add callback
        SettableFuture<java.util.List<String>> fareInfoFuture = SettableFuture.create();
        fareInfoFuture.set(fareInfoWrappers);
        Futures.addCallback(fareInfoFuture, new FareInfoCallback("a", "b", "v", "d", Lists.newArrayList("d")));
    }

    public class FareInfoCallback implements FutureCallback<List<String>> {

        private String farePolicyMatchService;
        private String callbackService;
        private String requestId;
        private String searchContext;
        private List<String> policyInfoMapGetter;

        public FareInfoCallback(String farePolicyMatchService, String callbackService, String requestId,
                String searchContext, List<String> policyInfoMapGetter) {
            this.farePolicyMatchService = farePolicyMatchService;
            this.callbackService = callbackService;
            this.requestId = requestId;
            this.searchContext = searchContext;
            this.policyInfoMapGetter = policyInfoMapGetter;
        }

        @Override
        public void onSuccess(List<String> result) {
            try {
                System.out.println("success!");
                if (CollectionUtils.isEmpty(result)) {
                    return;
                }

                for (final String clientId : policyInfoMapGetter) {
                    // do Something with the result
                    System.out.println(clientId);
                }
            } finally {
                // do something finally
            }
        }

        @Override
        public void onFailure(Throwable t) {
            try {
                // do something failure
            } finally {
                // finally
            }
        }

    }

    /**
     * RateLimiter类似于JDK的信号量Semphore，他用来限制对资源并发访问的线程数
     */
    public static void testRateLimiter() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        RateLimiter limiter = RateLimiter.create(5.0); // 每秒不超过4个任务被提交

        for (int i = 0; i < 10; i++) {
            limiter.acquire(); // 请求RateLimiter, 超过permits会被阻塞

            final ListenableFuture<Integer> listenableFuture = executorService.submit(new Task("is " + i));
        }
    }

    public static void testListenableFuture() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Task("testListenableFuture"));

        // 主线程可以继续执行,异步完成后会执行注册的监听器任务.
        System.out.println("go on execute.asyn complete will callback");
        // 同步获取调用结果
        try {
            System.out.println(listenableFuture.get());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }

        // 第一种方式：ListenableFuture 中的基础方法是addListener(Runnable, Executor),
        // 该方法会在多线程运算完的时候，指定的Runnable参数传入的对象会被指定的Executor执行。
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("get listenable future's result " + listenableFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, executorService);

        // 第二种方式 ：
        // 如果CallBack是一个耗时操作，你应该选择另一个注册CallBack:

        // Futures.addCallback(futureTask,callback,executorService); //提供另一个线程池来执行性回调

        // 除了ListenableFuture,guava还提供了FutureCallback接口,相对来说更加方便一些；注意这里没用指定执行回调的线程池,从输出可以看出，默认是和执行异步操作的线程是同一个.
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            // 执行成功回调逻辑
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            // 执行失败回调逻辑
            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

class Task implements Callable<Integer> {
    String str;

    public Task(String str) {
        this.str = str;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("call execute.." + str);
        TimeUnit.SECONDS.sleep(1);
        return 7;
    }
}