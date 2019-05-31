package com.codecool.web.dao;

import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;
import com.codecool.web.model.Task3;
import com.codecool.web.model.Task4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao extends AbstractDao {

    public TaskDao(Connection connection) {
        super(connection);
    }

    public static List<Task1> getTask1Result(Connection connection) throws SQLException {
        List<Task1> Task1List = new ArrayList<>();
        String sql = "select products.product_name as Product, suppliers.company_name as Company from products inner join suppliers on products.supplier_id = suppliers.supplier_id order by products.product_name, suppliers.company_name asc;";
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String prod = resultSet.getString("company");
                String comp = resultSet.getString("product");
                Task1List.add(new Task1(prod, comp));
            }
        }
        return Task1List;
    }

    public static List<Task1> getTask1Filter(Connection connection, String companyName) throws SQLException {
        List<Task1> records = new ArrayList<>();
        String sql = "SELECT products.product_name AS product, suppliers.company_name AS company " +
                "FROM products, suppliers " +
                "WHERE products.supplier_id = suppliers.supplier_id AND suppliers.company_name=? " +
                "ORDER BY product ASC, company ASC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String prod = resultSet.getString("company");
                    String comp = resultSet.getString("product");
                    records.add(new Task1(prod, comp));
                }
            }
        }
        return records;
    }

    public static List<Task2> getTask2Result(Connection connection) throws SQLException {
        List<Task2> Task2List = new ArrayList<>();
        String sql = "select suppliers.company_name as company, count(*) as NumberOfProducts from suppliers inner join products on suppliers.supplier_id = products.supplier_id group by 1 order by count(*) desc, suppliers.company_name asc ;";
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String comp2 = resultSet.getString("company");
                int prodnum = resultSet.getInt("NumberOfProducts");
                Task2List.add(new Task2(comp2, prodnum));
            }
        }
        return Task2List;
    }

    public static List<Task2> getTask2Filter(Connection connection, String companyName) throws SQLException {
        List<Task2> records = new ArrayList<>();
        String sql = "select suppliers.company_name as company, count(*) as NumberOfProducts from suppliers inner join products on suppliers.supplier_id = products.supplier_id AND suppliers.company_name = ? group by 1 order by count(*) desc, suppliers.company_name asc ;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String comp2 = resultSet.getString("company");
                    int productNum = resultSet.getInt("NumberOfProducts");
                    records.add(new Task2(comp2, productNum));
                }
            }
        }
        return records;
    }

    public static List<Task3> getTask3Result(Connection connection) throws SQLException {
        List<Task3> Task3List = new ArrayList<>();
        String sql = "select suppliers.company_name as Company from suppliers inner join products on suppliers.supplier_id = products.supplier_id group by 1 having count(*) = 5 order by suppliers.company_name asc ;";
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String comp3 = resultSet.getString("Company");

                Task3List.add(new Task3(comp3));
            }
        }
        return Task3List;
    }

    public static List<Task3> getTask3Filter(Connection connection, String companyName) throws SQLException {
        List<Task3> records = new ArrayList<>();
        String sql = "select suppliers.company_name as Company from suppliers inner join products on suppliers.supplier_id = products.supplier_id AND suppliers.company_name = ? group by 1 having count(*) = 5 order by suppliers.company_name asc ;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String comp3 = resultSet.getString("Company");
                    records.add(new Task3(comp3));
                }
            }
        }
        return records;
    }

    public static List<Task4> getTask4Result(Connection connection) throws SQLException {
        List<Task4> Task4List = new ArrayList<>();
        String sql = "select customers.company_name, orders.order_id from customers inner join orders on customers.customer_id = orders.customer_id order by customers.company_name asc;";
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String comp4 = resultSet.getString("company_name");
                int orderId = resultSet.getInt("order_id");
                Task4List.add(new Task4(comp4, orderId));
            }
        }
        return Task4List;
    }

    public static List<Task4> getTask4Filter(Connection connection, String companyName) throws SQLException {
        List<Task4> records = new ArrayList<>();
        String sql = "select customers.company_name, orders.order_id from customers inner join orders on customers.customer_id = orders.customer_id AND customers.company_name = ? order by customers.company_name asc;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, companyName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String comp4 = resultSet.getString("company_name");
                    int orderId = resultSet.getInt("order_id");
                    records.add(new Task4(comp4, orderId));
                }
            }
        }
        return records;
    }
}
