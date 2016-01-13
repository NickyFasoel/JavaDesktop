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

    private long vertoningID;
    private int zaalNummer;
    private int aantalTickets;
    private String datum;
    private double prijs;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Klant(long vertoningID, int aantalTickets, int zaalNummer, double prijs) {
        this.vertoningID = vertoningID;
        this.aantalTickets = aantalTickets;
        this.zaalNummer = zaalNummer;
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

    public long getVertoning() {
        return vertoningID;
    }

    public void setVertoning(long vertoningID) {
        this.vertoningID = vertoningID;
    }

    public int getAantalTickets() {
        return aantalTickets;
    }

    public void setAantalTickets(int aantalTickets) {
        this.aantalTickets = aantalTickets;
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

    public int getZaalNummer() {
        return zaalNummer;
    }

    public void setZaalNummer(int zaalNummer) {
        this.zaalNummer = zaalNummer;
    }
    
}