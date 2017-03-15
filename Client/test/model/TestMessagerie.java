package model;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.*;

public class TestMessagerie {
	
	private Messagerie mess;
	
	@Before
	public void initialize(){
		mess = new Messagerie();
	}

	@Test
	public void testConnecTo(){
		
	}
	
	@Test
	public void testConnectToServer(){
		
	}
	
	@Test
	public void testAddConversation() {
		Conversation c = new Conversation();
		mess.addConversation(c);
		assertTrue(mess.getConversations().contains(c));
	}
	
	@Test
	public void testGetConversations(){
		
	}
	
	@Test
	public void testGetDestinataires(){
		ArrayList<Utilisateur> user = new ArrayList<Utilisateur>();
		mess.setDestinataires(user);
		assertEquals(mess.getDestinataires(), user);
	}
	
	
	@Test
	public void testSetDestinataires(){
		ArrayList<Utilisateur> user1 = new ArrayList<Utilisateur>();
		mess.setDestinataires(user1);
		assertEquals(mess.getDestinataires(), user1);
	}
	
	@Test
	public void testSetGetUtilisateur(){
		//Il est impossible de tester les getters et setter independamment
		Utilisateur u = new Utilisateur("u1");
		mess.setUtilisateur(u);
		assertEquals(u, mess.getUtilisateur());
	}

}
