package at.campus02.swe.logic;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }
    @Test
    public void testSimpleModOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(4);
        double result = calc.perform(Operation.mod);

        assertEquals(2, result, 0);

    }


    @Test
    public void testSimpleSinOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(90.0);
        double result = calc.perform(Operation.sin);

        assertEquals(1, result, 0);

    }
    @Test
    public void testSimpleCosOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(180.0);
        double result = calc.perform(Operation.cos);

        assertEquals(-1, result, 0);

    }


    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }
    @Test
    public void testRandom() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(4);
        calc.push(7);
        double result = calc.perform(Operation.random);

        assertEquals(6, result, 0);
    }
    @Test
    public void testDotProduct() throws Exception {
        Calculator calc = new CalculatorImpl();
        calc.push(1);
        calc.push(3);
        calc.push(2);
        calc.push(4);
        calc.push(2);
        double result = calc.perform(Operation.dot);

        assertEquals(14, result, 0);
    }
    @Test
    public void testDotProductFail() throws Exception {
        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(1);
            calc.push(3);
            calc.push(2);
            calc.push(4);
            calc.push(3);
            double result = calc.perform(Operation.dot);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertNull(e.getMessage());
        }
    }
    @Test
    public void testLoadFail() throws Exception {
        //Setup
        Calculator calc = new CalculatorImpl();
        assertThrows(NullPointerException.class,
                ()->{
                    calc.load("A");
                });

    }
    @Test
    public void testStore() throws Exception {
        //Setup
        Calculator calc = new CalculatorImpl();
        calc.store(1);
        assertEquals(1.0,calc.load(),0);
        calc.store("A", 2.1);
        calc.store("B", 5.7);
        assertEquals(2.1,calc.load("A"),0);
        assertEquals(5.7,calc.load("B"),0);

    }
}