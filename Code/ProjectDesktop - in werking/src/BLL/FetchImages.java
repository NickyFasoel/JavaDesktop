package BLL;

import Interfaces.ISetFavicon;
import Interfaces.ISetFilmFoto;
import CONSTANTS.StringConstants;
import javax.swing.ImageIcon;

public class FetchImages implements ISetFilmFoto, ISetFavicon {
    
    @Override
    public ImageIcon setFoto(String path) {
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource(path);
        ImageIcon icon = new ImageIcon(imageURL);
        return icon;
    }
    
    @Override
    public ImageIcon setFavicon() {
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource(StringConstants.FAVICON_PATH.getValue());
        ImageIcon icon = new ImageIcon(imageURL);
        return icon;
    }
    
}
