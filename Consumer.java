import java.util.Random;
import java.util.ArrayList;
public class Consumer implements Runnable{
    private final static Random generator = new Random();
    private final Buffer sharedLocation; // reference to shared object

    public ArrayList<Integer> odd = new ArrayList<Integer>();
    public ArrayList<Integer> even= new ArrayList<Integer>();
    public ArrayList<Integer> prime = new ArrayList<Integer>();


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
              
                if(miObjeto.getCaracter() == '1'){
                   odd.add(miObjeto.getNumero());
               }

               else if(miObjeto.getCaracter() == '2'){
                even.add(miObjeto.getNumero());
                }

                else{
                    prime.add(miObjeto.getNumero());
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
            System.out.print(" "+odd.get(i));
        }
        
        System.out.println();
        System.out.println("Los valores del arreglo de pares son:");
        for(int i=0;i<10;i++){
            System.out.print(" "+even.get(i));
        }

        System.out.println();
        System.out.println("Los valores del arreglo de primos son:");
        for(int i=0;i<10;i++){
            System.out.print(" "+prime.get(i));
        }
    } // end method run
} // end class Consumer