package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

class MultiplyOperator implements Operator {

    @Override
    public char getOperatorCharacter() {
        return 'x';
    }

    @Override
    public void apply(DoubleArrayStack stack) {
        stack.push(stack.pop() * stack.pop());
    }
}
