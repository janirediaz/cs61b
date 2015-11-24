import java.util.Comparator;

/**
 * RadiusComparator.java
 */

public class RadiusComparator implements Comparator<Planet> {

   
    public int compare(Planet planet1, Planet planet2) {
        return (int)(planet1.getRadius() - planet2.getRadius());
    }
}