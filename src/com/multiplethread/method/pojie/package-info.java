/**
 * <strong>练习-破解密码</strong><br/>
 * <ol>
 *     <li>生成一个长度是3的随机字符串，把这个字符串当作 密码</li>
 *     <li>创建一个破解线程，使用穷举法，匹配这个密码</li>
 *     <li>创建一个日志线程，打印都用过哪些字符串去匹配，这个日志线程设计为守护线程</li>
 * </ol>
 * 提示： 破解线程把穷举法生成的可能密码放在一个容器中，日志线程不断的从这个容器中拿出可能密码，并打印出来。 如果发现容器是空的，就休息1秒，如果发现不是空的，就不停的取出，并打印。
 */
package com.multiplethread.method.pojie;