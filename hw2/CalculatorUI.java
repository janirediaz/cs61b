import list.EquationList;


public class CalculatorUI {
	public static void main(String[] args){
		Calculator c = new Calculator();
		while(true){
			System.out.print("> ");
			String firstInput = StdIn.readString();
			switch(firstInput){
				case"quit":return;
				case "dump": c.printAllHistory(); break;
				case "history":
					int count = StdIn.readInt();
					c.printHistory(count);
					break;
				case "undo": c.undoEquation(); break;
				case "clear": c.clearHistory(); break;
				case "sum": System.out.println(c.cumulativeSum()); break;
				case "product": System.out.println(c.cumulativeProduct()); break;
				default:
					int x = Integer.parseInt(firstInput);
					String operation = StdIn.readString();
					int y = StdIn.readInt();
 
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
	}
}