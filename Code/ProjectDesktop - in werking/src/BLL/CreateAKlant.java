package BLL;

import Interfaces.ICreateAKlant;
import CONSTANTS.CharConstants;
import CONSTANTS.IntConstants;
import CONSTANTS.StringConstants;
import Dal.Klant;
import java.text.DecimalFormat;

public class CreateAKlant implements ICreateAKlant {
    
    @Override
    public Klant createKlant(long vertoningID, int aantalTickets, int zaalNummer, double prijs) {
        DecimalFormat fm = new DecimalFormat(StringConstants.DECIMAL_FORMAT.getValue());
        String temp = fm.format(prijs).replace(CharConstants.COMMA.getValue(), CharConstants.DOT.getValue());
        Double valueOf = Double.valueOf(temp);
        return new Klant(vertoningID, aantalTickets, zaalNummer, valueOf);
    }
    
}
