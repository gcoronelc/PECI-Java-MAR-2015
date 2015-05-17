package asociaciones;

public class Article {

	private int code;
	private String name;
	private double price;

	public Article(int code, String name, double price) {
		this.setCode(code);
		this.setName(name);
		this.setPrice(price);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
} // Article