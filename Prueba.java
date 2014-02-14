package juguemos;

import org.junit.Test;
import org.junit.Assert;

public class Prueba {

	public void empa (){
		System.out.println ("nada");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println ("I'm walking here!!");

	}
	
	@Test
	public void test1 () {
		Prueba qq = new Prueba();
		Assert.assertTrue ("Claro", false);
	}

	
	
}
