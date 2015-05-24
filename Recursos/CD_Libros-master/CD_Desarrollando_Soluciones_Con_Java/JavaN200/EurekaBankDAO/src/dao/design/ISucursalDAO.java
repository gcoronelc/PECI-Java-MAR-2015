package dao.design;

import dao.to.SucursalTO;

/**
 *
 * @author Gustavo Coronel
 */
public interface ISucursalDAO {

    public abstract SucursalTO consultaPorEmpleado( String codigo ) throws Exception;
    
}
