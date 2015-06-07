// consulta
Connection cn = null;
try {
  cn = AccesoDB.getConnection();
  
} catch (Exception e) {
  e.printStackTrace();
} finally {
  try {
	if(cn != null) cn.close();
  } catch (Exception e) {
  }
}


// Transacción
Connection cn = null;
try {
 cn = AccesoDB.getConnection();
 
} catch (Exception e) {
  try {
	if(cn != null) cn.rollback();
  } catch (Exception e1) {
  }
  e.printStackTrace();
} finally{
  try {
	if(cn != null) cn.close();
  } catch (Exception e) {
  }
}