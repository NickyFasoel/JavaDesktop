package BLL;

import CONSTANTS.StringConstants;
import Interfaces.ISetFavicon;
import javax.swing.ImageIcon;

public class FetchFavicon implements ISetFavicon {
    
    @Override
    public ImageIcon setFavicon() {
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource(StringConstants.FAVICON_PATH.getValue());
        ImageIcon icon = new ImageIcon(imageURL);
        return icon;
    }
    
}
