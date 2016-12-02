package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex on 02.12.2016.
 */
public class Modal {
    private final String URL = "jdbc:mysql://localhost:3306/automatic_system";
    private final String PASSWORD = "root";
    private final String USERNAME = "root";

    public void addDataFromDBTest(){
        TExecutor tExecutor = new TExecutor();
        String sql = "select hdd_name,capacity_hdd from hdd;";
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);){
            tExecutor.execQuery(connection,sql,resultSet -> {
                while (resultSet.next()){
                    String name = resultSet.getString("hdd_name");
                    int capacity = resultSet.getInt("capacity_hdd");
                    System.out.println(name);
                    System.out.println(capacity);
            }
            return null;
            });
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
