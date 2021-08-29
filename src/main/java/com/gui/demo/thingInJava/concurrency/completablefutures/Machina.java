package com.gui.demo.thingInJava.concurrency.completablefutures;

import com.gui.demo.thingInJava.concurrency.Nap;

/**
 * @author gt136
 * @Classname Machina
 * @Description TODO
 * @Date 2021/8/20 16:18
 * @Created by gt136
 */
public class Machina {
    public enum State{
        //State 初始
        STATE,ONE,TWO,THREE,END;
        State step() {
            if (equals(END)) {
                return END;
            }
            return values()[ordinal() + 1];
        }
    }

    private State state = State.STATE;
    private final int id;

    public Machina(int id) {
        this.id = id;
    }

    public static Machina work(Machina machina) {
        if (!machina.state.equals(State.END)) {
            new Nap(0.1);
            machina.state = machina.state.step();
        }
        System.out.println(machina);
        return machina;
    }

    @Override
    public String toString() {
        return "Machina " + "id=" + id +": "+ (state.equals(State.END) ? "Complete" : state);
    }
}
