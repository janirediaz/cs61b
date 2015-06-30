import java.lang.Math;

public class Planet{


	double x;
	double y;
	double xVelocity;
	double yVelocity;
	double mass;
	String img;

	public Planet(double x, double y, double xVelocity, 
				  double yVelocity, double mass, String img){

		this.x = x;
		this.y = y;
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
		this.mass = mass;
		this.img = img;

	}  

	public double calcDistance (Planet planet){
		double distancex = planet.x - this.x;
		double distancey = planet.y - this.y;
		double distancexcuadrado = distancex * distancex;
		double distanceycuadrado = distancey * distancey;
		double distancetotal = Math.sqrt(distancexcuadrado + distanceycuadrado);

		return distancetotal;
	}

	public double calcPairwiseForce (Planet planet){
		double forcepartone = 6.67E-11 * this.mass * planet.mass;
		double forcepartwo = calcDistance(planet);
		double forcepartwocuadrado = forcepartwo * forcepartwo;
		double forcetotal = forcepartone / forcepartwocuadrado;

		return forcetotal;
	}

	public double calcPairwiseForceX (Planet planet){
		double distancex = Math.abs (planet.x - this.x);
        double forcex = calcPairwiseForce(planet) * (distancex / calcDistance(planet));

        return forcex;

    }

    public double calcPairwiseForceY (Planet planet){
    	double distancey = Math.abs (planet.y - this.y);
        double forcey = calcPairwiseForce(planet) * (distancey/ calcDistance(planet));

        return forcey;

    }

    public void setNetForce (Planet planet){
    	double netforcex = calcPairwiseForceX(planet) / this.mass;
    	double netforcey = calcPairwiseForceY(planet) / planet.mass;
    	double netforcetotal = netforcey + netforcex;

    	Planet[] planet;

    	for(int i=0; i<Planet.length; i++){
    		if(Planet(i) == Planet){
    			System.out.println("Estas comparando el mismo planeta");
    		}else{
    			System.out.println("La fuerza es: " + netforcetotal);
    		}
    	}
    }

	
}



