package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

class DivideOperator implements Operator {

    @Override
    public char getOperatorCharacter() {
        return '/';
    }

    @Override
    public void apply(DoubleArrayStack stack) {
        double divideBy = stack.pop();
        if (divideBy == 0d) {
            throw new IllegalMathOperationException();
        }
        stack.push(stack.pop() / divideBy);
    }
}
