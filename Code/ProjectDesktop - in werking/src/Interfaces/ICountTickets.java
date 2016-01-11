package Interfaces;

import Dal.Vertoning;

public interface ICountTickets {

    int countTickets(Vertoning vertoning);

    boolean isRoom(Vertoning vertoning);
    
}
