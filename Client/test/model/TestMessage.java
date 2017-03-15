package model;

import static org.junit.Assert.*;

import org.junit.*;

public class TestMessage {
	
	private Message m;

	@Before
	public void initialize(){
		m = new Message("sender", "salut");
	}
	
	@Test
	public void testMessage(){
		assertEquals(m.getTexte(), "salut");
	}
	
	@Test
	public void testToString(){
		assertEquals(m.toString(), "sender : salut");
	}
	
	@Test
	public void testSetTexte(){
		m.setTexte("Au Revoir");
		assertEquals(m.getTexte(), "Au Revoir");
	}
}
