import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
    private final ArrayBlockingQueue<Objeto> buffer; // shared buffer

    public BlockingBuffer(){
        buffer = new ArrayBlockingQueue<Objeto>(3);
    } // end BlockingBuffer constructor

    // place value into buffer
    public void set( Objeto miObjeto ) throws InterruptedException{
       
        buffer.put( miObjeto ); // place value in buffer
        //System.out.printf( "%s%2d\t%s%d\n", "Producer writes ", value,
            //"Buffer cells occupied: ", buffer.size() );
        System.out.println("Producer produces "+ miObjeto.getNumero());
    } // end method set

    // return value from buffer
    public Objeto get() throws InterruptedException{
        Objeto readValue = buffer.take(); // remove value from buffer
        //System.out.printf( "%s %2d\t%s%d\n", "Consumer reads ",
            //readValue, "Buffer cells occupied: ", buffer.size() );
        System.out.println("Consumer reads " + readValue.getNumero());
        return readValue;
    } // end method get
} // end class BlockingBuffer
