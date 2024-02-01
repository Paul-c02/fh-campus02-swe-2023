package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();
    private CalcStore store = new CalcStore();
    private double result;

    @Override
    public double perform(Operation op) throws CalculatorException {

        Double b;
        Double a;

        switch (op) {
            case add:
                b = pop();
                a = pop();
                result =  a + b;
                return result;
            case sub:
                b = pop();
                a = pop();
                result = a - b;
                return result;
            case div:
                b = pop();
                a = pop();
                result = a / b;
                if (Double.isInfinite(result))
                    throw new CalculatorException("Division by zero");
                return result;
            case mul:
                b = pop();
                a = pop();
                result = a * b;
                return result;
            case sin:
                b = pop();
                result = Math.sin(Math.toRadians(b));
                return result;
            case cos:
                b = pop();
                result = Math.cos(Math.toRadians(b));
                return result;
            case mod:
                b = pop();
                a = pop();
                result = a % b;
                return result;
            case random:
                b = pop();
                a = pop();
                result =  new Random(1234).nextInt(a.intValue(),b.intValue());
                return result;
            case dot:
                result = calculateDotProduct();
                return result;
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

    private int calculateDotProduct() throws CalculatorException{
        int product = 0;
        int len = (int)pop();
        int[] vec = new int[len];
        for (int i = 0; i < len; i++) {
            vec[i]=(int)pop();
        }
        for (int i = 0; i < len; i++) {
            product += (int)pop() * vec[i];
        }

        return product;
    }
    public void store(double v){
        store.setStoredValue(v);
    }
    public double load(){
        return store.getStoredValue();
    }


}
