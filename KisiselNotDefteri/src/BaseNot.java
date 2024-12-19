import java.sql.Date;
import java.util.List;

public abstract class BaseNot {
    private int id;
    private String baslik;
    private String icerik;
    private Date tarih;
    private int userId;
    private String durum;

    public BaseNot(int id, String baslik, String icerik, Date tarih, int userId) {
        this.id = id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.tarih = tarih;
        this.userId = userId;
        this.durum = "oluşturuldu"; // Varsayılan durum
    }

    // Getters ve Setters
    public int getId() {
        return id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    // Abstract Method
    public abstract void displayDetails();

    // Duruma göre işlem
    public void action() {
        if ("Oluşturuldu".equals(durum)) {
            System.out.println("Not oluşturuluyor...");
        } else if ("Düzenleme".equals(durum)) {
            System.out.println("Not düzenleniyor...");
        } else if ("Silme".equals(durum)) {
            System.out.println("Not siliniyor...");
        }
    }
}
