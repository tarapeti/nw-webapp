package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;

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

@WebServlet({"/task2"})
public class Task2Servlet extends AbstractServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String companyName = req.getParameter("companyName");
        try (Connection connection = getConnection(req.getServletContext())) {
            if (companyName.equals("")) {
                List<Task2> task1list = TaskDao.getTask2Result(connection);
                req.setAttribute("task2list", task1list);
                req.getRequestDispatcher("task2.jsp").forward(req, resp);
            } else {
                List<Task2> task1filterList = TaskDao.getTask2Filter(connection, companyName);
                req.setAttribute("task2list", task1filterList);
                req.getRequestDispatcher("task2.jsp").forward(req, resp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
