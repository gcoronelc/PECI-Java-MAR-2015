package pe.egcc.app.services;

public class MateService {

  public int calcular(int n1, int n2, String operador) {
    int rpta = 0;
    switch (operador) {
    case "+":
      rpta = n1 + n2;
      break;
    case "-":
      rpta = n1 - n2;
      break;
    case "*":
      rpta = n1 * n2;
      break;
    case "/":
      rpta = n1 / n2;
      break;
    default:
      rpta = 0;
      break;
    }
    return rpta;
  }

}
