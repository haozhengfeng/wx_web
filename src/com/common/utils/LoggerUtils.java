package com.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    public static Logger getLogger(Class<?> arg0) {
        return (Logger) LoggerFactory.getLogger(arg0);
    }

    public static void info(Class<?> arg0, String info) {
        getLogger(arg0).info(info);
    }

    public static void debug(Class<?> arg0, String info) {
        getLogger(arg0).debug(info);
    }
    
    public static void error(Class<?> arg0, String info) {
        getLogger(arg0).error(info);
    }

}
