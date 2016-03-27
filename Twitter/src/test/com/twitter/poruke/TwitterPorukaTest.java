package test.com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	private TwitterPoruka twitter;
	
	@Before
	public void setUp() throws Exception {
		twitter = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	@Test
	public void testSetKorisnik(){
		twitter.setKorisnik("Marko");
		
		assertEquals("Marko",twitter.getKorisnik());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		
		twitter.setKorisnik(null);
		
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString(){
		
		twitter.setKorisnik("");
		
	}
	
	@Test
	public void testSetPoruka(){
		twitter.setPoruka("Kako si danas?");
		
		assertEquals("Kako si danas?",twitter.getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		
		twitter.setKorisnik(null);
		
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzina(){
		String s = new String();
		for (int i = 0; i < 150; i++) {
			s = s + "a";
		}
		
		twitter.setPoruka(s);
		
	}
	
	@Test
	public void testToString(){
		twitter.setKorisnik("Marko");
		twitter.setPoruka("Kako si?");
		String s = "KORISNIK:" + twitter.getKorisnik() + " PORUKA:" + twitter.getPoruka();
		
		assertEquals(s, twitter.toString());
	}
}
