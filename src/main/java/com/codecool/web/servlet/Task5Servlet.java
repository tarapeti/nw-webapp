package com.codecool.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task5"})
public class Task5Servlet extends AbstractServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try (Connection connection = getConnection(request.getServletContext())) {


        } catch (SQLException ex) {
            ex.printStackTrace();


            response.sendRedirect("index");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try (Connection connection = getConnection(request.getServletContext())) {
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
