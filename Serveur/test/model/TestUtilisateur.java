package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestUtilisateur {
	
	/* Cette classe s'apparente à la classe Utilisateur du côté client
	 * N'ayant qu'un constructeur par recopie, et n'ayant pas accès aux classes
	 * Du côté client. Il ne nous est pas possible de tester les fonctions de cette classe. 
	 * Normalement, la classe étant quasiment la même à quelques détails près, les testes de la classe
	 * Utilisateur côté client seront les mêmes.
	 * Les tests ici seront écrits, mais pas 
	 */
	private static Utilisateur u, u2;
	private static String log1, log2;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		log1 = new String("Login1");
		log2 = new String("Login2");
		u = new Utilisateur(log1);
		u2 = new Utilisateur(log2);
	}
	
	@Test
	public void testConstructeurParRecopie(){
		Utilisateur u2 = new Utilisateur(u);
		assertTrue(u2.toString() == u.toString());
		assertTrue(u2.getLogin() == u.getLogin());
		assertTrue(u2.getIpAdrr() == u.getIpAdrr());
		assertTrue(u2.getPublicKey() == u.getPublicKey());
		assertTrue(u2.getPrivateKey() == null);
	}
	
	@Test
	public void testSetIpAdrr(){
		u2.setIpAdrr("127.0.0.1");
		assertTrue(u2.getIpAdrr().equals("127.0.0.1"));
	}
	@Test
	public void testSetIncorrectIpAdrr(){
		String prevIp = u2.getIpAdrr(); 
		u2.setIpAdrr("bateau");
		assertTrue(u2.getIpAdrr().equals(prevIp));
		assertFalse(u2.getIpAdrr().equals("bateau"));
	}
	
	@Test
	public void testGetLogin(){
		assertTrue(u.getLogin().equals(log1));
	}
	@Test
	public void testGetPublicKey(){
		
	}
	@Test
	public void testGetPrivateKey(){
		
	}
	@Test
	public void testToString(){
		assertTrue(u.toString().equals(log1));
	}
	
	//TO FINIR
	
}
