package BLL;

import Interfaces.ICountTickets;
import CONSTANTS.IntConstants;
import Interfaces.IGetData;
import Dal.Helpers.FetchFilmData;
import Dal.Vertoning;
import java.util.ArrayList;

public class CountTickets implements ICountTickets {
    
    @Override
    public int countTickets(Vertoning vertoning) {
        int amountOfTickets = IntConstants.ZERO.getValue();
        IGetData iGD = new FetchFilmData();
        ArrayList<Integer> lst = iGD.getTicketsPerVertoning(vertoning);
        for (Integer number : lst) {
            amountOfTickets += number;
        }
        return amountOfTickets;
    }
    
    @Override
    public boolean isRoom(Vertoning vertoning) {
        int amountOfTickets;
        amountOfTickets = countTickets(vertoning);
        return amountOfTickets < IntConstants.EIGHTY_TWO.getValue();
    }
}
