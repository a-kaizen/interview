package interview;

import interview.calculator.CalculatorUtils;

public final class Main {

    public static void main(String[] args) {
        System.out.println(CalculatorUtils.calculateRpn("12 2 3 4 x 10 5 / + x +"));
    }

}

