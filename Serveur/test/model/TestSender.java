package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSender {

    
    @Test
    public void testIsWorking(){
    	//La connexion avec le socket n'ayant pas été accepté, il n'est pas possible de faire marcher ce test
    	// le code adéquate aurait été soc.accept().getOutputStream() en première argument
    	ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream((new Socket(InetAddress.getLocalHost(), 6020).getOutputStream()));
			Thread t = new Thread(new Sender(oos, new Server(), new Utilisateur("Log")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    

}
