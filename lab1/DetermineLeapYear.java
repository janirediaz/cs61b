
import java.util.Scanner;

public class DetermineLeapYear {
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
       
	        int year=0;
	        
	        System.out.println("Introduce un año: ");
	        year = entrada.nextInt();
	        
	        boolean isLeapYear = false;
	        
	        if(year % 400 == 0)
	        {
	            isLeapYear = true;
	        }
	        else if (year % 100 == 0)
	        {
	            isLeapYear = false;
	        }
	        else if(year % 4 == 0)
	        {
	            isLeapYear = true;
	        }
	        else
	        {
	            isLeapYear = false;
	        }
	 
	        if(isLeapYear)
	        {
	            System.out.println("Year "+year+" is a Leap Year");
	        }
	        else
	        {
	            System.out.println("Year "+year+" is not a Leap Year");
	        }
	 
	    }
	}