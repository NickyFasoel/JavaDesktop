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
   // TODO: alle constante checke als ze gebruikt worde
    NAAM_COLUMN ("Naam"), 
    SPEELUREN_COLUMN ("SpeelUren"), 
    SPEELDAGEN_COLUMN ("SpeelDagen"), 
    PRIJS_COLUMN ("Prijs"), 
    GENRE_COLUMN ("Genre"), 
    ACTIEF_COLUMN ("Actief"), 
    DESCRIPTION_COLUMN ("Beschrijving"), 
    FOTO_COLUMN ("Foto"),
    SHOWINFOBACKGROUNDIMAGE_COLUMN ("ShowInfoBackgroundImage"),
    BGIMAGECORRECTION_COLUMN ("BgImageCorrection"),
    ID_COLUMN ("ID"),
    SPEELDAG_COLUMN ("SpeelDag"),
    SPEELUUR_COLUMN ("SpeelUur"),
    NUMMER_COLUMN ("Nummer"),
    PLAATSEN_COLUMN ("Plaatsen"),
    ALL ("All"),
    EMPTY (""),
    /* Format string weergave op ticket */
    DECIMAL_FORMAT ("#.00"),
    TIME_FORMAT_HHMMSS ("HH:mm:ss"),
    TIME_FORMAT_HHMM ("HH:mm"),
    DATE_FORMAT ("dd/MM/yyyy"),
    PREP_QRY_INSERT_KLANT ("INSERT INTO tbl_tickets (Vertoning_ID, Aantal, Zaal_Nummer, Datum, Prijs) VALUES (?, ?, ?, ?, ?)"),
    QRY_GET_ALL_FILMS ("SELECT * from tbl_film WHERE Actief = 1"),
    QRY_GET_ALL_SHOWS ("SELECT tbl_vertoning.ID, a.naam, tbl_vertoning.SpeelDag, tbl_vertoning.SpeelUur, a.prijs, tbl_zaal.Nummer, tbl_zaal.Plaatsen FROM tbl_film AS a INNER JOIN tbl_vertoning ON a.ID = tbl_vertoning.Film_ID INNER JOIN tbl_zaal ON tbl_zaal.ID = tbl_vertoning.Zaal_ID"),
    QRY_GET_ALL_GENRES ("SELECT DISTINCT `Genre` FROM `tbl_film`"),
    STARTFOTO_PATH ("Images/startFoto.png"),
    STARTDESCRIPTION ("Welcome to Kinepolis, select a movie from the list on your left to browse..."),
    DB_ERRORMSG ("The database must be offline..."),
    DB_ERRORMSG_TITLE ("Fetching data failed"),
    BUY_ERRORMSG ("You must select a movie first before buying tickets"),
    ATTENTION ("Attention"),
    NO_MORE_TICKETSMSG ("Our apologies but there are no tickets left"),
    JOPTION_RETRY ("Retry"),
    JOPTION_EXIT ("Exit"),
    EURO_SYMBOL ("€"),
    PAYMENTMSG ("PaymentScreen is not yet implemented.\nEnjoy your free movie!!!"),
    PAYMENT_TITLE ("Under construction..."),
    FAVICON_PATH ("Images/favicon.png"),
    FONT_SANSSERIF ("SansSerif"),
    FONT_TIMER_PATH ("/Fonts/DS-DIGIB.TTF"),
    MAX_TICKET_AMOUNTMSG ("Can't buy more than 9 tickets at a time, if you need more.\nWe advise using one of our ticket windows."),
    SHOW_INFO_ERRORMSG ("You must select a movie before we can show information."),
    ONE_SPACE (" "),
    SIXTEEN_HOURS ("16:00"),
    NINETEEN_HOURS ("19:00"),
    TWENTY_TWO_HOURS ("22:00"),
    FULLNAME_DAY_OF_THE_WEEK_FORMAT ("EEEE"),
    MOVIE_ALREADY_DONE ("This movie has already begun/finished."),
    NO_TIME_SELECTED ("You have no time specified for the movie."),
    NOT_ENOUGH_TICKETS ("Not enough tickets left."),
    NO_TICKETS_LEFT ("Our apologies but this movie is sold out.");
    
    
    private final String _value;
    
    private StringConstants(String value) {
        this._value = value;
    }
    
    public String getValue() {
        return this._value;
    }
    
}
