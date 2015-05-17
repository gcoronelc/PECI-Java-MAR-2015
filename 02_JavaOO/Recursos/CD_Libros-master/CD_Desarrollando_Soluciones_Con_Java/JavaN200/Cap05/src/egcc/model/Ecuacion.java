package egcc.model;

public class Ecuacion {

    private double c;
    private double b;
    private double a;

    public Ecuacion (double a, double b, double c) {
		this.setA(a);
		this.setB(b);
		this.setC(c);
    }

    public double getA () {
        return a;
    }

    public void setA (double val) {
        this.a = val;
    }

    public double getB () {
        return b;
    }

    public void setB (double val) {
        this.b = val;
    }

    public double getC () {
        return c;
    }

    public void setC (double val) {
        this.c = val;
    }

    public double[] resolver () {
		double raiz[] = new double[2];
		double temp = Math.sqrt( Math.pow(this.getB(), 2) - 4 * this.getA() * this.getC() ) ;
		raiz[0] = ( - this.getB() + temp ) / ( 2 * this.getA() );
		raiz[1] = ( - this.getB() - temp ) / ( 2 * this.getA() );
        return raiz;
    }

} // Ecuacion