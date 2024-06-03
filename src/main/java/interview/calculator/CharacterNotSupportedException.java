package interview.calculator;

public class CharacterNotSupportedException extends RuntimeException {
    public CharacterNotSupportedException(String character) {
        super("Character not supported: " + character);
    }
}
