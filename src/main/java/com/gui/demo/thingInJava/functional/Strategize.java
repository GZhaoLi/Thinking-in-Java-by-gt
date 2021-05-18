package com.gui.demo.thingInJava.functional;


/**
 * @Classname Strategize
 * @Description TODO
 * @Date 2021/5/17 9:40
 * @Created by gt136
 */
interface Strategy{
    String approach(String msg);
}

class Soft implements Strategy {

    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}
class Unrelated{
    static String twice(String msg) {
        return msg+ " " +msg;
    }
}
public class Strategize {
    Strategy strategy;
    String msg;

    Strategize(String msg) {
        strategy = new Soft(); //[1]
        System.out.println("========");
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {

        Strategy[] strategies = {
                new Strategy() {//[2]
                    @Override
                    public String approach(String msg) {
                        System.out.println("111");
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5), //[3]
/*                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.substring(0, 5);
                    }
                },*/
                Unrelated::twice //[4]
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();
        for (Strategy newStrategy: strategies){
            s.changeStrategy(newStrategy);//[5]
            s.communicate();//[6]
        }
    }
}
/*
print:
hello there?
HELLO THERE!
Hello
Hello there Hello there
 */