/*
Begona Montes Gomez A01329896
Oscar Canongo Vergara A01730443
Jose Maria Cortes Sarmiento A01731130
*/

import java.util.Random;
public class Producer implements Runnable
{
    private final static Random generator = new Random();
    private final Buffer sharedLocation; // reference to shared object
    private final int x;
    // constructor
    public Producer( Buffer shared, int x){
        sharedLocation = shared;
        this.x = x;
    } // end Producer constructor
    
    public void run(){
        int sum = 0;
        int[] primos = {2,3,5,7,11,13,17,19,23,29};

        switch (x) {
            case 1:
                for ( int count = 1; count <= 20; count+=2 ){
                    try { // sleep 0 to 3 seconds, then place value in Buffer  
                                
                        Thread.sleep( generator.nextInt( 3000 ) ); // random sleep
                        Objeto miObjeto = new Objeto(count, "impares");  
                        
                        sharedLocation.set( miObjeto); // set value in buffer
                        //System.out.println("Productor produce: " + sum);
                    } // end try
                    // if lines 25 or 26 get interrupted, print stack trace
                    catch ( InterruptedException exception ){
                        exception.printStackTrace();
                    } // end catch
                } // end for
            break;
            
            case 2:
                for ( int count = 1; count <= 10; count++ ){
                    try { // sleep 0 to 3 seconds, then place value in Buffer            
                        Thread.sleep( generator.nextInt( 3000 ) ); // random sleep
                        Objeto miObjeto = new Objeto(sum, "pares");
                        // sharedLocation.set(sum); // set value in buffer
                        sum+=2;
                        sharedLocation.set( miObjeto );
                        //System.out.println("Productor produce: " + sum);
                    } // end try
                    // if lines 25 or 26 get interrupted, print stack trace
                    catch ( InterruptedException exception ){
                        exception.printStackTrace();
                    } // end catch
                } // end for
            break;

            case 3:
                for ( int count = 1; count <= 10; count++ ){
                    try { // sleep 0 to 3 seconds, then place value in Buffer            
                        Thread.sleep( generator.nextInt( 3000 ) ); // random sleep
                        // sharedLocation.set( primos[count-1]); // set value in buffer

                        Objeto miObjeto = new Objeto(primos[count-1], "primos");
                        sharedLocation.set( miObjeto );
                        //System.out.println("Productor produce: " + primos[count-1]);
                    } // end try
                    // if lines 25 or 26 get interrupted, print stack trace
                    catch ( InterruptedException exception ){
                        exception.printStackTrace();
                    } // end catch
                } // end for
            break;    
        }

        System.out.println("Productor termino de producir\nTerminando el productor");
    } // end method run
} // end class Producer