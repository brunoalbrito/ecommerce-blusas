package com.br.lp2.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 41583469
 */
public interface Action {
    public String execute(HttpServletRequest request,HttpServletResponse response,Method method)throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
