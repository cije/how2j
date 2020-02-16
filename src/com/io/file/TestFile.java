package com.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) {
	Test3();
    }

    static void Test1() {
	File file1 = new File("");
	System.out.println("file1的绝对路径：" + file1.getAbsolutePath());

	File file2 = new File("CentOS.exe");
	System.out.println("file2的绝对路径：" + file2.getAbsolutePath());

	File file3 = new File(file1, "CentOS.exe");
	System.out.println("file3的绝对路径：" + file3.getAbsolutePath());
    }

    static void Test2() {
	File file = new File("CentOs.exe");
	System.out.println("当前文件是：" + file);
	System.out.println("判断文件是否存在：" + file.exists());
	System.out.println("判断文件是否是文件夹：" + file.isDirectory());
	System.out.println("判断是否是文件：" + file.isFile());
	System.out.println("获取文件的长度：" + file.length());

	long time = file.lastModified();
	Date date = new Date(time);
	System.out.println("获取文件的最后修改时间：" + date);
	// 设置文件修改时间为1970.1.1 08：00：00
	file.setLastModified(0);

	// 文件重命名
	File file2 = new File("CentOS2.exe");
	File file3 = new File("CentOS1.exe");
	file2.renameTo(file3);
	System.out.println("把CentOS2.exe改名为CentOS1.exe");
    }

    static void Test3() {
	File file = new File("E:\\DATA\\lenovo\\Desktop\\lq\\1478502966297813");
	// 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件和子文件夹内的）
	String[] strings = file.list();
	// 以文件数组的形式，返回....
	File[] files = file.listFiles();

	// 以字符串的形式返回获取所在的文件夹
	file.getParent();
	// 以文件形式返回获取所在的文件夹
	file.getParentFile();

	// 创建文件夹，若父文件夹lq不存在，创建就无效
	file.mkdir();
	// 创建文件夹，若父文件夹lq不存在，就会创建父文件夹
	file.mkdirs();

	// 创建一个空文件之前，通常都会创建父文件夹
	file.getParentFile().mkdirs();
	try {
	    // 创建一个空文件，若父文件夹不存在，就会抛出异常
	    file.createNewFile();
	} catch (IOException e) {
	    // TODO 自动生成的 catch 块
	    e.printStackTrace();
	}

	// 列出所有的盘符 c: d: e:等等，以文件数组的形式
	File[] rootFile = File.listRoots();

	// 删除文件
	// file.delete();

	// JVM结束的时候，删除文件，常用于临时文件的删除
	// file.deleteOnExit();
    }
}
