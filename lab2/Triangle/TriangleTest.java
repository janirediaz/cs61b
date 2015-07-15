/*
 * JUnit tests for the Triangle class
 */
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author melaniecebula
 */
public class TriangleTest {
  /**  We've already created a testScalene method.  Please fill in testEquilateral, and additionally
   *   create tests for Isosceles, Negative Sides, and Invalid sides
   **/

    @Test
    public void testScalene() {
        Triangle t = new Triangle(30, 40, 50);
        String result = t.triangleType();
        assertEquals("The triangle is Scalene", result);
    }

    @Test
    public void testEquilateral() {
        Triangle t = new Triangle(40, 40, 40);
        String result = t.triangleType();
        assertEquals("The triangle in Equilateral", result);
    }

    @Test
    public void testIsosceles(){
        Triangle t = new Triangle(30, 30, 50);
        String result = t.triangleType();
        assertEquals("The triangle is Isosceles", result);
    }

    @Test
    public void testNegativeSides(){
        Triangle t = new Triangle(-10, 10, 20);
        String result = t.triangleType();
        assertEquals("At least one length is less than 0!", result);
    }

    @Test
    public void testInvalidSides(){
        Triangle t = new Triangle(5, 8, 3);
        String result = t.triangleType();
        assertEquals("InvalidSides", result);
    }

    public static void main(String[] args) {
      //TODO: RUN TESTS (Look in ArithmeticTest.java main method for help!)
      jh61b.junit.textui.runClasses(TriangleTest.class);
    }
}
