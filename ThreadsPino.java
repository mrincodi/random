package juguemos;

class ThreadsPino2 extends Thread {
	public void run (){
		while ( true ){
			System.out.println ( "A mi barbería" );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}


class ThreadsRunnable implements Runnable {
	public void run () { 
		while ( true ){
			System.out.println ( "Les voy a cortar..." );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}




public class ThreadsPino extends Thread {
	
	

	public void run () {
		while ( true ){
			System.out.println ( "Bienvenidos sean" );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadsPino miThread = new ThreadsPino();

		miThread.start();

		ThreadsPino2 miThread2 = new ThreadsPino2();

		miThread2.start();

		Thread thread3 = new Thread ( new ThreadsRunnable () );
		
		thread3.start();
		
		

		while ( true ){
			System.out.println ( "¡¡¡EEEEL PE-LO!!!" );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
