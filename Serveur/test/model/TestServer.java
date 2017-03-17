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
		 * Dans ce test, on vérifie que les utilisateurs ajoutés avec succès
		 * Se retrouve bien dans l'ArrayList renvoyé par GetUser
		 * La création d'un deuxième serveur s2 laisse apparaitre des problèmes lors du lancement du deuxième serveur
		 * En effet, l'adresse ip du serveur est déja utilisé, il n'est pas possible de créer un socket vers cette même adresse
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
		//On vérifie que le dernier utilisateur de la liste est l'utilisateur ajouté
		int size = s.getUtilisateurs().size();
		s.addUser(u);
		Utilisateur lastAdded = s.getUtilisateurs().get(size);
		assertTrue(lastAdded == u);
	}
	@Test
	public void testRemoveUser(){
		
		int size = s.getUtilisateurs().size();
		s.removeUser(remove);
		//On verifie que la taille de l'array liste a bien diminué
		assertTrue(size > s.getUtilisateurs().size());
		
		for(Utilisateur a : s.getUtilisateurs()){
				assertFalse(a == remove);
		}

	}
	@Test
	public void testRemoveUserNotConnected(){
		//On vérifie qu'il n'y a pas d'erreur lors du lancement 
		//D'une tentative de suppression d'utilisateur n'étant pas connecté au serveur
		s.removeUser(new Utilisateur("RemoveEmpty"));
	}
	
	//Ces deux testes ne marcheront pas en créant des utilisateurs avec le constructeur passé en commentaire
	//Parce que l'adresse IP n'est pas renseignée
	@Test
	public void testNotConnected(){
		assertFalse(s.isConnected(new Utilisateur("NotConnected")));
	}
	@Test
	public void testConnected(){
		assertTrue(s.isConnected(connected));
	}

	
}
