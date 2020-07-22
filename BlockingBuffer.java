import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer{
    private final ArrayBlockingQueue<Integer> buffer; // shared buffer

    public BlockingBuffer(){
        buffer = new ArrayBlockingQueue<Integer>( 3 );
    } // end BlockingBuffer constructor

    // place value into buffer
    public void set( int value ) throws InterruptedException{
        buffer.put( value ); // place value in buffer
        //System.out.printf( "%s%2d\t%s%d\n", "Producer writes ", value,
            //"Buffer cells occupied: ", buffer.size() );
        System.out.println("Producer writes " + value);
    } // end method set

    // return value from buffer
    public int get() throws InterruptedException{
        int readValue = buffer.take(); // remove value from buffer
        //System.out.printf( "%s %2d\t%s%d\n", "Consumer reads ",
            //readValue, "Buffer cells occupied: ", buffer.size() );
        System.out.println("Consumer reads " + readValue);
        return readValue;
    } // end method get
} // end class BlockingBuffer