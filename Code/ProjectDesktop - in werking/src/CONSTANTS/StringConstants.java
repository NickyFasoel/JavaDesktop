package CONSTANTS;

/*
 * Voordelen: 
 * Type safety and value safety.
 * Guaranteed singleton.
 * Ability to define methods.
 * Ability to use values in switch statement case statements.
 */

public enum StringConstants {
    /* Constanten in de enum die de private constructor 1 malig gebruiken dus van nature singleton zijn */
    /* Kolomnamen database voor Film object */
    NAAM_COLUMN ("Naam"), 
    SPEELUUR_COLUMN ("SpeelUren"), 
    SPEELDAGEN_COLUMN ("SpeelDagen"), 
    PRIJS_COLUMN ("Prijs"), 
    GENRE_COLUMN ("Genre"), 
    ACTIEF_COLUMN ("Actief"), 
    DESCRIPTION_COLUMN ("Beschrijving"), 
    FOTO_COLUMN ("Foto"), 
    /* Tot hier */
    ALL ("All"),
    EMPTY (""),
    /* Format string weergave op ticket */
    DECIMAL_FORMAT ("#.00"),
    TIME_FORMAT_HHMMSS ("HH:mm:ss"),
    TIME_FORMAT_HHMM ("HH:mm"),
    DATE_FORMAT ("dd/MM/yyyy"),
    PREP_QRY_INSERT_KLANT ("INSERT INTO tbl_klanten (Film,AantalTickets,UurVanAankoop,Datum,Prijs) VALUES (?,?,?,?,?)"),
    QRY_GET_ALL_FILMS ("SELECT * from tbl_film WHERE Actief = 1"),
    QRY_GET_ALL_GENRES ("SELECT DISTINCT `Genre` FROM `tbl_film`"),
    STARTFOTO_PATH ("Images/startFoto.png"),
    STARTDESCRIPTION ("Welcome to Kinepolis, select a movie from the list on your left to browse..."),
    DB_ERRORMSG ("The database must be offline..."),
    DB_ERRORMSG_TITLE ("Fetching data failed"),
    BUY_ERRORMSG ("You must select a movie first before buying tickets"),
    BUY_ERRORMSG_TITLE ("Attention"),
    NO_MORE_TICKETSMSG ("Our apologies but there are no tickets left"),
    JOPTION_RETRY ("Retry"),
    JOPTION_EXIT ("Exit"),
    EURO_SYMBOL ("€"),
    PAYMENTMSG ("PaymentScreen is not yet implemented.\nEnjoy your free movie!!!"),
    PAYMENT_TITLE ("Under construction..."),
    FAVICON_PATH ("Images/favicon.png"),
    FONT_SANSSERIF ("SansSerif"),
    DESCR_TITLE_TEXT ("Description                                                            Starts at: "),
    FONT_TIMER_PATH ("/Fonts/DS-DIGIB.TTF"),
    MAX_TICKET_AMOUNTMSG ("Can't buy more than 9 tickets at a time, if you need more.\nWe advise using one of our ticket windows.");
    
    
    private final String _value;
    
    private StringConstants(String value) {
        this._value = value;
    }
    
    public String getValue() {
        return this._value;
    }
    
}
