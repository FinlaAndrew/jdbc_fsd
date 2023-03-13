package ustbatchno3.jdbc;
import java.sql.*;

public class App {
  public static void main(String[] args) {
    
    String url = "jdbc:mysql://localhost:3306/eira";
    String username = "root";
    String password = "pass@word1";

    try {
      
      Connection conn = DriverManager.getConnection(url, username, password);

      
      Statement stmt = conn.createStatement();

      String sql = "CREATE TABLE employee ("
                 + "id INT NOT NULL AUTO_INCREMENT,"
                 + "name VARCHAR(255),"
                 + "age INT,"
                 + "department VARCHAR(255),"
                 + "PRIMARY KEY (id)"
                 + ")";
      stmt.executeUpdate(sql);

     
      stmt.close();
      conn.close();
      
      System.out.println("Employee table created successfully!");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
