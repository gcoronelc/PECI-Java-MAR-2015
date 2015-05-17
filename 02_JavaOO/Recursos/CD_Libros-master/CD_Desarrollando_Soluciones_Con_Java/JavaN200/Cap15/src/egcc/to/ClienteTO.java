package egcc.to;

import java.io.Serializable;

public class ClienteTO implements Serializable {

	private String cliecodigo = null;
	private String cliepaterno = null;
	private String cliematerno = null;
	private String clienombre = null;
	private String cliedni = null;
	private String clieciudad = null;
	private String cliedireccion = null;
	private String clietelefono = null;
	private String clieemail = null;

	public String getCliecodigo() {
		return cliecodigo;
	}

	public void setCliecodigo(String cliecodigo) {
		this.cliecodigo = cliecodigo;
	}

	public String getCliepaterno() {
		return cliepaterno;
	}

	public void setCliepaterno(String cliepaterno) {
		this.cliepaterno = cliepaterno;
	}

	public String getCliematerno() {
		return cliematerno;
	}

	public void setCliematerno(String cliematerno) {
		this.cliematerno = cliematerno;
	}

	public String getClienombre() {
		return clienombre;
	}

	public void setClienombre(String clienombre) {
		this.clienombre = clienombre;
	}

	public String getCliedni() {
		return cliedni;
	}

	public void setCliedni(String cliedni) {
		this.cliedni = cliedni;
	}

	public String getClieciudad() {
		return clieciudad;
	}

	public void setClieciudad(String clieciudad) {
		this.clieciudad = clieciudad;
	}

	public String getCliedireccion() {
		return cliedireccion;
	}

	public void setCliedireccion(String cliedireccion) {
		this.cliedireccion = cliedireccion;
	}

	public String getClietelefono() {
		return clietelefono;
	}

	public void setClietelefono(String clietelefono) {
		this.clietelefono = clietelefono;
	}

	public String getClieemail() {
		return clieemail;
	}

	public void setClieemail(String clieemail) {
		this.clieemail = clieemail;
	}
	
}