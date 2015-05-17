package pe.egcc.app.util;

import java.io.File;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public final class Isil {

  public static final String RUTA_BASE = "C:\\EGCC\\PJD\\JavaSE\\Clase04_19ABR2015\\";

  private Isil() {
  }

  public static boolean isInt(String cadena) {
    try {
      Integer.parseInt(cadena);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isLong(String cadena) {
    try {
      Long.parseLong(cadena);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isFloat(String cadena) {
    try {
      Float.parseFloat(cadena);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isDouble(String cadena) {
    try {
      Double.parseDouble(cadena);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static int seek(String subCadena, String cadena) {
    int pos = cadena.indexOf(subCadena);
    return pos;
  }

  public static int count(String subCadena, String cadena) {
    int cont = 0;
    int pos = cadena.indexOf(subCadena, 0);
    while (pos >= 0) {
      cont++;
      pos = cadena.indexOf(subCadena, pos + 1);
    }
    return cont;
  }

  public static boolean sonDigitos(String cadena) {
    boolean b = Pattern.matches("[0-9]+", cadena);
    return b;
  }

  public static boolean esFecha(String fecha) {
    String er = "^(([0-2]?\\d)|([3][0-1]))\\/(([0]?\\d)|([1][0-2]))\\/(\\d{4})$";
    boolean b = Pattern.matches(er, fecha);
    return b;
  }

  public static boolean esEmail(String fecha) {
    String er = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    boolean b = Pattern.matches(er, fecha);
    return b;
  }

  public static String grabarDialogoFileText() {
    String archivo = null;
    try {
      JFileChooser saveFile = new JFileChooser();
      saveFile.addChoosableFileFilter(new FileFilter()
      {
        String description = "Text Files(*.txt)";
        String extension = "txt";

        public String getDescription() {
          return description;
        }

        public boolean accept(File f) {
          if (f == null) {
            return false;
          }
          if (f.isDirectory()) {
            return true;
          }
          return f.getName().toLowerCase().endsWith(extension);
        }
      });
      saveFile.setCurrentDirectory(new File("*.txt"));
      int result = saveFile.showSaveDialog(null);
      archivo = saveFile.getSelectedFile().getAbsolutePath();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return archivo;
  }
}
