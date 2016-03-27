package com.twitter;
   
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa koja sadrzi listu twitter poruka
 * @author Marko Popovic
 *
 */
public class Twitter {
	/** atribut koji predtavlja listu poruka */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Vraca listu poruka koje ova klasa sadrzi
	 * @return lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Formira se nova poruka sa unetim parametrima i unosi na kraj liste 
	 * @param korisnik ime korisnika
	 * @param poruka   poruka korisnika
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/** Vraca niz poruka sa odgovarajucim tagom
	 * @throws java.lang.RuntimeException ukoliko je vrednost paramerta tag null ili ""
	 * @param maxBroj velicina niza poruka koji ce biti vracen
	 * @param tag koji ce biti pretrazen
	 * @return niz poruka koje sadrze odgovarajuci tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
	
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
}