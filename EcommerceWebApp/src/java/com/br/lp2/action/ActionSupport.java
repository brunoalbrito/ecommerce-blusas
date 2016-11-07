/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 41583469
 */
public abstract class ActionSupport implements Action {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response,Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setRequest(request);
        setResponse(response);
        return (String) method.invoke(this, new Object[0]);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    

}
