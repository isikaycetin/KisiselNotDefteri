import java.sql.Date;
import java.util.List;

public class NotDecorator extends Not {
    private Not decoratedNot;

    public NotDecorator(Not not) {
        super(not.getId(), not.getBaslik(), not.getIcerik(), not.getTarih(), not.getUserId(), not.getKategori());
        this.decoratedNot = not;
    }

    // Etiketleri elde et
    @Override
    public List<String> getTags() {
        return decoratedNot.getTags();
    }

    // Etiket ekle
    @Override
    public void addTag(String tag) {
        decoratedNot.addTag(tag);
    }

    // Etiket sil
    @Override
    public void removeTag(String tag) {
        decoratedNot.removeTag(tag);
    }

    // Diğer mevcut metodları devralma
    public int getId() {
        return decoratedNot.getId();
    }

    public String getBaslik() {
        return decoratedNot.getBaslik();
    }

    public String getIcerik() {
        return decoratedNot.getIcerik();
    }

    public Date getTarih() {
        return decoratedNot.getTarih();
    }

    public int getUserId() {
        return decoratedNot.getUserId();
    }
}
