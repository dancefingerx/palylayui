package com.example.classloader;

/**
 * 后台启动一条线程，不断刷新重新加载实现了热加载的类
 * @author xnz
 * @date 2019/8/30 10:00
 */
public class MsgHandler implements Runnable {
//    public static final String CLASS_PATH = "G:/study/Workspace/palylayui/target/classes/";
//    public static final String MY_MANAGER = "com.example.classloader.MyManager";
//    public static final ManagerFactory<MyManager> managerFactory = new ManagerFactory<MyManager>();
    @Override
    public void run() {
        while (true){
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);

//            managerFactory.getManager(CLASS_PATH, MY_MANAGER);
//            ((MyManager)manager).logic();
//            MyManager manager = new MyManager();
            manager.logic();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
