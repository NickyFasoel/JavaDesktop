package BLL;

import CONSTANTS.CharConstants;
import CONSTANTS.IntConstants;
import Dal.Klant;

public class CreateAKlant {
    
    private String removeCurrencySymbol(String str){
        String temp = str.replace(CharConstants.COMMA.getValue(), CharConstants.DOT.getValue());
        return temp.substring(IntConstants.ONE.getValue());
    }
    
    public Klant createKlant(String filmNaam, int aantalTickets, String prijs) {
        return new Klant(filmNaam, aantalTickets, Double.parseDouble(removeCurrencySymbol(prijs)));
    }
    
}
