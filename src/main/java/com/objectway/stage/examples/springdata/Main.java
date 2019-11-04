package com.objectway.stage.examples.springdata;

import java.sql.*;

public class Main {
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/example_springdata";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) throws ClassNotFoundException {
        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

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

                    // Display values
                    System.out.println(
                            String.format("id: %d, Age: %d, First: %s, Last: %s", id, age, first, last)
                    );
                }
            }
        } catch (SQLException ex) {
            // Handle errors for JDBC
            ex.printStackTrace();
        }
    }
}
