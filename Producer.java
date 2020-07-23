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
                for ( int count = 1; count <= 10; count++ ){
                    try { // sleep 0 to 3 seconds, then place value in Buffer  
                                
                        Thread.sleep( generator.nextInt( 3000 ) ); // random sleep
                        Objeto miObjeto = new Objeto(sum, '1');  
                        sum+=1;
                        

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
                        Objeto miObjeto = new Objeto(sum, '2');
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

                        Objeto miObjeto = new Objeto(primos[count-1], '3');
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

        System.out.println("Producer done producing\nTerminating Producer" );
    } // end method run
} // end class Producer