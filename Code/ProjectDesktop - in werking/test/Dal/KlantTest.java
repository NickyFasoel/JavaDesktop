package Dal;

import org.junit.Assert;
import org.junit.Test;

public class KlantTest {
    
    public KlantTest() {
    }
    
    @Test
    public void createKlant() {
        Klant k = new Klant("Freddy Krueger", 5, 10.5);
        Assert.assertEquals(true, 
                   "Freddy Krueger".equals(k.getFilm())
                && 5 == k.getAantalTickets()
                && 10.5 == k.getPrijs());
    }
}
