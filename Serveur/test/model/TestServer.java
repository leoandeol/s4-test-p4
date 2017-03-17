package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServer {	
	/*
	 * Sachant qu'il nous est impossible de cr�er des utilisateurs avec le code fourni
	 * cot� serveur. Les test sont �crits mais ne peuvent �tre test�. 
	 * 
	 */
	private static Server s, s1;
	private static Utilisateur u, connected, remove;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		s = new Server();
		connected = new Utilisateur("Connected");
		remove = new Utilisateur("Remove");
		s.addUser(remove);
		s.addUser(connected);
		u = new Utilisateur("Login");
	}
	
	@Test
	public void testGetUserClass(){
		ArrayList<Utilisateur> a = new ArrayList<Utilisateur>();
		assertTrue(s.getUtilisateurs().getClass() == a.getClass());
	}
	
	@Test
	public void testAddUserAlreadyConnected(){
		s.addUser(u);
		s.addUser(u);
		int compteur = 0;
		for(int i = 0; i < s.getUtilisateurs().size(); i++){
			if(s.getUtilisateurs().get(i) == u)
				compteur++;
		}
		//Si l'on accepte qu'un utiliateur se connecte plusieurs fois sur le serveur
		//assertTrue(compteur > 1);
		//Sinon
		assertFalse(compteur > 1);
	}
	@Test
	public void testGetUser(){
		/*
		 * Dans ce test, on v�rifie que les utilisateurs ajout�s avec succ�s
		 * Se retrouve bien dans l'ArrayList renvoy� par GetUser
		 * La cr�ation d'un deuxi�me serveur s2 laisse apparaitre des probl�mes lors du lancement du deuxi�me serveur
		 * En effet, l'adresse ip du serveur est d�ja utilis�, il n'est pas possible de cr�er un socket vers cette m�me adresse
		 * 
		 */
		Server s2 = new Server();
		ArrayList<Utilisateur> a = new ArrayList<Utilisateur>();
		Utilisateur u2 = new Utilisateur("Login2");
		a.add(u);
		a.add(u2);
		
		s2.addUser(u);
		s2.addUser(u2);
		for(int i = 0; i < s2.getUtilisateurs().size(); i++){			
			assertTrue(s2.getUtilisateurs().get(i) == a.get(i));	
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
		//On v�rifie que le dernier utilisateur de la liste est l'utilisateur ajout�
		int size = s.getUtilisateurs().size();
		s.addUser(u);
		Utilisateur lastAdded = s.getUtilisateurs().get(size);
		assertTrue(lastAdded == u);
	}
	@Test
	public void testRemoveUser(){
		
		int size = s.getUtilisateurs().size();
		s.removeUser(remove);
		//On verifie que la taille de l'array liste a bien diminu�
		assertTrue(size > s.getUtilisateurs().size());
		
		for(Utilisateur a : s.getUtilisateurs()){
				assertFalse(a == remove);
		}

	}
	@Test
	public void testRemoveUserNotConnected(){
		//On v�rifie qu'il n'y a pas d'erreur lors du lancement 
		//D'une tentative de suppression d'utilisateur n'�tant pas connect� au serveur
		s.removeUser(new Utilisateur("RemoveEmpty"));
	}
	
	//Ces deux testes ne marcheront pas en cr�ant des utilisateurs avec le constructeur pass� en commentaire
	//Parce que l'adresse IP n'est pas renseign�e
	@Test
	public void testNotConnected(){
		assertFalse(s.isConnected(new Utilisateur("NotConnected")));
	}
	@Test
	public void testConnected(){
		assertTrue(s.isConnected(connected));
	}

	
}
