package com.cym.sample.threadtest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.cym.sample.threadtest.CommonUtils.log;
import static com.cym.sample.threadtest.CommonUtils.readBooks;

/**
 * Created by caoj on 2024/2/4.
 */
public class TestLockJava {
    public static void testStart() {
        log("test start");
    }

    public void testStart02() {
        log("test start 02");
        test03();
    }


    private Object object = new Object();
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Lock lock = new Lock() {
        @Override
        public void lock() {

        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return false;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public void unlock() {

        }

        @Override
        public Condition newCondition() {
            return null;
        }
    };

    private void testLock() {
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }

    }

    private void testReentrantLock() {
        log("start test reentrant lock");
        reentrantLock.lock();
        log("reentrant locked");
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log("reentrant lock unlock");
            reentrantLock.unlock();
        }
        log("stop test reentrant lock");
    }

    void test01() {
        log("t1 start");
        Thread t1 = new Thread(()->{
            synchronized (object) {
                log("t1 object");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                CommonUtils.readBooks(10);
                log("t1 after read");
            }
            log("t1 after object");
        });

        Thread t2 = new Thread(()->{
            log("t2 start");
            synchronized (object) {
                log("t2 object");
                object.notifyAll();
            }
            log("t2 after object");
        });

        t1.start();
        t2.start();
    }


    synchronized void test02() {
        //方法上加锁，同如下效果
//        synchronized (this) {
//
//        }
    }

    //
    void test03() {
        new Thread(()->{
            log("t1 start");
            synchronized (TestLockJava.class) {
                log("t1 sync");
                readBooks(10);
                log("t1 after read");
            }
        }).start();

        new Thread(()->{
            log("t2 start");
            synchronized (ThreadWaitTestJava.class) {
                log("t2 sync");
                readBooks(10, "#");
                log("t2 after read");
            }
        }).start();
    }


}
