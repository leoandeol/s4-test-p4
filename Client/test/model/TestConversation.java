package model;

import static org.junit.Assert.*;

import javax.crypto.SecretKey;

import org.junit.*;

import security.AES;

public class TestConversation {
	
	private Utilisateur u1, u2;
	private Conversation c1, c2;
	private Message m1, m2, m3;
	private String mess;
	
	@Before
	public void initialize(){
		//Instanciation des objets nécessaires aux tests
		//Création d'une conversation sans argument
		c1 = new Conversation();
		
		//Création d'une conversation avec utilisateur en argument
		u1 = new Utilisateur("user1");
		u2 = new Utilisateur("user2");
		c2 = new Conversation(u1);
		
		//Pour les tests de messages
		m1 = new Message("sender", "Salut");
		m2 = new Message("sender", "Comment va ?");
		m3 = new Message("sender", "Au revoir !");
		mess = m1.toString() + "\n" + m2.toString() + "\n" + m3.toString() + "\n";
	}
		
	@Test
	public void testConversation(){
		//Test du constructeur
		assertEquals(c2.getReceiver(), u1);
	}
	
	@Test
	public void testGetReceiver1(){
		//test sur la conversation c1 (constructeur vide)
		assertEquals(c1.getReceiver(), null);
	}
	
	@Test
	public void testGetReceiver2() {
		//test sur la conversation c2
		assertEquals(c2.getReceiver(), u1);
	}
	
	@Test
	public void testSetReceiver1(){
		//test de modification de receiver
		assertEquals(c1.getReceiver(), null);
		c1.setReceiver(u1);
		assertEquals(c1.getReceiver(), u1);
	}
	
	@Test
	public void testSetReceiver2(){
		assertEquals(c2.getReceiver(), u1);
		c2.setReceiver(u2);
		assertEquals(c2.getReceiver(), u2);
	}
	
	@Test
	public void testgetToSendMessages(){
		c2.send(m1);
		assertTrue(c2.getToSendMessages().contains(m1));
	}
	
	@Test
	public void testAddMessage(){
		c1.addMessage(m2);
		assertEquals(m2.toString() + "\n", c1.readMessages());
	}
	
	@Test
	public void testSend(){
		c2.send(m3);
		assertTrue(c2.getToSendMessages().contains(m3));
	}
	
	@Test
	public void testReadmessage1(){
		c2.addMessage(m1);
		assertEquals(m1.toString() + "\n", c2.readMessages());
	}
	
	@Test 
	public void testReadMessage2(){
		c1.addMessage(m1);
		c1.addMessage(m2);
		c1.addMessage(m3);
		assertEquals(mess, c1.readMessages());
	}
	
	@Test
	public void testGetCryptedAesKey(){

	}
	
	@Test
	public void testSetGetAesKey(){
		//Il est impossible de tester le getter et le setter indépendamment
		//car la clé est generé automatiquement dans le constructeur
		SecretKey test = AES.generateKey();
		c1.setAesKey(test);
		assertEquals(test, c1.getAesKey());
	}
}
