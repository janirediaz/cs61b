import list.EquationList;

public class Calculator {
    // YOU MAY WISH TO ADD SOME FIELDS
    public EquationList head;
    public EquationList tail;
    int size;
    


    /**
     * TASK 2: ADDING WITH BIT OPERATIONS
     * add() is a method which computes the sum of two integers x and y using 
     * only bitwise operators.
     * @param x is an integer which is one of two addends
     * @param y is an integer which is the other of the two addends
     * @return the sum of x and y
     **/
    public int add(int x, int y) {
        int resultado;
        resultado = x + y;
        String suma = "1 + 2";
        saveEquation(suma, resultado);
        return resultado;

    }

    public int sub(int x, int y){
        int resultado;
        resultado = x - y;
        String resta = "5 - 5";
        saveEquation(resta, resultado);
        return resultado;
    }

    public int div(int x, int y){
        int resultado;
        resultado = x / y;
        String division = "2 / 2";
        saveEquation(division, resultado);
        return resultado;
    }

    /**
     * TASK 3: MULTIPLYING WITH BIT OPERATIONS
     * multiply() is a method which computes the product of two integers x and 
     * y using only bitwise operators.
     * @param x is an integer which is one of the two numbers to multiply
     * @param y is an integer which is the other of the two numbers to multiply
     * @return the product of x and y
     **/
    public int multiply(int x, int y) {
       int resultado;
       resultado = x * y;
       String multiplicacion = "2 * 4";
       saveEquation(multiplicacion, resultado);
       return resultado;

    }

    /**
     * TASK 5A: CALCULATOR HISTORY - IMPLEMENTING THE HISTORY DATA STRUCTURE
     * saveEquation() updates calculator history by storing the equation and 
     * the corresponding result.
     * Note: You only need to save equations, not other commands.  See spec for 
     * details.
     * @param equation is a String representation of the equation, ex. "1 + 2"
     * @param result is an integer corresponding to the result of the equation
     **/
    public void saveEquation(String equation, int result) {
        // YOUR CODE HERE
        EquationList nodeTemp = new EquationList(equation, result, null);


        if(head == null){
            head = nodeTemp;
            size = 1;
            return;

        }

        EquationList n = head;
        while (n.next != null){
            n = n.next;
        }

        n.next = nodeTemp;
        size = size + 1;
        
        
    }

    /**
     * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
     * printAllHistory() prints each equation (and its corresponding result), 
     * most recent equation first with one equation per line.  Please print in 
     * the following format:
     * Ex   "1 + 2 = 3"
     **/
    public void printAllHistory() {
        // YOUR CODE HERE

        printHistory(size);
        
    }

    /**
     * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
     * printHistory() prints each equation (and its corresponding result), 
     * most recent equation first with one equation per line.  A maximum of n 
     * equations should be printed out.  Please print in the following format:
     * Ex   "1 + 2 = 3"
     **/
    public void printHistory(int n) {
        // YOUR CODE HERE
        EquationList nodeTemp = head;
        int count;

        while( head != null && nodeTemp.next != null && count<n){
            
            
            System.out.println(nodeTemp.equation);
        }
    }    

    /**
     * TASK 6: CLEAR AND UNDO
     * undoEquation() removes the most recent equation we saved to our history.
    **/
    public void undoEquation() {
        // YOUR CODE HERE
        EquationList temp = head;
        EquationList palo = temp.next;
        while (temp.next != null){
            temp = temp.next;
            palo = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
       
    }

    /**
     * TASK 6: CLEAR AND UNDO
     * clearHistory() removes all entries in our history.
     **/
    public void clearHistory() {
        // YOUR CODE HERE
        head = new EquationList(" ", 0, null);
        tail = head;
        size = 0;
    }

    /**
     * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
     * cumulativeSum() computes the sum over the result of each equation in our 
     * history.
     * @return the sum of all of the results in history
     **/
    public int cumulativeSum() {
        // YOUR CODE HERE
        int sum = 0;
        EquationList e = el;

        if(el != null){
            while(e != null){
                sum = sum + e.result;
                e = e.next;
            }
        }

        return sum;
    }

    /**
     * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
     * cumulativeProduct() computes the product over the result of each equation 
     * in history.
     * @return the product of all of the results in history
     **/
    public int cumulativeProduct() {
        // YOUR CODE HERE
        int product = 1;
        EquationList e = el;

        if(el != null){
            while(e != null){
                product = product * e.result;
                e = e.next;
            }
        }
        return product;
    }
}