import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class AdminUserDAO extends NotDAO {
    public AdminUserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Not> getAllNotlar() throws SQLException {
        List<Not> notlar = new ArrayList<>();
        String query = "SELECT * FROM KisiselNotlar";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                notlar.add(new Not(
                        resultSet.getInt("id"),
                        resultSet.getString("baslik"),
                        resultSet.getString("icerik"),
                        resultSet.getDate("tarih"), // Tarih alanı için Date tipi eklendi
                        resultSet.getInt("user_id"),//
                        resultSet.getString("kategori")
                ));
            }
        }
        return notlar;
    }


    public void deleteAnyNot(int id) throws SQLException {
        String query = "DELETE FROM KisiselNotlar WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    public void updateNot(int id, String baslik, String icerik, int userId) throws SQLException {
        String query = "UPDATE KisiselNotlar SET baslik = ?, icerik = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, baslik);
            statement.setString(2, icerik);
            statement.setInt(3, userId);
            statement.setInt(4, id);
            statement.executeUpdate();
        }
    }
}
