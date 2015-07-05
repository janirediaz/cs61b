import java.util.Arrays;

public class NBody{
	public static void main(String[] args){

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args [2];

		In in = new In(filename);
		int numeroPlanetas = in.readInt();
		double radioUniverso = in.readDouble();

		Planet[] listaPlanetas = new Planet[numeroPlanetas];
		in.readLine();
		for(int i=0; i<numeroPlanetas; i++ ){	
			listaPlanetas[i] = getPlanet(in);
		}

		StdDraw.setScale(0, radioUniverso);

		for(double i=0; i<T; i=i + dt){
			for(int j=0; j<listaPlanetas.length; j++){
				listaPlanetas[j].setNetForce(listaPlanetas);
				listaPlanetas[j].update(dt);
				listaPlanetas[j].draw();
				
			}

			StdDraw.show(1000);

			
		}


	}

	public static Planet getPlanet(In in){

		String planetTokensString = in.readLine();
		String[] planetTokens = planetTokensString.split(" ");



		double x = Double.parseDouble(planetTokens[0]);
		double y = Double.parseDouble(planetTokens[1]);
		double xVelocity = Double.parseDouble(planetTokens[2]);
		double yVelocity = Double.parseDouble(planetTokens[3]);
		double mass = Double.parseDouble(planetTokens[4]);
		String img = planetTokens[5];

		Planet planet = new Planet(x, y, xVelocity, yVelocity, mass, img);

		return planet;

	}

	
}