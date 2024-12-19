import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class RegisterUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private Connection connection;

    public RegisterUI(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Kayıt Ekranı");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // 3 satır, 2 sütun

        JLabel usernameLabel = new JLabel("Kullanıcı Adı:");
        JLabel passwordLabel = new JLabel("Şifre:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        registerButton = new JButton("Kayıt Ol");
        registerButton.addActionListener(e -> register());

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            String checkUserQuery = "SELECT * FROM Kullanıcılar WHERE username = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkUserQuery);
            checkStatement.setString(1, username);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(frame, "Bu kullanıcı adı zaten mevcut.");
            } else {
                String insertQuery = "INSERT INTO Kullanıcılar (username, password) VALUES (?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setString(1, username);
                insertStatement.setString(2, password);
                insertStatement.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Kayıt başarılı! Şimdi giriş yapabilirsiniz.");
                frame.dispose();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
