import java.sql.*;

public class InsertData {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String user = "root";
        String password = "root";

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = con.prepareStatement(query);
        ) {

            ps.setString(1, "user3");
            ps.setString(2, "123");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}