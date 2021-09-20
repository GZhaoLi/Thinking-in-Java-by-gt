package com.gui.demo.jvm;

/**
 * @Classname FinalizeEscapeGC
 * @Description 一个对象的finalize() 被执行后的自救
 * @Date 2021/9/5 22:42
 * @Created by gt136
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVA_HOOK = null;
    public void isAlive() {
        System.out.println("yes, i am still alive! :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        //在执行finalize() 的时候再次将这个对象赋予新的引用
        FinalizeEscapeGC.SAVA_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVA_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVA_HOOK = null;
        System.gc();
        //因为Finalizer 方法优先级很低，暂停0.5秒来等待轮到它执行
        Thread.sleep(500);
        if (SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }

        //这段代码与上面完全相同，但是这次却自救失败了
        SAVA_HOOK = null;
        System.gc();
        //
        Thread.sleep(500);
        if (SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else {
            System.out.println("no, i am dead :(");
        }
    }

}
/*
outputs:
finalize method executed
yes, i am still alive!:)
no, i am dead :(
 */