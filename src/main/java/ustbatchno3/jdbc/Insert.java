package ustbatchno3.jdbc;

import java.sql.*;

public class Insert {
  public static void main(String[] args) {
    // Set up database connection parameters
    String url = "jdbc:mysql://localhost:3306/eira";
    String username = "root";
    String password = "pass@word1";

    try {
      // Create a connection to the database
      Connection conn = DriverManager.getConnection(url, username, password);

      // Create a prepared statement for inserting data
      String sql = "INSERT INTO employee (name, age, department) VALUES (?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);

      // Set the parameter values for multiple rows of data
      String[] names = {"Joffin", "Josef", "Jofna"};
      int[] ages = {26, 2, 42};
      String[] departments = {"Sales", "Marketing", "Engineering"};

      for (int i = 0; i < names.length; i++) {
        pstmt.setString(1, names[i]);
        pstmt.setInt(2, ages[i]);
        pstmt.setString(3, departments[i]);
        pstmt.executeUpdate();
      }

      // Close the prepared statement and connection objects
      pstmt.close();
      conn.close();

      System.out.println("Data inserted successfully!");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

