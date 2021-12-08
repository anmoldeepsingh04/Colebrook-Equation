package fluidReport;
import java.math.*;
import java.util.Scanner;


public class SecantError {


public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	double xn0=0.01142857142857142857142857142857;
	double xn1=0.0005;
	double Re= 10000;
	double Ep=0.0005; 
	double dia=0.0254;  
	double alpha= Ep/(dia*3.7);
	double beta = 2.51/Re;
	double xn2,fxn0,fxn1,error=1e-16;
		for(int i=0;i<10;i++) {
		fxn0= (1/(Math.sqrt(xn0))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn0) ) ) );
		fxn1= (1/(Math.sqrt(xn1))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn1) ) ) );
		if(fxn0*fxn1!=0) {
			
				xn2=((xn0*fxn1 - xn1*fxn0)/(fxn1 - fxn0));
				double c=fxn0*fxn1;
				xn0=xn1;
				xn1=xn2;
				if(c==0) {break;}
				double fxm,xm;
				xm=((xn0*fxn1 - xn1*fxn0)/(fxn1 - fxn0));
				fxm=(1/(Math.sqrt(xm))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xm) ) ) );
				System.out.println(Math.abs(fxm)+",");
				if (Math.abs(fxm)<error) {break;}
				
			}
		else {System.out.println("Can not find a root in the given interval. ");}
		
		}
	
	}
}