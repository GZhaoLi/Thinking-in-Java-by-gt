package com.gui.demo.jvm.jvmengine;

/**
 * @Classname LocalVariableScale
 * @Description VM配置：-verbose:gc    根据输出看出内存在①②的情况下并没有被回收，而第三次我们看到内存被回收了，并且打印的a必须赋初始值
 *      ，负责编译会报错，这是因为局部变量定义没有赋初始值是完全不能使用的，它并没有我们认为的和全局变量（类的字段变量）一样的初始值
 * @Date 2021/10/20 23:21
 * @Created by gt136
 */
public class LocalVariableScale {
    public static void main(String[] args) {
//        byte[] placeholder = new byte[64 * 1024 * 1024];//①
        /*{
            byte[] placeholder = new byte[64 * 1024 * 1024];//②
        }*/
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];//②
        }
        int a = 0;
        System.out.println(a);
        System.gc();
    }
}
/*
outputs:
①
[GC (System.gc())  72056K->66834K(249344K), 0.0411159 secs]
[Full GC (System.gc())  66834K->66627K(249344K), 0.0112559 secs]

②
[GC (System.gc())  72056K->66738K(249344K), 0.0019518 secs]
[Full GC (System.gc())  66738K->66627K(249344K), 0.0105754 secs]

③
0
[GC (System.gc())  72056K->66834K(249344K), 0.0039545 secs]
[Full GC (System.gc())  66834K->1091K(249344K), 0.0191575 secs]
 */