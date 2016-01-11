package PL;

import CONSTANTS.StringConstants;
import javax.swing.ImageIcon;
import org.junit.Assert;
import org.junit.Test;

public class UtilityTest {
    
    public UtilityTest() {}

     @Test
     public void testSetFaviconNFoto() {
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource(StringConstants.FAVICON_PATH.getValue());
        java.net.URL imageURL2 = cldr.getResource("Images/favicon.png");
        ImageIcon icon = new ImageIcon(imageURL);
        ImageIcon icon2 = new ImageIcon(imageURL2);
        
        Assert.assertEquals(true, imageURL.toString().equals(imageURL2.toString()) 
                && icon.getImage().equals(icon2.getImage()));
     }
     
}
