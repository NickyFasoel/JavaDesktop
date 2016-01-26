package Tests;

import Dal.Vertoning;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VertoningTest {
    
    public VertoningTest() {
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
     * Test of getId method, of class Vertoning.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Vertoning instance = new Vertoning();
        Long expResult = 12L;
        instance.setId(12L);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Vertoning.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 12L;
        Vertoning instance = new Vertoning();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of toString method, of class Vertoning.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vertoning instance = new Vertoning();
        String expResult = "SuperMuis";
        instance.setFilmNaam(expResult);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFilmNaam method, of class Vertoning.
     */
    @Test
    public void testGetFilmNaam() {
        System.out.println("getFilmNaam");
        Vertoning instance = new Vertoning();
        String expResult = "Freddy";
        instance.setFilmNaam(expResult);
        String result = instance.getFilmNaam();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilmNaam method, of class Vertoning.
     */
    @Test
    public void testSetFilmNaam() {
        System.out.println("setFilmNaam");
        String filmNaam = "Konijnen";
        Vertoning instance = new Vertoning();
        instance.setFilmNaam(filmNaam);
        assertEquals(filmNaam, instance.getFilmNaam());
    }

    /**
     * Test of getSpeelDag method, of class Vertoning.
     */
    @Test
    public void testGetSpeelDag() {
        System.out.println("getSpeelDag");
        Vertoning instance = new Vertoning();
        String expResult = "Maandag";
        instance.setSpeelDag(expResult);
        String result = instance.getSpeelDag();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeelDag method, of class Vertoning.
     */
    @Test
    public void testSetSpeelDag() {
        System.out.println("setSpeelDag");
        String speelDag = "Woensdag";
        Vertoning instance = new Vertoning();
        instance.setSpeelDag(speelDag);
        assertEquals(speelDag, instance.getSpeelDag());
    }

    /**
     * Test of getSpeelUur method, of class Vertoning.
     */
    @Test
    public void testGetSpeelUur() {
        System.out.println("getSpeelUur");
        Vertoning instance = new Vertoning();
        String expResult = "16:00";
        instance.setSpeelUur(expResult);
        String result = instance.getSpeelUur();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeelUur method, of class Vertoning.
     */
    @Test
    public void testSetSpeelUur() {
        System.out.println("setSpeelUur");
        String speelUur = "16:00";
        Vertoning instance = new Vertoning();
        instance.setSpeelUur(speelUur);
        assertEquals(speelUur, instance.getSpeelUur());
    }

    /**
     * Test of getZaalNummer method, of class Vertoning.
     */
    @Test
    public void testGetZaalNummer() {
        System.out.println("getZaalNummer");
        Vertoning instance = new Vertoning();
        int expResult = 12;
        instance.setZaalNummer(expResult);
        int result = instance.getZaalNummer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setZaalNummer method, of class Vertoning.
     */
    @Test
    public void testSetZaalNummer() {
        System.out.println("setZaalNummer");
        int zaalNummer = 42;
        Vertoning instance = new Vertoning();
        instance.setZaalNummer(zaalNummer);
        assertEquals(zaalNummer, instance.getZaalNummer());
    }

    /**
     * Test of getPrijs method, of class Vertoning.
     */
    @Test
    public void testGetPrijs() {
        System.out.println("getPrijs");
        Vertoning instance = new Vertoning();
        double expResult = 4.20;
        instance.setPrijs(expResult);
        double result = instance.getPrijs();
        assertEquals(expResult, result, 4.20);
    }

    /**
     * Test of setPrijs method, of class Vertoning.
     */
    @Test
    public void testSetPrijs() {
        System.out.println("setPrijs");
        double prijs = 4.20;
        Vertoning instance = new Vertoning();
        instance.setPrijs(prijs);
        assertEquals(prijs, instance.getPrijs(), 4.20);
    }

    /**
     * Test of getPlaatsen method, of class Vertoning.
     */
    @Test
    public void testGetPlaatsen() {
        System.out.println("getPlaatsen");
        Vertoning instance = new Vertoning();
        int expResult = 42;
        instance.setPlaatsen(expResult);
        int result = instance.getPlaatsen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlaatsen method, of class Vertoning.
     */
    @Test
    public void testSetPlaatsen() {
        System.out.println("setPlaatsen");
        int plaatsen = 42;
        Vertoning instance = new Vertoning();
        instance.setPlaatsen(plaatsen);
        assertEquals(plaatsen, instance.getPlaatsen());
    }
    
}
