import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;

public class Main {
    public static void main(String[] args) {
        try {
            // Veritabanı bağlantısını sağlayın
            Connection connection = DatabaseConnection.getInstance().getConnection();

            // Kullanıcı giriş ekranını başlat
            new LoginUI(connection);

            // Kayıt butonuna tıklama işlemini dinleyerek yeni bir RegisterUI penceresi açalım
            JButton registerButton = new JButton("Kayıt Ol");
            registerButton.addActionListener(e -> new RegisterUI(connection));

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Veritabanına bağlanırken bir sorun oluştu.");
        }
    }
}
