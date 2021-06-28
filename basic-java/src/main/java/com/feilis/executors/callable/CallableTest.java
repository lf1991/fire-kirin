package com.feilis.executors.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName CallableTest
 * @Description TODO
 * @Author lf199
 * @Date 2021/6/23 17:12
 * @Version V1.0
 */
public class CallableTest {

    static void test() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();//缓存型池 先查看池中有没有以前建立的线程，如果有，就 reuse.如果没有，就建一个新的线程加入池中
        List<Future<String>> resList = new ArrayList<Future<String>>();


        //创建10个任务并行
        for (int i = 0; i < 10; i++) {
            Future<String> f = service.submit(new TaskWithRes(i));
            resList.add(f);
        }

        Thread.sleep(5000);
        for (Future<String> fs : resList) {
            if (fs.isDone()) {
                System.out.println(fs.get());
            }
        }
    }


    public static void main(String[] args) throws Exception {
        CallableTest.test();
    }
}

