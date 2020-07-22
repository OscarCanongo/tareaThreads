import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
    private final ArrayBlockingQueue<Objeto> buffer; // shared buffer

    public BlockingBuffer(){
        buffer = new ArrayBlockingQueue<Objeto>(3);
    } // end BlockingBuffer constructor

    // place value into buffer
    public void set( int value ) throws InterruptedException{
        Objeto miObjeto = new Objeto(value, 'x');
        buffer.put( miObjeto ); // place value in buffer
        //System.out.printf( "%s%2d\t%s%d\n", "Producer writes ", value,
            //"Buffer cells occupied: ", buffer.size() );
        System.out.println("Producer writes " + miObjeto.getNumero());
    } // end method set

    // return value from buffer
    public int get() throws InterruptedException{
        int readValue = buffer.take().getNumero(); // remove value from buffer
        //System.out.printf( "%s %2d\t%s%d\n", "Consumer reads ",
            //readValue, "Buffer cells occupied: ", buffer.size() );
        System.out.println("Consumer reads " + readValue);
        return readValue;
    } // end method get
} // end class BlockingBuffer
