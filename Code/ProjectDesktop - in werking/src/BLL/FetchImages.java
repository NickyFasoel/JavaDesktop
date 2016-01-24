package BLL;

import Interfaces.ISetFoto;
import javax.swing.ImageIcon;

public class FetchImages implements ISetFoto {
    
    @Override
    public ImageIcon setFoto(String path) {
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource(path);
        ImageIcon icon = new ImageIcon(imageURL);
        return icon;
    }
    
}
