package com.example.classloader;

/**
 * 测试java类的热加载
 * @author xnz
 * @date 2019/8/30 10:03
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
