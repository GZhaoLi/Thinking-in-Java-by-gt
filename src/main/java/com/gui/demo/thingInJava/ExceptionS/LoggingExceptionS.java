package com.gui.demo.thingInJava.ExceptionS;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @Classname LoggingExceptins
 * @Description TODO
 * @Date 2021/4/7 16:50
 * @Created by gt136
 */
class LoggingExceptions extends Exception {
    private static Logger logger = Logger.getLogger("LoggingExceptions");
    public LoggingExceptions() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LoggingExceptionS{
    public static void main(String[] args) {
        try {
            throw new LoggingExceptions();
        } catch (LoggingExceptions e) {
            System.err.println("Caught " + e);
        }

        try {
            throw new LoggingExceptions();
        } catch (LoggingExceptions e) {
            System.err.println("Caught " + e);
        }
    }
}
