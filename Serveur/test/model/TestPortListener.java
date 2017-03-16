package model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestPortListener {

	private static PortListener pl;
	private static Server s;
	private static int port;
	
	@BeforeClass
	public static void setUpBeforClass() {
		s = new Server();
		port = 6020;
		pl = new PortListener(port, s); 
	}
	@Test
	public void isRunning(){
			Thread t = new Thread(pl);
			t.start();
			System.out.println("Is currently running");
	}
	
	@Test 
	public void negativePortThrowIllegalArgumentException(){
		IllegalArgumentException e = null;
		try{
			PortListener p = new PortListener(-666, s);			
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
