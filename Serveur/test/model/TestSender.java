package model;

import static org.junit.Assert.*;

import java.io.ObjectOutputStream;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSender {

    
    @Test
    public static void setUpBeforeClass(){
    	ObjectOutputStream out = new ObjectOutputStream();
    	
    	Thread t = new Thread(new Sender())
    }
    
    

}
