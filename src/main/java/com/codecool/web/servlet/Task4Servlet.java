package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.Task3;
import com.codecool.web.model.Task4;

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

@WebServlet({"/task4"})
public class Task4Servlet extends AbstractServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String companyName = req.getParameter("companyName");
        try (Connection connection = getConnection(req.getServletContext())) {
            if (companyName.equals("")) {
                List<Task4> task4list = TaskDao.getTask4Result(connection);
                req.setAttribute("task4list", task4list);
                req.getRequestDispatcher("task4.jsp").forward(req, resp);
            } else {
                List<Task4> task4filterList = TaskDao.getTask4Filter(connection, companyName);
                req.setAttribute("task4list", task4filterList);
                req.getRequestDispatcher("task4.jsp").forward(req, resp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
