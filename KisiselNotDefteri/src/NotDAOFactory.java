import java.sql.Connection;
import java.sql.SQLException;

public class NotDAOFactory {
    public static NotDAO createNotDAO(Connection connection, String userRole, int userId) {
        switch (userRole) {
            case "admin":
                return new AdminUserDAO(connection);
            case "user":
                return new RegularUserDAO(connection);
            default:
                throw new IllegalArgumentException("Geçersiz kullanıcı rolü");
        }
    }
}
