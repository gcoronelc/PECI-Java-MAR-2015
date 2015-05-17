package pe.egcc.app.service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;
import pe.egcc.app.model.Estudiante;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 */
public final class PromedioService {

  private static final String ARCHIVO
          = "C:\\EGCC\\PJD\\JavaSE\\Clase04_19ABR2015\\Java.txt";

  private PromedioService() {
  }

  public static void grabar(Estudiante bean) {
    PrintStream printStream = null;
    try {
      FileOutputStream stream = new FileOutputStream(ARCHIVO, true);
      printStream = new PrintStream(stream);
      Gson gson = new Gson();
      printStream.println(gson.toJson(bean));
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      try {
        printStream.close();
      } catch (Exception e) {
      }
    }
  }

  public static Estudiante[] traerTodos(){
    Estudiante[] listado = new Estudiante[1000];
    int cont = 0;
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(ARCHIVO);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String linea = bufferedReader.readLine(); // La primera línea
      Gson gson = new Gson();
      while (linea != null) {
        if(!linea.isEmpty()){
          Estudiante bean = gson.fromJson(linea, Estudiante.class);
          listado[cont] = bean;
          cont++;
        }
        linea = bufferedReader.readLine(); // A partir de la segunda línea
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        fileReader.close();
      } catch (Exception e) {
      }
    }
    if(cont > 0)
      listado = Arrays.copyOf(listado, cont);
    else
      listado = null;
    return listado;
  }
}
