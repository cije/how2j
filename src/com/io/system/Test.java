package com.io.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 自动创建有一个属性的类文件。
 * 通过控制台，获取类名，属性名称，属性类型，根据一个模板文件，自动创建这个类文件，并且为属性提供setter和getter
 */
public class Test {
    public static void main(String[] args) {
        String str = "public class @class@ {\n" +
                "    public @type@ @property@;\n" +
                "    public @class@() {\n" +
                "    }\n" +
                "    public void set@Uproperty@(@type@  @property@){\n" +
                "        this.@property@ = @property@;\n" +
                "    }\n" +
                "     \n" +
                "    public @type@  get@Uproperty@(){\n" +
                "        return this.@property@;\n" +
                "    }\n" +
                "}\n";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入类的名称:");
        String className = sc.next();
        System.out.println("请输入属性的类型：");
        String type = sc.next();
        System.out.println("请输入属性的名称：");
        String name = sc.next();
        sc.close();

        str = str.replaceAll("@class@", className);
        str = str.replaceAll("@property@", name);
        str = str.replaceAll("@type@", type);
        String uproperty = name.substring(0, 1).toUpperCase() + name.substring(1);
        str = str.replaceAll("@Uproperty@", uproperty);

        System.out.println("替换后的内容：");
        System.out.println(str);
        
        File file = new File("t1/t3/" + className + ".java");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                PrintWriter printWriter = new PrintWriter(fileOutputStream)
        ) {
            printWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
