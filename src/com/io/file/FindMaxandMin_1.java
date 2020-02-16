package com.io.file;

import java.io.File;

/**
 * 使用递归来进行文件夹的遍历(包括子文件夹)
 * 
 * @author lenovo
 *
 */

public class FindMaxandMin_1 {
    final static File FILE = new File("E:\\DATA\\lenovo\\Desktop");
    static File maxFile = null;
    static File minFile = null;
    static long maxSize = 0;
    static long minSize = Integer.MAX_VALUE;

    public static void main(String[] args) {
	new FindMaxandMin_1().find(FILE);
	System.out.println("MAX：" + maxFile.getName() + " size: " + maxSize);
	System.out.println("MIN：" + minFile.getName() + " size: " + minSize);
    }

    public void find(File file) {
	if (file.exists()) {
	    if (file.isDirectory()) {
		File[] files = file.listFiles();
		if (null != files) {
		    for (File file2 : files) {
			find(file2);
		    }
		}
	    } else {
		if (maxSize < file.length()) {
		    maxFile = file;
		    maxSize = file.length();
		}
		if (file.length() != 0 && minSize > file.length()) {
		    minFile = file;
		    minSize = file.length();
		}
	    }
	}
    }
}
