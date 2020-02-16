/**
 * <strong>线程池</strong><br/>
 * 线程池的思路和生产者消费者模型是很接近的。
 * <ol>
 *     <li>准备一个任务容器</li>
 *     <li>一次性启动10个 消费者线程</li>
 *     <li>刚开始任务容器是空的，所以线程都wait在上面。</li>
 *     <li>直到一个外部线程往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify</li>
 *     <li>这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。</li>
 *     <li>如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。</li>
 * </ol>
 * 在整个过程中，都不需要创建新的线程，而是循环使用这些已经存在的线程
 */
package com.multiplethread.threadpool;