package fluidReport; // using newton raphson
import java.math.*;
import java.util.Scanner;
public class NewtonRaphsonPlot {

	public static void main( String args[] ) {
		Scanner sc=new Scanner(System.in);
		double xn=0.0304761904761904761904;
		System.out.println("Initial guess: "+xn);
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
		double xn1,fxn,fdashxn,error;
		for(int j=0;j<100;j++) {
			fxn= (1/(Math.sqrt(xn))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn) ) ) );
			fdashxn= (1/( 2*xn*( Math.sqrt(xn) ) )) + (beta/(beta*xn+ alpha*xn*Math.sqrt(xn)));
			xn1=xn+fxn/fdashxn;
			error=Math.abs(xn1-xn);
			if(error<0.0000001)break;
			xn=xn1;
			
		}
		System.out.print(xn+",");
		}
		System.out.println();
	}
	}

}
