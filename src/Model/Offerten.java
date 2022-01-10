package Model;

public class Offerten {
    private int id;
    private String unternehmensname;
    private long preis;
    private double mehrwertsteuer;
    private String adresse;
    private Ort ort;

    public Offerten(int id, String unternehmensname, long preis, double mehrwertsteuer, String adresse, Ort ort) {
        this.id = id;
        this.unternehmensname = unternehmensname;
        this.preis = preis;
        this.mehrwertsteuer = mehrwertsteuer;
        this.adresse = adresse;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnternehmensname() {
        return unternehmensname;
    }

    public void setUnternehmensname(String unternehmensname) {
        this.unternehmensname = unternehmensname;
    }

    public long getPreis() {
        return preis;
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }

    public double getMehrwertsteuer() {
        return mehrwertsteuer;
    }

    public void setMehrwertsteuer(double mehrwertsteuer) {
        this.mehrwertsteuer = mehrwertsteuer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Offerten{" +
                "id=" + id +
                ", unternehmensname='" + unternehmensname + '\'' +
                ", preis=" + preis +
                ", mehrwertsteuer=" + mehrwertsteuer +
                ", adresse='" + adresse + '\'' +
                ", ort=" + ort.getNotation() +
                '}';
    }
}
