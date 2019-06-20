import static org.junit.Assert.*;

import org.junit.Test;

public class CalcuratorTest {
	Calcurator c =new Calcurator();
	@Test
	public void testSum(){
		
		double result = c.sum(10,50);
		assertEquals(60,result,0);
	}
	@Test
	public void testTest() {
		
	}
}