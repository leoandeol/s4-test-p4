package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.*;

public class TestMessageReceiver {

	private MessageReceiver mr;
	
	@Before
	public void init(){
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(System.in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Conversation c = new Conversation();
		mr = new MessageReceiver(in, c);
	}
	
	@Test
	public void isRunning(){
		Exception e = null;
		try{
		Thread t = new Thread(mr);
		t.start();
		System.out.println("Is currently running");
		} catch(Exception ex){
			e = ex;
		}
		assertEquals(null, e);
	}

}
