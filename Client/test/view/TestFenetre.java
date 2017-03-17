package view;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import controller.*;
import model.Messagerie;

public class TestFenetre {

	Exception ex;
	Fenetre f;
	Messagerie m;

	@Before
	public void initialize(){
		m = new Messagerie();
		f = new Fenetre(m);
	}
	
	@Test
	public void testInit(){
		try{
			f = new Fenetre(m);
		}
		catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}
	
	@Test
	public void testSetControllerBarMenu() {
		try {
			ControllerBarMenu cbm = new ControllerBarMenu(m, f);
			f.setControllerBarMenu(cbm);
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}

	@Test
	public void testSetControllerMessageSender() {
		try {
			ControllerMessageSender cms = new ControllerMessageSender(m, f);
			f.setControllerMessageSender(cms);
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}

	@Test
	public void testGetTextToSend() {
		try {
			f.getTextToSend();
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}

	@Test
	public void testClearMessageField() {
		f.clearMessageField();
		assertEquals("", f.getTextToSend());
	}

	@Test
	public void testgetSelectedTab() {
		try {
			f.getSelectedTab();
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}

	@Test
	public void testRepaint() {
		try {
			f.repaint();
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}

	@Test
	public void testUpdateUserList() {
		try {
			f.updateUserList();
		} catch (Exception e) {
			ex = e;
		}
		assertEquals(null, ex);
	}



}
