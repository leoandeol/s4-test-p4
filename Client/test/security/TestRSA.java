package security;

import static org.junit.Assert.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.*;

import org.junit.*;


public class TestRSA {

	private KeyPair key;
	private Exception ex;
	private PrivateKey prk;
	private PublicKey puk;
	private SecretKey sk;
	private String s = "salut !";
	
	
	@Before
	public void init(){
		key = RSA.generateKeyPair();
		prk = key.getPrivate();
		puk = key.getPublic();
		sk = AES.generateKey();
	}
	
	@Test
	public void testGenerateKeyPair(){
		Exception e = null;
		try{
			key = RSA.generateKeyPair();
		}catch(Exception ex){
			e = ex;
		}
		assertEquals(e, null);
	}
	
	
	@Test
	public void testDecryptEncrypt(){
		byte[] text = RSA.encrypt(s, puk);
		assertEquals(RSA.decrypt(text, prk), s);
	}
	
	@Test
	public void testEncryptDecryptSK(){
		byte[] enc = RSA.encryptSecretKey(sk, puk);
		assertEquals(RSA.decryptAESKey(enc, prk), sk);
	}
	
	
}
