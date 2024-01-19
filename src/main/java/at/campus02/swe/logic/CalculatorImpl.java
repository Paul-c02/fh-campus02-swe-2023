package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        Double b = pop();
        Double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case sin:
                return Math.sin(Math.toRadians(b));
            case cos:
                return Math.cos(Math.toRadians(b));
            case mod:
                return a % b;
            case random:
                return  new Random(1234).nextInt(a.intValue(),b.intValue());
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

    public static void main(String[] args) {
        System.out.println(new Random(12345).nextInt(4,7));
    }

}
