import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Not extends BaseNot {
    private List<String> etiketler;
    private String kategori;

    public Not(int id, String baslik, String icerik, Date tarih, int userId, String kategori) {
        super(id, baslik, icerik, tarih, userId);
        this.etiketler = new ArrayList<>();
        this.kategori = kategori;
    }

    // Etiket ekleme
    public void addTag(String tag) {
        if (!etiketler.contains(tag)) {
            etiketler.add(tag);
        }
    }

    // Etiket silme
    public void removeTag(String tag) {
        etiketler.remove(tag);
    }

    // Etiketleri alma
    public List<String> getTags() {
        return new ArrayList<>(etiketler);
    }

    // Kategori getter ve setter
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public void displayDetails() {
        System.out.println("Not ID: " + getId());
        System.out.println("Başlık: " + getBaslik());
        System.out.println("İçerik: " + getIcerik());
        System.out.println("Tarih: " + getTarih());
        System.out.println("Kullanıcı ID: " + getUserId());
        System.out.println("Durum: " + getDurum());
        System.out.println("Kategori: " + kategori);
        System.out.println("Etiketler: " + String.join(", ", etiketler));
    }


    public String getDetails() {
        return getId() + " - " + getBaslik() + " [" + kategori + "]: " + getIcerik();
    }

    @Override
    public String toString() {
        return getId() + " - " + getBaslik() + " (" + kategori + ", " + getDurum() + ")";
    }
}
