package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

public class SubtractOperator implements Operator {
    @Override
    public char getOperatorCharacter() {
        return '-';
    }

    @Override
    public void apply(DoubleArrayStack stack) {
        double subtrahend = stack.pop();
        stack.push(stack.pop() - subtrahend);
    }
}
