/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import dao.DAOFactory;
import dao.design.IEmpleadoDAO;
import dao.to.EmpleadoTO;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Coronel
 */
public class Test02 {

	public static void main(String[] args) {
		try {
			IEmpleadoDAO empleadoDAO = DAOFactory.getInstance().getEmpleadoDAO();
			ArrayList<EmpleadoTO> lista = empleadoDAO.consultarPorPaterno("co");
			for (EmpleadoTO empleadoTO : lista) {
				System.out.println(empleadoTO.getPaterno());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
