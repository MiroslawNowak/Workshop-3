package pl.coderslab;

import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DbUtil.getConnection();
    }
}