package dao.design;

import dao.to.ContadorTO;

public interface IContadorDAO {
	
	public abstract String generaCodigo(String tabla) throws Exception; 
	public abstract ContadorTO consultar(String tabla) throws Exception;

}