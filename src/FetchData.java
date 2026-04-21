import java.sql.*;

public class FetchData {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login_schema", "root", "root");

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT* FROM USERS");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("Password"));
            }
        }
        catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
