public class Objeto{
  public int numero;
  public char caracter;

  //Constructor
  public Objeto(int numero, char caracter){
    this.numero = numero;
    this.caracter = caracter;
  }

  //Setters
  public void setNumero(int numero){
    this.numero = numero;
  }

  public void setCaracter(char caracter){
    this.caracter = caracter;
  }

  //Getters
  public int getNumero(){
    return numero;
  }

  public char getCaracter(){
    return caracter;
  }
}
