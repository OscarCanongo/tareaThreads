public class SynchronizedBuffer implements Buffer{

  	private Objeto buffer; // shared by producer and consumer threads
  	private boolean occupied = false; // whether the buffer is occupied

	// place value into buffer
  	public synchronized void set( Objeto miObjeto  ) throws InterruptedException
  	{

	// while there are no empty locations, place thread in waiting state
  		while ( occupied ){

			// output thread information and buffer information, then wait
  			//System.out.println("Producer tries to write." ); displayState( "Buffer full. Producer waits." );
  			wait();

		} // end while
    buffer = miObjeto;
    occupied = true;
		// indicate producer cannot store another value // until consumer retrieves current buffer value occupied = true;
    	System.out.println("Productor de "+ miObjeto.getCaracter()+" produce "+ miObjeto.getNumero());
		notifyAll(); // tell waiting thread(s) to enter runnable state } // end method set; releases lock on SynchronizedBuffer
	}


	  	// return value from buffer
	public synchronized Objeto get() throws InterruptedException{

		// while no data to read, place thread in waiting state
			while ( !occupied ) {
			// output thread information and buffer information, then wait
				wait();
		} // end while

		// indicate that producer can store another value
		// because consumer just retrieved buffer value
		occupied = false;
		System.out.println("Consumidor consume " + buffer.getNumero() +" del productor " + buffer.getCaracter());
		notifyAll(); // tell waiting thread(s) to enter runnable state
		return buffer; // end method get; releases lock on SynchronizedBuffer
	}

} //End class
