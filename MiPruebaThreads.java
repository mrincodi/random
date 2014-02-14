package juguemos;



class HablaRunnable implements Runnable {
	public void run () {
		System.out.println ( "Y comienza el conteo" );
		try { 
			for ( int i = 10; i > 0; i-- ){
				System.out.println (i);
				Thread.sleep ( 1000 );
			}
		}
		catch ( InterruptedException e ){
			System.out.println ( "¿¿P-PERO QUÉ...??");
		}
	}
}

public class MiPruebaThreads {

	public static void main ( String [] args ) throws InterruptedException{
		System.out.println ( "Buenas tardes. Un amigo va a contar...");
		Thread t = new Thread ( new HablaRunnable () );
			t.start ();
			t.join ( 6000 );

			
		if ( t.isAlive () ){
			System.out.println ( "¡¡ME CANSÉ!!");
			t.interrupt();
			t.join();
			System.out.println ("Un poquito de decencia...");
		}
	}
}


