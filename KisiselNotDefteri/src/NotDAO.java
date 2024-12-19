import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public abstract class NotDAO extends Observable {
    protected Connection connection;

    public NotDAO(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }

    // Kullanıcının kendi notlarını getirme
    public List<Not> getNotlarByUserId(int userId) throws SQLException {
        List<Not> notlar = new ArrayList<>();
        String query = "SELECT * FROM KisiselNotlar WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                notlar.add(new Not(
                        resultSet.getInt("id"),
                        resultSet.getString("baslik"),
                        resultSet.getString("icerik"),
                        resultSet.getDate("tarih"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("kategori")
                ));
            }
        }
        return notlar;
    }

    // Tüm notları getirme (admin için)
    public List<Not> getAllNotlar() throws SQLException {
        List<Not> notlar = new ArrayList<>();
        String query = "SELECT * FROM KisiselNotlar";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                notlar.add(new Not(
                        resultSet.getInt("id"),
                        resultSet.getString("baslik"),
                        resultSet.getString("icerik"),
                        resultSet.getDate("tarih"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("kategori")
                ));
            }
        }
        return notlar;
    }

    // Yeni not ekleme
    public void addNot(String baslik, String icerik, String kategori, int userId) throws SQLException {
        String query = "INSERT INTO KisiselNotlar (baslik, icerik, kategori, user_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, baslik);
            statement.setString(2, icerik);
            statement.setString(3, kategori);
            statement.setInt(4, userId);
            statement.executeUpdate();
            notifyObservers("Yeni not eklendi: " + baslik + " (Kategori: " + kategori + ")");
        }
    }


    // Kullanıcının kendi notunu silme
    public void deleteNot(int id, int userId) throws SQLException {
        String query = "DELETE FROM KisiselNotlar WHERE id = ? AND user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.setInt(2, userId);
            statement.executeUpdate();
            notifyObservers("Not silindi.");
        }
    }

    // Belirli bir notu güncelleme
    public void updateNot(int id, String baslik, String icerik, int userId) throws SQLException {
        String query = "UPDATE KisiselNotlar SET baslik = ?, icerik = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, baslik);
            statement.setString(2, icerik);
            statement.setInt(3, userId);
            statement.setInt(4, id);
            statement.executeUpdate();
            notifyObservers("Not güncellendi: " + baslik);
        }
    }

    public void deleteAnyNot(int id) throws SQLException {
        String query = "DELETE FROM KisiselNotlar WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            notifyObservers("Not silindi: ID=" + id);
        }
    }

    public List<Not> getNotlarByKategori(String kategori, int userId) throws SQLException {
        List<Not> notlar = new ArrayList<>();
        String query = "SELECT * FROM KisiselNotlar WHERE kategori = ? AND user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, kategori);
            statement.setInt(2, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                notlar.add(new Not(
                        resultSet.getInt("id"),
                        resultSet.getString("baslik"),
                        resultSet.getString("icerik"),
                        resultSet.getDate("tarih"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("kategori")
                ));
            }
        }
        return notlar;
    }
}
