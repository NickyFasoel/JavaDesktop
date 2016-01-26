package Tests;

import Dal.Film;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FilmTest {
    
    public FilmTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getId method, of class Film.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Film instance = new Film();
        instance.setId(12L);
        Long expResult = 12L;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Film.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Film instance = new Film();
        instance.setId(id);
    }

    /**
     * Test of getNaam method, of class Film.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        Film instance = new Film();
        instance.setNaam("Tarzan");
        String expResult = "Tarzan";
        String result = instance.getNaam();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNaam method, of class Film.
     */
    @Test
    public void testSetNaam() {
        System.out.println("setNaam");
        String naam = "";
        Film instance = new Film();
        instance.setNaam(naam);
        
    }

    /**
     * Test of getSpeelUren method, of class Film.
     */
    @Test
    public void testGetSpeelUren() {
        System.out.println("getSpeelUren");
        Film instance = new Film();
        instance.setSpeelUren("16:00, 19:00, 22:00");
        String expResult = "16:00, 19:00, 22:00";
        String result = instance.getSpeelUren();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeelUren method, of class Film.
     */
    @Test
    public void testSetSpeelUren() {
        System.out.println("setSpeelUren");
        String speelUren = "";
        Film instance = new Film();
        instance.setSpeelUren(speelUren);
    }

    /**
     * Test of getSpeelDagen method, of class Film.
     */
    @Test
    public void testGetSpeelDagen() {
        System.out.println("getSpeelDagen");
        Film instance = new Film();
        instance.setSpeelDagen("Maandag, Dinsdag, Zondag");
        String expResult = "Maandag, Dinsdag, Zondag";
        String result = instance.getSpeelDagen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpeelDagen method, of class Film.
     */
    @Test
    public void testSetSpeelDagen() {
        System.out.println("setSpeelDagen");
        String speelDagen = "";
        Film instance = new Film();
        instance.setSpeelDagen(speelDagen);
    }

    /**
     * Test of getPrijs method, of class Film.
     */
    @Test
    public void testGetPrijs() {
        System.out.println("getPrijs");
        Film instance = new Film();
        double expResult = 0.0;
        double result = instance.getPrijs();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPrijs method, of class Film.
     */
    @Test
    public void testSetPrijs() {
        System.out.println("setPrijs");
        double prijs = 0.0;
        Film instance = new Film();
        instance.setPrijs(prijs);
    }

    /**
     * Test of getGenre method, of class Film.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        Film instance = new Film();
        instance.setGenre("actie");
        String expResult = "actie";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGenre method, of class Film.
     */
    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        String genre = "";
        Film instance = new Film();
        instance.setGenre(genre);
        String result = instance.getGenre();
        assertEquals(genre, result);
    }

    /**
     * Test of getDescription method, of class Film.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Film instance = new Film();
        instance.setDescription("super");
        String expResult = "super";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Film.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Film instance = new Film();
        instance.setDescription(description);
        String result = instance.getDescription();
        assertEquals(description, result);
    }

    /**
     * Test of getImage method, of class Film.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Film instance = new Film();
        instance.setImage("haha");
        String expResult = "haha";
        String result = instance.getImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImage method, of class Film.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        String image = "";
        Film instance = new Film();
        instance.setImage(image);
        assertEquals(image, instance.getImage());
    }

    /**
     * Test of isActive method, of class Film.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Film instance = new Film();
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActive method, of class Film.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = true;
        Film instance = new Film();
        instance.setActive(active);
        assertEquals(active, instance.isActive());
    }

    /**
     * Test of getInfoBG method, of class Film.
     */
    @Test
    public void testGetInfoBG() {
        System.out.println("getInfoBG");
        Film instance = new Film();
        instance.setInfoBG("test");
        String expResult = "test";
        String result = instance.getInfoBG();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInfoBG method, of class Film.
     */
    @Test
    public void testSetInfoBG() {
        System.out.println("setInfoBG");
        String infoBG = "azerty";
        Film instance = new Film();
        instance.setInfoBG(infoBG);
        assertEquals(infoBG, instance.getInfoBG());
    }

    /**
     * Test of getImgCorr method, of class Film.
     */
    @Test
    public void testGetImgCorr() {
        System.out.println("getImgCorr");
        Film instance = new Film();
        instance.setImgCorr(32);
        int expResult = 32;
        int result = instance.getImgCorr();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImgCorr method, of class Film.
     */
    @Test
    public void testSetImgCorr() {
        System.out.println("setImgCorr");
        int imgCorr = 0;
        Film instance = new Film();
        instance.setImgCorr(imgCorr);
        assertEquals(imgCorr, instance.getImgCorr());
    }

    /**
     * Test of toString method, of class Film.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Film instance = new Film();
        instance.setNaam("Batman");
        String expResult = "Batman";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
