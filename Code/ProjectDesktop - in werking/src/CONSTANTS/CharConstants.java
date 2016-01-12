package CONSTANTS;

public enum CharConstants {
    COMMA (','),
    DOT ('.'),
    ONE_SPACE (' ');
    
    private final char _value;
    
    private CharConstants(char value) {
        this._value = value;
    }
    
    public char getValue() {
        return this._value;
    }
}
