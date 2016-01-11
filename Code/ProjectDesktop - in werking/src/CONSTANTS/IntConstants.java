package CONSTANTS;

public enum IntConstants {
    
    ZERO (0),
    ONE (1),
    TWO (2),
    NINE (9),
    TWENTY_TWO (22),
    FIFTY (50),
    ONE_THOUSAND (1000),
    MINUS_ONE (-1),
    EIGHTEEN (18),
    EIGHTY_TWO (82),
    SIXTY_THOUSAND (60000);
    
    private final int _value;
    
    private IntConstants(int value) {
        this._value = value;
    }
    
    public int getValue() {
        return this._value;
    }
}
