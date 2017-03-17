package security;

import static org.junit.Assert.*;
import javax.crypto.*;

import javax.crypto.KeyGenerator;

import org.junit.*;

public class TestAES {

	private Exception ex;
	private String chaineTest = "Bonjour";
	private SecretKey key;
	
	@Before
	public void init(){
		key = AES.generateKey();
	}
	
	@Test
	public void testGenerateKey() {
		try {
			key = AES.generateKey();
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}
	
	@Test
	public void testEncryptDecrypt(){
		String s = AES.encrypt(chaineTest, key);
		assertEquals(chaineTest, AES.decrypt(s, key));
	}

}
