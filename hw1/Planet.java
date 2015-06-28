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

	private double calcDistance (Planet planet){
		double distancex = planet.x - this.x;
		double distancey = planet.y - this.y;
		double distancexcuadrado = distancex * distancex;
		double distanceycuadrado = distancey * distancey;
		double distancetotal = Math.sqrt(distancexcuadrado + distanceycuadrado);

		return distancetotal;
	}

	
}



