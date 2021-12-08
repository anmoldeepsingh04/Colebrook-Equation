package fluidReport;
import java.util.Scanner;
import java.math.*;
public class InteractiveSecant {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first initial guess. "); //Make sure the initial guess is very close to the real solution
		double xn0=sc.nextDouble(); //gets input for first guess
		System.out.println("Enter the second initial guess. "); //Make sure the initial guess is very close to the real solution
		double xn1=sc.nextDouble(); //gets input for second guess
		System.out.println("Enter the number of values of Reynolds number.");
		int ReynoldsCount=sc.nextInt();  //  gets number of reynolds numbers
		System.out.println("Enter the "+ReynoldsCount+" values of Reynold's number. ");
		double Re[]= new double[ReynoldsCount];
		for(int r=0;r<ReynoldsCount;r++)  //gets reynolds number values in increasing order and store them in an array
		{
			Re[r]=sc.nextDouble();
		}
		System.out.println("Enter the number of values of Epsilon(Roughness).");
		int EpsilonCount=sc.nextInt(); //gets number of epsilon values
		System.out.println("Enter the "+EpsilonCount+" values of Epsilon. ");
		double Ep[]=  new double[EpsilonCount];
		for(int e=0;e<EpsilonCount;e++)  //gets epsilon values and store them in an array 
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
		for(int i=0;i<ReynoldsCount;i++)  // for each value of reynolds number,for loop runs once
		{
		double beta = 2.51/Re[i];  //calculates the value of beta=2.51/Reynolds number
		double xn2=0,fxn1,fxn0,fresi,errorval;
		for(int j=0;;j++)  // using one value of epsilon and one value of reynolds number, for loop runs until quitting criteria is satisfied and returns the corresponding value of friction factor
		{
			fxn0= (1/(Math.sqrt(xn0))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn0) ) ) ); // calculates the value of colebrook equation using first initial guess
			fxn1= (1/(Math.sqrt(xn1))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn1) ) ) ); // calculates the value of colebrook equation using second initial guess
			if(fxn0 != fxn1) //enters loop if these two values are not equal 
			{
			xn2= (xn0*fxn1 - xn1*fxn0)/(fxn1 - fxn0) ; //implementation of secant method
			}
			else {System.out.println("Root does not lie between "+xn0+" and "+xn1);break;} // executed when the previous if condition is not satisfied 
			fresi=(1/(Math.sqrt(xn2))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn2) ) ) ); //calculating residual error
			errorval=Math.abs(fresi); //calculation of error for this iteration
			xn0=xn1; //updation of the first iterating variable 
			xn1=xn2; //updation of the second iterating variable
			if(errorval<error) {break;} //quitting criteria
			}
		System.out.print(xn2+","); // printing the friction factor
		}
		System.out.println();
	}
	}

}
