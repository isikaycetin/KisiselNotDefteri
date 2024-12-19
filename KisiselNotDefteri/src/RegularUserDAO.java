import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegularUserDAO extends NotDAO {
    public RegularUserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Not> getNotlarByUserId(int userId) throws SQLException {
        List<Not> notlar = new ArrayList<>();
        String query = "SELECT * FROM KisiselNotlar WHERE user_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                notlar.add(new Not(
                        resultSet.getInt("id"),
                        resultSet.getString("baslik"),
                        resultSet.getString("icerik"),
                        resultSet.getDate("tarih"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("kategori")//
                ));
            }
        }
        return notlar;
    }
}