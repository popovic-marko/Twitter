package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter twitter;
	
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	@Test
	public void testUnesi(){
		twitter.unesi("Marko", "Kako si?");
		
		assertEquals(1, twitter.vratiSvePoruke().size());
		
		assertEquals("Marko", twitter.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Kako si?", twitter.vratiSvePoruke().get(0).getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull(){
		twitter.vratiPoruke(10, null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString(){
		twitter.vratiPoruke(10, "");
	}
	
	@Test
	public void testVratiPoruke(){
		twitter.unesi("Marko", "@d Kako si?");
		twitter.unesi("Nikola", "@d Danas je lep dan.");
		
		TwitterPoruka[] nizPoruka = twitter.vratiPoruke(2, "@d");
		TwitterPoruka[] niz = new TwitterPoruka[2];
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Marko");
		tp1.setPoruka("@d Kako si?");
		niz[0] = tp1;
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Nikola");
		tp2.setPoruka("@d Danas je lep dan.");
		niz[1] = tp2;
		
		assertEquals(niz[0].getKorisnik(), nizPoruka[0].getKorisnik());
		assertEquals(niz[0].getPoruka(), nizPoruka[0].getPoruka());
		assertEquals(niz[1].getKorisnik(), nizPoruka[1].getKorisnik());
		assertEquals(niz[1].getPoruka(), nizPoruka[1].getPoruka());
	}
}
