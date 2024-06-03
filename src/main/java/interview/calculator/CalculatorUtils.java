package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CalculatorUtils {

    private CalculatorUtils() {}

    private static final Map<Character, Operator> RPN_OPERATORS = new HashMap<>();

    static {
        var operatorsToUse = List.of(
                new AddOperator(),
                new SubtractOperator(),
                new MultiplyOperator(),
                new DivideOperator(),
                new AbsoluteOperator(),
                new MaxAbsoluteOperator()
        );
        operatorsToUse.forEach(operator -> RPN_OPERATORS.put(operator.getOperatorCharacter(), operator));
    }

    public static double calculateRpn(String input) {
        DoubleArrayStack stack = new DoubleArrayStack();
        String[] characters = input.split(" ");

        for (String strCharacter: characters) {
            char character = strCharacter.charAt(0);
            if (isDigit(strCharacter)) {
                stack.push(Double.parseDouble(strCharacter));
            } else if (RPN_OPERATORS.containsKey(character)) {
                Operator operator = RPN_OPERATORS.get(character);
                operator.apply(stack);
            } else {
                throw new CharacterNotSupportedException(strCharacter);
            }
        }

        return stack.pop();
    }

    public static boolean isDigit(String input) {
        // if any char is digit it is probably a digit
        for (var inputChar: input.toCharArray()) {
            if (inputChar >= '0' && inputChar <= '9') {
                return true;
            }
        }
        return false;
    }
}
