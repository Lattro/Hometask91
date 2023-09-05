import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect
{
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "5467Latro");
            return connection;
        }
        catch (ClassNotFoundException exception)
        {
            System.out.println(exception.getMessage());
        }
        catch (SQLException exception)
        {
            System.out.println(exception.getMessage());
        }
        return connection;
    }
}
