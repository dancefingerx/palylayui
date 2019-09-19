package com.example.classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java的类加载器来实现java类的热加载
 * @author xnz
 * @date 2019/8/30 10:09
 */
public class MyClassLoader extends ClassLoader {

    //要加载得java类得classpath路径
    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("==========自定义findClass=============");
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    /**
     * 加载class文件中内容
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        System.out.println("==========自定义loadClassData=============");
        try {
            name = name.replace(".","//");
            FileInputStream is = new FileInputStream(new File(classpath+name+".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b=is.read()) != -1){
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}



