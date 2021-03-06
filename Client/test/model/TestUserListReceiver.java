package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.Before;
import org.junit.Test;

public class TestUserListReceiver {

	private UserListReceiver ulr;

	@Before
	public void init(){
		Messagerie m = new Messagerie();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(System.in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ulr = new UserListReceiver(in, m);
	}

	@Test
	public void isRunning(){
		Exception e = null;
		try{
			Thread t = new Thread(ulr);
			t.start();
			System.out.println("Is currently running");
		} catch(Exception ex){
			e = ex;
		}
		assertEquals(null, e);
	}


}
