//package com.test.jvm.thread;
//
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Test666 {
//
//
//    private boolean addWorker(Runnable firstTask, boolean core) {
//        /*
//         * 1.不断判断状态，如果>=SHUTDOWN就不能添加工作线程
//         * 2.cas操作，增加工作线程
//         */
//        retry:
//        for (int c = ctl.get(); ; ) {
//            // Check if queue empty only if necessary.
//            if (runStateAtLeast(c, SHUTDOWN)
//                    && (runStateAtLeast(c, STOP)
//                    || firstTask != null
//                    || workQueue.isEmpty()))
//                /*如果下边三者满足一个，就不接受任务
//                 *1.rs > shutdown：线程池状态处于 STOP，TIDYING，TERMINATED时，
//                 *  添加工作线程失败，不接受新任务。
//                 *2.rs >= shutdown && firstTask != null:当状态>=shutdown
//                 *  而且添加核心线程任务（只要添加核心线程，firstTask才不为空，非核心线程都是直接从对列拉取数据）
//                 *3.rs >= shutdown && workQueue.isEmpty：当状态>=shutdown而且队列没有数据的
//                 *   时候，就不接受新任务
//                 */
//                return false;
//
//            for (; ; ) {
//                if (workerCountOf(c)
//                        >= ((core ? corePoolSize : maximumPoolSize) & COUNT_MASK))
//                    /*
//                     *如果添加核心线程，工作线程大于等于核心线程，就说明添加核心线程失败；
//                     *如果添加非核心线程,工作线程大于等于线程池数,也说明添加非核心线程失败
//                     */
//                    return false;
//                //cas操作使工作线程池数量+1, 如果true,就代表新增成功，跳出这个整个循环（外层循环也会跳出）
//                if (compareAndIncrementWorkerCount(c))
//                    break retry;
//                c = ctl.get();  // Re-read ctl
//                //如果状态>=SHUTDOWN,就跳出当前循环（跳出里层循环，又从外层重新开始）
//                if (runStateAtLeast(c, SHUTDOWN))
//                    continue retry;
//                // else CAS failed due to workerCount change; retry inner loop
//            }
//        }
//
//        boolean workerStarted = false;
//        boolean workerAdded = false;
//        ThreadPoolExecutor.Worker w = null;
//        try {
//            w = new ThreadPoolExecutor.Worker(firstTask);
//            final Thread t = w.thread;
//            if (t != null) {
//                //加锁（workers、largestPoolSize并不是线程安全的）
//                final ReentrantLock mainLock = this.mainLock;
//                mainLock.lock();
//                try {
//                    // Recheck while holding lock.
//                    // Back out on ThreadFactory failure or if
//                    // shut down before lock acquired.
//                    int c = ctl.get();
//                    //RUNNING或者 （SHUTDOWN而且firstTask为空）才能添加工作线程
//                    if (isRunning(c) || (runStateLessThan(c, STOP) && firstTask == null)) {
//                        if (t.isAlive()) // precheck that t is startable
//                            throw new IllegalThreadStateException();
//                        workers.add(w);
//                        int s = workers.size();
//                        if (s > largestPoolSize)
//                            largestPoolSize = s;
//                        workerAdded = true;
//                    }
//                } finally {
//                    mainLock.unlock();
//                }
//                if (workerAdded) {
//                    t.start();
//                    workerStarted = true;
//                }
//            }
//        } finally {
//            //添加工作线程失败
//            if (!workerStarted)
//                addWorkerFailed(w);
//        }
//        return workerStarted;
//    }
//}
