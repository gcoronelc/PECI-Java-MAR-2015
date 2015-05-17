package canasta;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Coronel
 */
public class CanastaList {

	private ArrayList<CanastaItem> lista = new ArrayList<CanastaItem>();

	public void addItem(CanastaItem item) {
		lista.add(item);
	}

	public ArrayList<CanastaItem> getLista() {
		return lista;
	}

	public int size() {
		return lista.size();
	}
}