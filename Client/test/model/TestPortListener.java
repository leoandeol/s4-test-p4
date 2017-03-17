package model;

import static org.junit.Assert.*;

import org.junit.*;

public class TestPortListener {

	private PortListener pl;	
	
	@Before
	public void init(){
		Messagerie m = new Messagerie();
		pl = new PortListener(6020, m);
	}
	
	@Test
	public void testRunning(){
		Exception e = null;
		try{
			Thread t = new Thread(pl);
			t.start();
			System.out.println("Is currently running");
		} catch(Exception ex){
			e = ex;
		}
		assertEquals(null, e);

	}
	
	@Test 
	public void test2(){
		Messagerie m = new Messagerie();
		IllegalArgumentException e = null;
		try{
			PortListener p = new PortListener(-666, m);			
		} catch(IllegalArgumentException ex){
			//Si on catch l'exception; le test est bon
			e = ex;
		}
		
		//Sinon le test est faux
		//Si on catch l'exception; le test est bon
		if(e == null){
			assertTrue(false);
		}else{
			assertTrue(true);
		}
	}

}
