package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.Task2;
import com.codecool.web.model.Task3;

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

@WebServlet({"/task3"})
public class Task3Servlet extends AbstractServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String companyName = req.getParameter("companyName");
        try (Connection connection = getConnection(req.getServletContext())) {
            if (companyName.equals("")) {
                List<Task3> task3list = TaskDao.getTask3Result(connection);
                req.setAttribute("task3list", task3list);
                req.getRequestDispatcher("task3.jsp").forward(req, resp);
            } else {
                List<Task3> task3filterList = TaskDao.getTask3Filter(connection, companyName);
                req.setAttribute("task3list", task3filterList);
                req.getRequestDispatcher("task3.jsp").forward(req, resp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
