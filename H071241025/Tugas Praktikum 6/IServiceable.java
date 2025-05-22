import java.util.Date;

interface IServiceable {
    boolean periksaKondisi();
    void lakukanService();
    Date getWaktuServisBerikutnya();
    double hitungBiayaServis();
}
