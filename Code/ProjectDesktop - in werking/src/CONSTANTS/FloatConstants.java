package CONSTANTS;

public enum FloatConstants {
    
    TWENTYSEVENF (27f);
    
    private final Float _value;
    
    private FloatConstants(Float value) {
        this._value = value;
    }
    
    public Float getValue() {
        return this._value;
    }
}
