package Dal;

// <editor-fold defaultstate="collapsed" desc="Imports">

import BLL.FormatDateNTime;
import Interfaces.IFormatDate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// </editor-fold>

@Entity
public class Klant implements Serializable {
    
    // <editor-fold defaultstate="collapsed" desc="Private Member Variables">

    private String film;
    private int aantalTickets;
    private String uurVanAankoop;
    private String datum;
    private double prijs;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Klant(String film, int aantalTickets, double prijs) {
        this.film = film;
        this.aantalTickets = aantalTickets;
        this.uurVanAankoop = new FormatDateNTime().getFormattedTimeOfDay();
        IFormatDate iFD = new FormatDateNTime();
        this.datum = iFD.getFormattedDate();
        this.prijs = prijs;
    }
    
    public Klant() {}
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Public Properties">
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getAantalTickets() {
        return aantalTickets;
    }

    public void setAantalTickets(int aantalTickets) {
        this.aantalTickets = aantalTickets;
    }

    public String getUurVanAankoop() {
        return uurVanAankoop;
    }

    public void setUurVanAankoop(String uurVanAankoop) {
        this.uurVanAankoop = uurVanAankoop;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
    
    // </editor-fold>
    
}