package Tests;

import Dal.Klant;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KlantTest {
    
    public KlantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Klant.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Klant instance = new Klant();
        Long expResult = 12L;
        instance.setId(12L);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Klant.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 12L;
        Klant instance = new Klant();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getVertoning method, of class Klant.
     */
    @Test
    public void testGetVertoning() {
        System.out.println("getVertoning");
        Klant instance = new Klant();
        instance.setVertoning(13L);
        long expResult = 13L;
        long result = instance.getVertoning();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVertoning method, of class Klant.
     */
    @Test
    public void testSetVertoning() {
        System.out.println("setVertoning");
        long vertoningID = 42L;
        Klant instance = new Klant();
        instance.setVertoning(vertoningID);
        assertEquals(vertoningID, instance.getVertoning());
    }

    /**
     * Test of getAantalTickets method, of class Klant.
     */
    @Test
    public void testGetAantalTickets() {
        System.out.println("getAantalTickets");
        Klant instance = new Klant();
        instance.setAantalTickets(34);
        int expResult = 34;
        int result = instance.getAantalTickets();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAantalTickets method, of class Klant.
     */
    @Test
    public void testSetAantalTickets() {
        System.out.println("setAantalTickets");
        int aantalTickets = 42;
        Klant instance = new Klant();
        instance.setAantalTickets(aantalTickets);
        assertEquals(aantalTickets, instance.getAantalTickets());
    }

    /**
     * Test of getDatum method, of class Klant.
     */
    @Test
    public void testGetDatum() {
        System.out.println("getDatum");
        Klant instance = new Klant();
        String expResult = "19/03/2016";
        instance.setDatum("19/03/2016");
        String result = instance.getDatum();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDatum method, of class Klant.
     */
    @Test
    public void testSetDatum() {
        System.out.println("setDatum");
        String datum = "19/03/2016";
        Klant instance = new Klant();
        instance.setDatum(datum);
        assertEquals(datum, instance.getDatum());
    }

    /**
     * Test of getPrijs method, of class Klant.
     */
    @Test
    public void testGetPrijs() {
        System.out.println("getPrijs");
        Klant instance = new Klant();
        double expResult = 4.20;
        double result = instance.getPrijs();
        assertEquals(expResult, result, 4.20);
    }

    /**
     * Test of setPrijs method, of class Klant.
     */
    @Test
    public void testSetPrijs() {
        System.out.println("setPrijs");
        double prijs = 4.20;
        Klant instance = new Klant();
        instance.setPrijs(prijs);
        double result = instance.getPrijs();
        assertEquals(prijs, result, 4.20);
    }

    /**
     * Test of getZaalNummer method, of class Klant.
     */
    @Test
    public void testGetZaalNummer() {
        System.out.println("getZaalNummer");
        Klant instance = new Klant();
        int expResult = 0;
        int result = instance.getZaalNummer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setZaalNummer method, of class Klant.
     */
    @Test
    public void testSetZaalNummer() {
        System.out.println("setZaalNummer");
        int zaalNummer = 42;
        Klant instance = new Klant();
        instance.setZaalNummer(zaalNummer);
        assertEquals(zaalNummer, instance.getZaalNummer());
    }   
}
