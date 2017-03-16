package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServer {

	
	/*
	 * Sachant qu'il nous est impossible de créer des utilisateurs avec le code fourni
	 * coté serveur. Les test sont écrits mais ne peuvent être testé. 
	 * 
	 */
	private static Server s, s1;
	private static Utilisateur u;
	
	@BeforeClass
	public void setUpBeforeClass() {
		s = new Server();
		s1 = new Server();
		u = new Utilisateur("Login");
	}
	
	@Test
	public void testGetUserClass(){
		ArrayList<Utilisateur> a = new ArrayList<Utilisateur>();
		assertTrue(s.getUtilisateurs().getClass() == a.getClass());
	}
	@Test
	public void testGetUser(){
		ArrayList<Utilisateur> a = new ArrayList<Utilisateur>();
		a.add(u);
		Utilisateur2 u2 = new Utilisateur("Login2");
		a.add();
		Server s2 = new Server();
		s2.addUser(u);
		s2.addUser(u2);
		for(int i = 0; i < a.size(); i++){
			assertTrue(s.getUtilisateurs().get(i) == a.get(i));	
		}

	}
	@Test
	public void testAddUserSize(){
		ArrayList<Utilisateur> a = new ArrayList<Utilisateur>(s.getUtilisateurs());
		int size = s.getUtilisateurs().size();
		//On regarde s'il y a bien augmentation de la taille de l'array
		s.addUser(u);
		assertTrue(size < s.getUtilisateurs().size());
	}
	@Test
	public void testAdUserLast(){
		//On vérifie que le dernier utilisateur de la liste est l'utilisateur ajouté
		int size = s.getUtilisateurs().size();
		s.addUser(u);
		Utilisateur lastAdded = s.getUtilisateurs().get(size);
		assertTrue(lastAdded == u);
	}
	@Test
	public void testRemoveUser(){
		s1.addUser(new Utilisateur());
		s1.addUser(u);
		s1.addUser(new Utilisateur());
		
		int size = s1.getUtilisateurs().size();
		s1.removeUser(u);
		
		assertTrue(size > s1.getUtilisateurs().size());
		
		for(Utilisateur a : s1.getUtilisateurs()){
			if(a == u){
				assertTrue(false);
			}
		}
	}
	
	@Test
	public void testNotConnected(){
		assertFalse(s.isConnected(u));
	}
	public void testConnected(){
		s.addUser(u);
		assertTrue(s.isConnected(u));
	}

	
}
