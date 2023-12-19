package com.example.utils;

import java.sql.*;

public class DBHelper {
    private static final String URL="jdbc:mysql://localhost:3306/obclub?useUnicode=true&characterEncoding=GBK";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (pstmt!=null){
                pstmt.close();
            }
            if (rs!=null){
                rs.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
