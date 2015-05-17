package asociaciones;

import java.util.ArrayList;

public class Articles {

	private ArrayList<Article> list;

	public Articles() {
		this.list = new ArrayList<Article>();
	}

	public ArrayList<Article> getList() {
		return this.list;
	}

	public void add(Article article) {
		this.list.add(article);
	}
	
} // Articles