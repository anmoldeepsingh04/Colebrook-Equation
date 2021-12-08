package fluidReport;//using secant method
import java.util.Scanner;
import java.math.*;
public class SecantPlot {

	public static void main( String args[] ) {
		Scanner sc=new Scanner(System.in);
		double xn0=0.0304761904761904761904;
		System.out.println("First initial guess: "+xn0);
		double xn1=0.04898539542735698;
		System.out.println("First initial guess: "+xn1);
		int ReynoldsCount=25; 
		System.out.println("Number of values of Reynolds number: "+ReynoldsCount);
		double Re[]= {2100,4800, 5000, 10000, 15000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 200000, 300000, 400000,500000, 600000, 700000, 800000, 900000, 1e6, 1e7, 1e8};  
		System.out.println("Values of Reynold's number: ");
		for(int i=0;i<25;i++) {
			System.out.print(Re[i]+",");
		}System.out.println();
		int EpsilonCount=5;
		System.out.println("Number of values of Epsilon(Roughness): "+EpsilonCount);
		double Ep[]= {0.00001,0.00004,0.0001,0.0002,0.0008};
		System.out.print("Values of Epsilon: ");
		for(int i=0;i<5;i++) {
			System.out.print(Ep[i]+",");
		}System.out.println();
		double dia=0.0254;
		System.out.println("Diameter of the pipe in meters: "+dia); 
		for(int h=0;h<EpsilonCount;h++) {
		double alpha= Ep[h]/(dia*3.7); 
		for(int i=0;i<ReynoldsCount;i++) {
		double beta = 2.51/Re[i];
		double xn2=0,fxn1,fxn0,error;
		for(int j=0;;j++) {
			fxn0= (1/(Math.sqrt(xn0))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn0) ) ) );
			fxn1= (1/(Math.sqrt(xn1))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn1) ) ) );
			if(fxn0 != fxn1) {
			xn2= (xn0*fxn1 - xn1*fxn0)/(fxn1 - fxn0) ;}
			else {System.out.println("Root does not lie between "+xn0+" and "+xn1);break;}
			error=Math.abs(xn2-xn1);
			
			xn0=xn1;
			xn1=xn2;
			if(error<0.0000001) {break;}
			}
		System.out.print(xn2+",");
		}
		System.out.println();
	}
	}

}
