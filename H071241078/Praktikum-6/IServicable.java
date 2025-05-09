import java.util.Date;

public interface IServicable {
    boolean periksaKondisi();
    void lakukanServis();
    Date getWaktuServisBerikutnya();
    double hitungBiayaServis();
}
