package com.io.file;

import java.io.File;

public class FindMaxandMin {
    public static void main(String[] args) {
	File file = new File("C:\\WINDOWS");
	File[] files = file.listFiles();
	File maxFile = null, minFile = null;
	for (int i = 0; i < files.length; i++) {
	    File file2 = files[i];
	    if (file2.isDirectory()) {
		continue;
	    } else {
		if (maxFile == null) {
		    maxFile = file2;
		    minFile = file2;
		}
		if (file2.length() > maxFile.length()) {
		    maxFile = file2;
		}
		if (file2.length() < minFile.length()) {
		    minFile = file2;
		}
	    }
	}
	System.out.println("MAX：" + maxFile.getName() + " size: " + maxFile.length());
	System.out.println("MIN：" + minFile.getName() + " size: " + minFile.length());
    }
}
