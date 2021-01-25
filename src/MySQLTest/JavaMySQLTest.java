package MySQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class JavaMySQLTest {
    public static void main(String[] args) {

        // database connection info
        String url = "jdbc:mysql://localhost:3306/mydtabase";
        String username = "jaroviadb";
        String password = "";

        // wrap in try/catch incase of issues in I/O
        try{
            // establishing connection to db
            Connection connection = DriverManager.getConnection(
                    url, username, password);

            // sql statement
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM BookTable";
            ResultSet resultSet = statement.executeQuery(sql);

                // The next two lines add new row to database.
            // create a Statement from the connection
//            Statement stat = connection.createStatement();

            // insert the data
//            stat.executeUpdate("INSERT INTO BookTable VALUES(22143, 'Freid', 'Beyond good and evil', 12)");


            while(resultSet.next()){
                int ISBN = resultSet.getInt("ISBN");
                String author = resultSet.getString("author");
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");

                System.out.println(
                        "ISBN: " + ISBN +
                        " author: " + author +
                        " title: " + title +
                        " price: " + price
                );
            }


            connection.close();
        } catch (SQLException e){
            System.out.println("error :(");
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
        }
    }
}
