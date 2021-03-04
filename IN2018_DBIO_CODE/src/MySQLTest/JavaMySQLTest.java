package MySQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaMySQLTest {

    static String url = "jdbc:mysql://localhost:3306/mydtabase";
    static String username = "jaroviadb";
    static String password = "Jarovia123#@!";
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JavaMySQLTest() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
//        Basic example:
//        Statement statement = connection.createStatement();
//        String sql = "SELECT * FROM BookTable";
//        ResultSet resultSet = statement.executeQuery(sql);




    }



    // todo enable editing

    public static void DeleteFromTable(String tablename, String columntitle, String filter) throws SQLException {

        // set up the stuff
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM " + tablename + " WHERE " + columntitle + " = '" + filter + "';";
        statement.executeUpdate(sql);

    }

    public static void FilterTable(String tablename, String sortcolumn, String sortcondition) throws SQLException {

        String sql = "SELECT * FROM " + tablename + " WHERE " + sortcolumn + " LIKE \"" + sortcondition + "\";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

    }

    public static void insertToDB(String tablename, int isbn, String author, String title, int price) throws SQLException {

        String sql = "INSERT INTO " + tablename + " VALUES(" + isbn + ", '" + author + "', '" + title + "', " + price + ");";
        // run a query
        Statement stat = connection.createStatement();
        stat.executeUpdate(sql);

        // prints updated ver to terminal
//        while (resultSet.next()) {
//            int _ISBN = resultSet.getInt("ISBN");
//            String _author = resultSet.getString("author");
//            String _title = resultSet.getString("title");
//            int _price = resultSet.getInt("price");
//
//            System.out.println(
//                    "ISBN: " + _ISBN +
//                    " author: " + _author +
//                    " title: " + _title +
//                    " price: " + _price
//            );
//
//        }

    }

    public static ArrayList<String[]> AddTableToList(String tablename) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM " + tablename;
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        String tuple;
        // adding changes to an array list
        while (resultSet.next()){

            int _ISBN = resultSet.getInt("ISBN");
            String _author = resultSet.getString("author");
            String _title = resultSet.getString("title");
            int _price = resultSet.getInt("price");

            tuple = "ISBN: " + _ISBN +
                    " author: " + _author +
                    " title: " + _title +
                    " price: " + _price;

            arrayList.add(tuple.split(","));

        }
        return arrayList;
    }
}
