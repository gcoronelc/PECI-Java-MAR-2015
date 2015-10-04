package pe.egcc.eureka.app.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Sirve para guardar data durante la sesión del usuario.
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public final class Session {

  private Session() {
  }

  private static Map<String, Object> data;

  static {
    data = new HashMap<>();
  }

  public static void put(String key, Object value) {
    data.put(key, value);
  }

  public static Object get(String key) {
    return data.get(key);
  }

}
