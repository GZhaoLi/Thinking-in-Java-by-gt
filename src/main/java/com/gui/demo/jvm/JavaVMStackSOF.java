package com.gui.demo.jvm;

/**
 * @Classname JavaVMStackSOF
 * @Description -Xss 设置虚拟机栈，因为HotSpot虚拟机和本地方法栈（-Xoss），所以只设置虚拟机栈。参数减少栈内存容量,将会报栈溢出异常
 * @Date 2021/8/29 21:58
 * @Created by gt136
 */
public class JavaVMStackSOF {
    private int stackSize = 1;
    public void stackLeak() {
        stackSize++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable ex) {
            System.out.println("stack size: " + oom.stackSize);
            throw ex;
        }
    }
}
/*
outputs:
stack size: 989
Exception in thread "main" java.lang.StackOverflowError
	at com.gui.demo.jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
	at com.gui.demo.jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 */
