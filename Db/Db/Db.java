package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    public static Connection getConnection() throws SQLException {
        String url =  "jdbc: 'postgresql://neondb_owner:npg_rt9ewabTZ6Uc@ep-shiny-morning-adho75ur-pooler.c-2.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require'";

        try {
            Class.forName("org.postgresql.Driver"); 

        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado!", e);
        }

        return DriverManager.getConnection(url);
    }
}