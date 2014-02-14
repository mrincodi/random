package juguemos;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRuntime {
 
	@Test(enabled=true, expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
	}
	
	
	@Test
	@Parameters(value="number")
	public void parameterIntTest(int number) {
	   System.out.println("Parameterized Number is : " + number);
	}
	
	
	@Test
	@Parameters(value="number")
	public void parameterIntTest2(int number) {
	   System.out.println("Parameterized Number is qqq : " + number);
	}
	
//	
//	@Test(timeOut = 5000) // time in milliseconds
//	public void testThisShouldPass() throws InterruptedException {
//		Thread.sleep(4000);
//	}
// 
//	@Test(timeOut = 1000)
//	public void testThisShouldFail() {
//		while (true);
//	}
 
}