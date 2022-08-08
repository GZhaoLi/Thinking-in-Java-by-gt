//package com.gui.demo.thingInJava.tests.validating;
//
//import org.junit.jupiter.api.Test;
//import com.google.common.base.*;
//import static com.google.common.base.Verify.*;
//
////import org.junit.Test;
////import static com.google.common.base.Verify.*;
//public class TestDemo01 {
//    @Test
//    public void codeReview01() {
//        assert false;
//        System.out.println("111111");
//    }
//    /*
//    output:
//    java.lang.AssertionError
//	at TestDemo01.codeReview01(TestDemo01.java:6)
//	...
//     */
//
//    @Test
//    public void codeReview02() {
//        assert false :
//                "1111111111111111111111";
//    }
//    /*
//    output:
//    java.lang.AssertionError: 1111111111111111111111
//	at TestDemo01.codeReview02(TestDemo01.java:12)
//	...
//     */
//
//    @Test
//    //链接到类加载器对象控制断言
//    public void codeReview03() {
//        ClassLoader.getSystemClassLoader()
//                .setDefaultAssertionStatus(true);
//        new Loaded().go();
//    }
//    /*
//    output:
//    java.lang.AssertionError: Loaded.go()
//
//	at TestDemo01$Loaded.go(TestDemo01.java:37)
//	at TestDemo01.codeReview03(TestDemo01.java:33)
//     */
//    class Loaded{
//        public void go() {
//            assert false : "Loaded.go()";
//        }
//    }
//
//    //==================================================================================================
//    /*
//     *Guava断言：因为启用Java 本地的断言很麻烦，Guava团队添加一个始终启用的用来替换断言的 Verify 类，他们建议静态导入Verify方法。
//     *
//     */
//    @Test
//    public void guavaAssertion() {
//        verify(2 + 2 == 4);
//        try {
//            verify(1+ 2 == 4);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        try {
//            verify( 1 + 2 == 4,"bad math");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        try {
//            verify(1 + 2 == 4, "bad math: %s", "not 4");
//        } catch (VerifyException e) {
//            System.out.println(e.getMessage());
//        }
//
//        String s = "";
//        s = verifyNotNull(s);
//        s = null;
//
//        try {
//            verifyNotNull(s);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            verifyNotNull(s, "Shouldn't be null: %s", "arg s");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    /*
//    output:
//    com.google.common.base.VerifyException
//    com.google.common.base.VerifyException: bad math
//    bad math: not 4
//    expected a non-null reference
//    Shouldn't be null: arg s
//     */
//}
