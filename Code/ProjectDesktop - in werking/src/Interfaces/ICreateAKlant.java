package Interfaces;

import Dal.Klant;

public interface ICreateAKlant {

    Klant createKlant(long vertoningID, int aantalTickets, int zaalNummer, double prijs);
    
}
