package logic;

/**
 *
 * @author Gustavo Coronel
 */
public class MyMath {

	private int num1 = 0;
	private int num2 = 0;
	private int suma = 0;
	private int producto = 0;

	private void proceso() {
		suma = num1 + num2;
		producto = num1 * num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
		proceso();
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
		proceso();
	}

	public int getProducto() {
		return producto;
	}

	public int getSuma() {
		return suma;
	}
}