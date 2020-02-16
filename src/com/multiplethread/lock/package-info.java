/**
 * <strong>LOCK对象</strong><br/>
 * 与synchronized类似的，lock也能够达到同步的效果<br/>
 * Lock是一个接口，为了使用一个Lock对象，需要用到<br/>
 * Lock lock = new ReentrantLock();<br/>
 * 与 synchronized (someObject) 类似的，lock()方法，表示当前线程占用lock对象，一旦占用，其他线程就不能占用了。<br/>
 * 与 synchronized 不同的是，一旦synchronized 块结束，就会自动释放对someObject的占用。 lock却必须调用unlock方法进行手动释放，为了保证释放的执行，往往会把unlock() 放在finally中进行。
 */
package com.multiplethread.lock;