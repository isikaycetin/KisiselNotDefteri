import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class NotDefteriUI implements Observer {
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> notList;
    private NotDAO notDAO;
    private int userId;
    private String userRole;

    public NotDefteriUI(Connection connection, NotDAO notDAO, int userId, String userRole) {
        this.notDAO = notDAO;
        this.userId = userId;
        this.userRole = userRole;
        initialize();
        loadNotlar();
        notDAO.registerObserver(this);
    }

    private void initialize() {
        frame = new JFrame("Kişisel Not Defteri");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        notList = new JList<>(listModel);
        panel.add(new JScrollPane(notList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton ekleButton = new JButton("Ekle");
        JButton silButton = new JButton("Sil");
        JButton guncelleButton = new JButton("Güncelle");

        JButton kategoriFiltreButton = new JButton("Kategoriye Göre Listele");
        kategoriFiltreButton.addActionListener(e -> filterByKategori());
        buttonPanel.add(kategoriFiltreButton);


        ekleButton.addActionListener(e -> addNot());
        silButton.addActionListener(e -> deleteNot());
        guncelleButton.addActionListener(e -> updateNot());

        buttonPanel.add(ekleButton);
        buttonPanel.add(silButton);
        buttonPanel.add(guncelleButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void loadNotlar() {
        try {
            listModel.clear();
            List<Not> notlar;
            if ("admin".equals(userRole)) {
                notlar = notDAO.getAllNotlar();
            } else {
                notlar = notDAO.getNotlarByUserId(userId);
            }
            for (Not not : notlar) {
                listModel.addElement(not.getDetails());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addNot() {
        String baslik = JOptionPane.showInputDialog(frame, "Başlık:");
        String icerik = JOptionPane.showInputDialog(frame, "İçerik:");
        String kategori = JOptionPane.showInputDialog(frame, "Kategori:");
        if (baslik != null && icerik != null && kategori != null) {
            try {
                Not yeniNot = new Not(0, baslik, icerik, new Date(System.currentTimeMillis()), userId, kategori);
                yeniNot.setDurum("Oluşturuldu"); // Durumu ayarlıyoruz
                yeniNot.action(); // Duruma bağlı işlem yapıyoruz
                notDAO.addNot(yeniNot.getBaslik(), yeniNot.getIcerik(), yeniNot.getKategori(), userId);
                loadNotlar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    private void deleteNot() {
        String selected = notList.getSelectedValue();
        if (selected != null) {
            String[] parts = selected.split(" - ");
            int id = Integer.parseInt(parts[0]);
            try {
                Not silinenNot = new Not(id, "", "", null, userId, "");
                silinenNot.setDurum("Silme"); // Durumu ayarlıyoruz
                silinenNot.action(); // Duruma bağlı işlem yapıyoruz
                if ("admin".equals(userRole)) {
                    notDAO.deleteAnyNot(id);
                } else {
                    notDAO.deleteNot(id, userId);
                }
                loadNotlar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Lütfen bir not seçin.");
        }
    }


    private void updateNot() {
        String selected = notList.getSelectedValue();
        if (selected != null) {
            String[] parts = selected.split(" - ");
            int id = Integer.parseInt(parts[0]);
            String newBaslik = JOptionPane.showInputDialog(frame, "Yeni Başlık:");
            String newIcerik = JOptionPane.showInputDialog(frame, "Yeni İçerik:");
            if (newBaslik != null && newIcerik != null) {
                try {
                    Not guncellenenNot = new Not(id, newBaslik, newIcerik, new Date(System.currentTimeMillis()), userId, "");
                    guncellenenNot.setDurum("Düzenleme"); // Durumu ayarlıyoruz
                    guncellenenNot.action(); // Duruma bağlı işlem yapıyoruz
                    notDAO.updateNot(id, newBaslik, newIcerik, userId);
                    loadNotlar();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Lütfen güncellemek için bir not seçin.");
        }
    }


    private void filterByKategori() {
        String kategori = JOptionPane.showInputDialog(frame, "Filtrelemek istediğiniz kategori:");
        if (kategori != null) {
            try {
                listModel.clear();
                List<Not> notlar = notDAO.getNotlarByKategori(kategori, userId);
                for (Not not : notlar) {
                    listModel.addElement(not.getDetails());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void update(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}
