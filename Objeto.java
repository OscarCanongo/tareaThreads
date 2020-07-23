/*
Begona Montes Gomez A01329896
Oscar Canongo Vergara A01730443
Jose Maria Cortes Sarmiento A01731130
*/

public class Objeto{
  public int numero;
  public String caracter;

  //Constructor
  public Objeto(int numero, String caracter){
    this.numero = numero;
    this.caracter = caracter;
  }

  //Setters
  public void setNumero(int numero){
    this.numero = numero;
  }

  public void setCaracter(String caracter){
    this.caracter = caracter;
  }

  //Getters
  public int getNumero(){
    return numero;
  }

  public String getCaracter(){
    return caracter;
  }
}
