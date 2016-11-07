/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.frontcontroller;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.br.lp2.action.Action;
import java.lang.reflect.InvocationTargetException;
import java.rmi.ServerException;

/**
 *
 * @author 41583469
 */
@WebServlet("*.action")
@MultipartConfig
public class Controller extends HttpServlet {

    private final String SEPARADOR = "!";
    private ResourceBundle rb = ResourceBundle.getBundle("com.lp2.bundle.actionConfig");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
//        out.print(request.getParameter("cor"));
        String result;
        try {
            Class actionClass = Class.forName(rb.getString(getActionName(request)));
            System.out.print("Pacote: " + actionClass.getName());
            Method actionMethod = getRealMethod(request, actionClass);
            Object actionInstanciada = actionClass.newInstance();

            if (!(actionInstanciada instanceof Action)) {
                throw new ServletException("A classe informada não é uma classe de ação");
            }
            Action action = (Action) actionInstanciada;
            result = action.execute(request, response, actionMethod);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IllegalArgumentException | InvocationTargetException e) {
            throw new ServletException(e);
        }
        request.getRequestDispatcher(result).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getActionName(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath() + "/", "").replace(".action", "").split(SEPARADOR)[0];
    }

    private Method getRealMethod(HttpServletRequest request, Class actionClass) {
        Method method = null;

        try {
            method = actionClass.getMethod(getMethodName(request), new Class[0]);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            if (actionClass != Object.class) {
                method = getRealMethod(request, actionClass.getSuperclass());
            }
        }
        return method;
    }

    private String getMethodName(HttpServletRequest request) {
        return request.getRequestURI().replace(request.getContextPath() + "/", "").replace(".action", "").split(SEPARADOR)[1];
    }

}
