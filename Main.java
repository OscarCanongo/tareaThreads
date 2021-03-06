/*
Begona Montes Gomez A01329896
Oscar Canongo Vergara A01730443
Jose Maria Cortes Sarmiento A01731130
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main{
    public static void main( String[] args )
    {
        // create new thread pool with two threads
        ExecutorService application = Executors.newCachedThreadPool();
        // create UnsynchronizedBuffer to store ints
        Buffer sharedLocation = new SynchronizedBuffer();
        // execute the Producer and Consumer, giving each of them access
        // to sharedLocation
        application.execute( new Producer( sharedLocation,1 ) );
        application.execute( new Producer( sharedLocation,2 ) );
        application.execute( new Producer( sharedLocation,3 ) );
        application.execute( new Consumer( sharedLocation ) );
        application.shutdown(); // terminate application when tasks complete
    } // end main
} // end class SharedBufferTest
