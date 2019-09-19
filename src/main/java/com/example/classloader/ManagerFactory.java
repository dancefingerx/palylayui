package com.example.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


/**
 * 加载manager的工厂
 *
 * @author xnz
 * @date 2019/8/28 20:31
 */
public class ManagerFactory<T> {
    // 记录热加载类的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();
        public static final String CLASS_PATH = "G:/study/Workspace/palylayui/target/classes/";
//    private static String CLASS_PATH = "G:/study/Workspace/palylayui/target/classes/";
    // 实现热加载的类的全名称(包名+类名)
    public static final String MY_MANAGER = "com.example.classloader.MyManager";

    public ManagerFactory() {
    }

    public static BaseManager getManager(String className) {
//        CLASS_PATH = classPath;
        String path = CLASS_PATH + className.replaceAll("\\.", "/") + ".class";
        File loadFile = new File(path);
        // 文件最后修改时间
        long lastModified = loadFile.lastModified();
        System.out.println(lastModified);
        if (loadTimeMap.get(className) != null) {
            System.out.println(loadTimeMap.get(className).getLoadTime() != lastModified);
        }
        // loadTimeMap 不包含className为 key 的loadInfo信息。证明这个类没有被加载，那么需要加载这个类到JVM
        if (loadTimeMap.get(className) == null) {
            System.out.println(1);
            load(className, lastModified);
        }//加载这个类的时间戳变化了，我们同样要加载这个类到JVM
        else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            System.out.println(2);
            load(className, lastModified);
        }
        System.out.println("=======3=======" + loadTimeMap.get(className).getManager());
//        return loadTimeMap.get(className).getBaseManager();
        return loadTimeMap.get(className).getManager();

    }

    private static void load(String className, long lastModified) {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.findClass(className);
//            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        BaseManager manager = newInstance(loadClass);
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
//        loadInfo.setBaseManager(manager);
        loadInfo.setManager(manager);
        loadTimeMap.put(className, loadInfo);
    }

    // 以反射的方式创建BaseManager对象
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
//            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


}
