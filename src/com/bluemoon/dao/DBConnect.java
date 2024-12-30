package com.bluemoon.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnect {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bluemoon"; // URL kết nối
    private static final String USER = "root"; // Tên người dùng
    private static final String PASSWORD = ""; // Mật khẩu

    // Phương thức để lấy kết nối tới cơ sở dữ liệu
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Đăng ký MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Tạo kết nối
            System.out.println("Đang chuẩn bị kết nối...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công tới cơ sở dữ liệu BlueMoon!");
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối tới cơ sở dữ liệu: " + e.getMessage());
        }
        return connection;
    }

    // Phương thức để đóng kết nối cơ sở dữ liệu
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đã đóng kết nối tới cơ sở dữ liệu.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối cơ sở dữ liệu: " + e.getMessage());
            }
        }
    }
}

    

