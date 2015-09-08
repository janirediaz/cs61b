import list.Equationlist;



public static void main(String[] args){
	Calculator c = new Calculator();
	while(true){
		System.out.print("> ");
		String firstInput = StdIn.readString();

		if(operation.equals("+")){
			int result = c.add(x, y);
			c.saveEquation(x + " + " + y, result);
			System.out.println(result);
		}

		if(operation.equals("*")){
			int result = c.multiply(x, y);
			c.saveEquation(x + " * " + y, result);
			System.out.println(result);
		}

		if(operation.equals("-")){
			int result = c.sub(x, y);
			c.saveEquation(x + " - " + y, result);
			System.out.println(result);
		}

		if(operation.equals("/")){
			int result = c.div(x, y);
			c.saveEquation(x + " / " + y, result);
			System.out.println(result);
		}

	}
}