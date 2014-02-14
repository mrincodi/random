package juguemos;

class myRunnable implements Runnable{
	@Override
	public void run (){
		System.out.println ("Y yo sigo aquí");
		while ( true ){
//			try {
//				Thread.sleep ( 100 );
//			} catch ( java.lang.InterruptedException ie ){
//				System.out.println ( "No me importa.");
//			}
		}			
	}
}

public class ProgramaPrincipal {
	public static void main ( String [] args ) throws java.lang.InterruptedException {
		Thread t = new Thread ( new myRunnable () );

		t.start ();

		
		System.out.println ( t.getState() );
		
		t.join (3000);
		
		System.out.println ("Olvídese! ");
		
		t.interrupt();
		
		t.join (3000);
		
		System.out.println ( t.getState() );
		
		System.out.println ("A veeeer...");
		
		if ( t.isAlive() ) System.out.println ( "No puedo contar contigo ");
		
		
	}
}