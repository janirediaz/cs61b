public class NBody{
	public static void main(String[] args){

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args [2];

		In in = new In(filename);
		 	in.readInt();
        	in.readDouble();

	
		while(in.hasnext() == true){
		
		}

		for(i=0; i<dt; dt=dt + dt){
			//Ahora como llamo a los metodos setNetForce, update y draw??
		}

		public static Planet getPlanet(In in){


			double x = in.readDouble();
			double y = in.readDouble();
			double xVelocity = in.readDouble();
			double yVelocity = in.readDouble();
			double xAccel = in.readDouble();
			double yAccel = in.readDouble();
			String img = in.readString();


		}


	}

	
}