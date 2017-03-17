package model;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Before;
import org.junit.Test;

public class TestMessageSender {

	private MessageSender ms;

	@Before
	public void init(){
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Conversation c = new Conversation();
		ms = new MessageSender(out, c);
	}

	@Test
	public void isRunning(){
		Exception e = null;
		try{
			Thread t = new Thread(ms);
			t.start();
			System.out.println("Is currently running");
		} catch(Exception ex){
			e = ex;
		}
		assertEquals(null, e);
	}



}
