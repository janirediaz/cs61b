import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we 
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your 
     * tests.  To use your unit tests for your own implementation, comment 
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        //tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE
    @Test
    public void testAddition(){
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.addition(1, 2));
    }

    @Test
    public void testSubtraction(){
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.subtraction(5, 5));
    }

    @Test
    public void testMultiplication(){
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.multiplication(2, 4));
    }

    @Test
    public void testDivision(){
        calculator calculator = new Calculator();
        assertEquals(1, calculator.division(2, 2));
    }


    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }       
}