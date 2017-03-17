package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestMessage {

	private static String sender, texte;
	private static Message mess;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		sender = "Anonymous";
		texte = "Bonsoir!";
		mess = new Message(sender, texte);
	}
	@Test
	public void testToString(){
		System.out.println(mess);
		assertEquals(mess.toString(), "Anonymous : Bonsoir!");
		

	}
	@Test
	public void testConstructeur(){
		Message m = new Message("Test", "Correct");
		assertEquals(m.toString(), "Test : Correct");
	}
}
