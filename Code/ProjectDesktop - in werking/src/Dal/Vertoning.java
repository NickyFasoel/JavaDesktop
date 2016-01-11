package Dal;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vertoning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filmNaam;
    private String speelDag;
    private String speelUur;
    private int zaalNummer;
    private double prijs;
    private int plaatsen;

    public Vertoning() {}

    public Vertoning(long id, String filmNaam, String speelDag, String speelUur, double prijs, int zaalNummer, int plaatsen) {
        this.id = id;
        this.filmNaam = filmNaam;
        this.speelDag = speelDag;
        this.speelUur = speelUur;
        this.zaalNummer = zaalNummer;
        this.prijs = prijs;
        this.plaatsen = plaatsen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return filmNaam;
    }

    public String getFilmNaam() {
        return filmNaam;
    }

    public void setFilmNaam(String filmNaam) {
        this.filmNaam = filmNaam;
    }

    public String getSpeelDag() {
        return speelDag;
    }

    public void setSpeelDag(String speelDag) {
        this.speelDag = speelDag;
    }

    public String getSpeelUur() {
        return speelUur;
    }

    public void setSpeelUur(String speelUur) {
        this.speelUur = speelUur;
    }

    public int getZaalNummer() {
        return zaalNummer;
    }

    public void setZaalNummer(int zaalNummer) {
        this.zaalNummer = zaalNummer;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getPlaatsen() {
        return plaatsen;
    }

    public void setPlaatsen(int plaatsen) {
        this.plaatsen = plaatsen;
    }
    
}
