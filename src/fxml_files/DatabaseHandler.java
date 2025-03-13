package fxml_files;

import java.sql.*;

public class DatabaseHandler extends Configs {
    
    Connection connection;

    public Connection getConnection(){
        String connectionString = "jdbc:oracle:thin:"+Configs.host+":"+Configs.port+":"+Configs.database;
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(connectionString,Configs.dbUser,Configs.dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
   

        return connection;
    }
}
