import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String user = "root";
        String password = "root";

        String query = "UPDATE users SET username = ?, password = ? WHERE idusers = ?";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = con.prepareStatement(query);
        ) {

            // New values
            ps.setString(1, "updatedUser");
            ps.setString(2, "updatedPass");

            // Condition (which record to update)
            ps.setInt(3, 2);   // change ID as needed

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("No record found with given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }

