import list.Equationlist;



public static void main(String[] args){
	int result;
	Calculator c = new Calculator();
	while(true){
		System.out.print("> ");
		String input = StdIn.readString();
		switch(input){
			case"quit":return;
			case "history":
				int count = StdIn.readInt();
				c.printHistory(count);
				break;
		}

		if(operator.equals("+")){
			int result = c.add(x, y);
			c.saveEquation(x + " + " + y, result);
			System.out.println(result);
		}

		if(operator.equals("*")){
			int result = c.multiply(x, y);
			c.saveEquation(x + " * " + y, result);
			System.out.println(result);
		}

		if(operator.equals("-")){
			int result = c.sub(x, y);
			c.saveEquation(x + " - " + y, result);
			System.out.println(result);
		}

		if(operator.equals("/")){
			int result = c.div(x, y);
			c.saveEquation(x + " / " + y, result);
			System.out.println(result);
		}

	}
}