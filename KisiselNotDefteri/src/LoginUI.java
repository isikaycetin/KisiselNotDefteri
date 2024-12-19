import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class LoginUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private Connection connection;

    public LoginUI(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Giriş Ekranı");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Kullanıcı Adı:");
        JLabel passwordLabel = new JLabel("Şifre:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Giriş Yap");
        registerButton = new JButton("Kayıt Ol");

        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> openRegisterForm());

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            String query = "SELECT * FROM Kullanıcılar WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userRole = resultSet.getString("role");
                JOptionPane.showMessageDialog(frame, "Giriş Başarılı!");
                NotDAO notDAO = NotDAOFactory.createNotDAO(connection, userRole, userId);
                new NotDefteriUI(connection, notDAO, userId, userRole);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Kullanıcı adı veya şifre hatalı!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void openRegisterForm() {
        new RegisterUI(connection);
    }
}
