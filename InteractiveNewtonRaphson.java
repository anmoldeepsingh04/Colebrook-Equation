package fluidReport;//newton
import java.util.Scanner;
import java.math.*;

public class InteractiveNewtonRaphson{
    public static void main(String[] args) { 
    	Scanner sc=new Scanner(System.in);
		System.out.println("Enter the initial guess. "); //Make sure the initial guess is very close to the real solution
		double xn=sc.nextDouble(); //gets input for initial guess
		System.out.println("Enter the number of values of Reynolds number."); 
		int ReynoldsCount=sc.nextInt(); //  gets number of reynolds numbers
		System.out.println("Enter the "+ReynoldsCount+" values of Reynold's number.Enter in increasing order. ");
		double Re[]= new double[ReynoldsCount];
		for(int r=0;r<ReynoldsCount;r++)  //gets reynolds number values in increasing order and store them in an array
		{
			Re[r]=sc.nextDouble();
		}
		System.out.println("Enter the number of values of Epsilon(Roughness).");
		int EpsilonCount=sc.nextInt(); //gets number of epsilon values
		System.out.println("Enter the "+EpsilonCount+" values of Epsilon. ");
		double Ep[]= new double[EpsilonCount];
		for(int e=0;e<EpsilonCount;e++) //gets epsilon values and store them in an array 
		{
			Ep[e]=sc.nextDouble();
		}
		System.out.println("Enter the Diameter of the pipe in meters. ");
		double dia=sc.nextDouble(); // gets diameter of the pipe
		System.out.println("Enter the error limit. ");
		double error=sc.nextDouble(); // gets error for each iteration
		for(int h=0;h<EpsilonCount;h++)  // for each value of epsilon,for loop runs once
		{
		double alpha= Ep[h]/(dia*3.7);  //calculates the value of alpha=epsilon/diameter*3.7
		for(int i=0;i<ReynoldsCount;i++) // for each value of reynolds number,for loop runs once
		{
		double beta = 2.51/Re[i];  //calculates the value of beta=2.51/Reynolds number
		double xn1,fxn,fdashxn,errorval,fresi;
		for(int j=0;;j++)  // using one value of epsilon and one value of reynolds number, for loop runs until quitting criteria is satisfied and returns the corresponding value of friction factor
		{
			fxn= (1/(Math.sqrt(xn))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn) ) ) ); // calculates the value of colebrook equation using initial guess
			fdashxn= (1/( 2*xn*( Math.sqrt(xn) ) )) + (beta/(beta*xn+ alpha*xn*Math.sqrt(xn))); // calculates the value of derivative of colebrook equation using initial guess
			xn1=xn+fxn/fdashxn; //implementation of newton-raphson method
			fresi=(1/(Math.sqrt(xn1))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn1) ) ) ); //calculating residual error
			errorval=Math.abs(fresi); //calculation of error for this iteration
			if(errorval<error)break; //quitting criteria
			xn=xn1; //updation of the iterating variable
			
		}
		System.out.print(xn+","); // printing the friction factor
		}
		System.out.println();
	}
    } 
}
