package Dal;

// <editor-fold defaultstate="collapsed" desc="Imports">

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// </editor-fold>

@Entity
public class Film implements Serializable {
    
    // <editor-fold defaultstate="collapsed" desc="Private Member Variables">
    
    private String naam;
    private String speelUren;
    private String speelDagen;
    private double prijs;
    private String genre;
    private boolean active;
    private String description;
    private String image;
    private String infoBG;
    private int imgCorr;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Film(Long id, String naam, String speelUren, String speelDagen, 
            double prijs, String genre, boolean active,
            String description, String foto, String infoBG, int imgCorr) {
        this.id = id;
        this.naam = naam;
        this.speelUren = speelUren;
        this.speelDagen = speelDagen;
        this.prijs = prijs;
        this.genre = genre;
        this.active = active;
        this.description = description;
        this.image = foto;
        this.infoBG = infoBG;
        this.imgCorr = imgCorr;
    }

    public Film() {}
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Public Properties">
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSpeelUren() {
        return speelUren;
    }

    public void setSpeelUren(String speelUren) {
        this.speelUren = speelUren;
    }

    public String getSpeelDagen() {
        return speelDagen;
    }

    public void setSpeelDagen(String speelDagen) {
        this.speelDagen = speelDagen;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public String getInfoBG() {
        return infoBG;
    }

    public void setInfoBG(String infoBG) {
        this.infoBG = infoBG;
    }

    public int getImgCorr() {
        return imgCorr;
    }

    public void setImgCorr(int imgCorr) {
        this.imgCorr = imgCorr;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    
    @Override
    public String toString() {
        return naam;
    }
    
    // </editor-fold> 

    
      
}