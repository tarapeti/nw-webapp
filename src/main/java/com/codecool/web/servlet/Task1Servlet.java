package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.Task1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/task1"})
public class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String companyName = req.getParameter("companyName");
        try (Connection connection = getConnection(req.getServletContext())) {
            if (companyName == null || companyName.equals("")) {
                List<Task1> task1list = TaskDao.getTask1Result(connection);
                req.setAttribute("task1list", task1list);
                req.getRequestDispatcher("task1.jsp").forward(req, resp);
            } else {
                List<Task1> task1filterList = TaskDao.getTask1Filter(connection, companyName);
                req.setAttribute("task1list", task1filterList);
                req.getRequestDispatcher("task1.jsp").forward(req, resp);
                resp.sendRedirect("task1.jsp");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
