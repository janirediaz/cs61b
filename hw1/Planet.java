import java.lang.Math;

public class Planet{


	double x;
	double y;
	double xVelocity;
	double yVelocity;
	double mass;
	String img;
	double xNetForce;
	double yNetForce;


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

    public void setNetForce (Planet[] planet){

    	xNetForce = 0;
    	yNetForce = 0;

    	for(int i=0; i<Planet.length; i++){
    		if(Planet(i) == this){
    			System.out.println("Estas comparando el mismo planeta");
    		}else{
    			yNetForce = yNetForce + this.calcPairwiseForceY(planet[i]);
    			xNetForce = xNetForce + this.calcPairwiseForceX(planet[i]);			
    		}
    	}
    }

	
}



