package model;

import static org.junit.Assert.*;

import org.junit.*;

public class TestUtilisateur {

	private Utilisateur u1, u2;
	
	@Before
	public void initialize(){
		u1 = new Utilisateur("user");
		u1.setIpAdrr("127.0.0.1");
		u2 = new Utilisateur(u1);
	}
	
	@Test
	public void testConstructeur(){
		Utilisateur u = new Utilisateur("u");
		assertEquals(u.getLogin(), "u");
	}
	
	@Test
	public void testConstructeurCopie(){
		assertEquals(u1.getLogin(), u2.getLogin());
		assertEquals(u1.getIpAdrr(), u2.getIpAdrr());
		assertEquals(u1.getPublicKey(), u2.getPublicKey());
		assertEquals(null, u2.getPrivateKey());
	}
	
	@Test
	public void testGetLogin(){
		assertEquals("user", u1.getLogin());
	}
	
	@Test
	public void testSetLogin(){
		u1.setLogin("user1");
		assertEquals("user1", u1.getLogin());
	}
	
	@Test
	public void testGetIpAdrr(){
		assertEquals("127.0.0.1", u1.getIpAdrr());
	}
	
	@Test
	public void testSetIpAdrr(){
		u2.setIpAdrr("127.0.0.0");
		assertEquals(u2.getIpAdrr(), "127.0.0.0");
	}
	
	@Test
	public void testToString(){
		assertEquals(u1.getLogin(), "user");
	}
	
}
