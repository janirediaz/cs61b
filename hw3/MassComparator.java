import java.util.Comparator;


public class MassComparator implements Comparator<Planet> {

    
       public int compare(Planet planet1, Planet planet2) {
        return (int)(planet1.getMass() - planet2.getMass());
    }
}