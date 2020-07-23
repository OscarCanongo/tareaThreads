/*
Begona Montes Gomez A01329896
Oscar Canongo Vergara A01730443
Jose Maria Cortes Sarmiento A01731130
*/

import java.util.Random;
public class Consumer implements Runnable{
    private final static Random generator = new Random();
    private final Buffer sharedLocation; // reference to shared object


    public int[] even = new int[10];
    public int[] odd = new int[10];
    public int[] prime = new int[10];
    public int oddN=0;
    public int primeN=0;
    public int evenN=0;


    // constructor
    public Consumer( Buffer shared ){
        sharedLocation = shared;
    } // end Consumer constructor

    // read sharedLocation's value 10 times and sum the values
    public void run(){
        Objeto miObjeto ;
        for ( int count = 1; count <= 30; count++ ){
            // sleep 0 to 3 seconds, read value from buffer and add to sum
            try{
                Thread.sleep( generator.nextInt( 3000 ) );
                miObjeto = sharedLocation.get();


                if(miObjeto.getCaracter() == "impares"){
                    odd[oddN]=miObjeto.getNumero();
                    oddN++;
               }

               else if(miObjeto.getCaracter() == "pares"){
                        even[evenN]=miObjeto.getNumero();
                        evenN++;
                }

                else{
                    prime[primeN]=miObjeto.getNumero();
                    primeN++;
                }


                //System.out.println( "El consumidor consume " + sum );
            } // end try

            catch ( InterruptedException exception )
            {
                exception.printStackTrace();
            } // end catch
        } // end for
        // System.out.println("Consumer read values totaling");
        System.out.println("Los valores del arreglo de impares son:");
        for(int i=0;i<10;i++){
            System.out.print(" "+odd[i]);
        }

        System.out.println();
        System.out.println("Los valores del arreglo de pares son:");
        for(int i=0;i<10;i++){
            System.out.print(" "+even[i]);
        }

        System.out.println();
        System.out.println("Los valores del arreglo de primos son:");
        for(int i=0;i<10;i++){
            System.out.print(" "+prime[i]);
        }
        System.out.println();
    } // end method run
} // end class Consumer
