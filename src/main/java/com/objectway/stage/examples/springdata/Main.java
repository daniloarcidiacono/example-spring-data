package com.objectway.stage.examples.springdata;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/example_springdata";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    public static List<Employee> fetchEmployees() throws SQLException {
        final List<Employee> result = new ArrayList<>();

        try (
            // Open a connection
            final Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            final Statement stmt = conn.createStatement()
        ) {
            // Execute a query
            final String sql = "SELECT id, first, last, age FROM employees";
            try (final ResultSet rs = stmt.executeQuery(sql)) {
                // Extract data from result set
                while (rs.next()) {
                    // Retrieve by column name
                    final int id = rs.getInt("id");
                    final int age = rs.getInt("age");
                    final String first = rs.getString("first");
                    final String last = rs.getString("last");

                    // Convert to object
                    final Employee employee = new Employee(id, age, first, last);
                    result.add(employee);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

        try {
            final List<Employee> employeeList = fetchEmployees();
            employeeList.forEach(x -> System.out.println(x));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
