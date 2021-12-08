package fluidReport;
//newton
public class NewtonError {

	public static void main(String[] args) {
		double Re= 10000;
		double Ep=0.0005; 
		double dia=0.0254;  
		double alpha= Ep/(dia*3.7);
		double beta = 2.51/Re;
		double xn=0.01142857142857142857142857142857;
		double xn1,fxn,fdashxn,error1=1e-16,fxn1;
		for(int j=0;j<10;j++) {
			fxn= (1/(Math.sqrt(xn))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn) ) ) );
			fdashxn= (1/( 2*xn*( Math.sqrt(xn) ) )) + (beta/(beta*xn+ alpha*xn*Math.sqrt(xn)));
			xn1=xn+fxn/fdashxn;
			fxn1=(1/(Math.sqrt(xn1))) + 2*Math.log10( alpha + ( beta / (Math.sqrt(xn1) ) ) );
			double error=Math.abs(fxn1);
			System.out.println(error+",");
			
			if(error<=error1)break;
			xn=xn1;
			
		}
		
		}
}



 

 