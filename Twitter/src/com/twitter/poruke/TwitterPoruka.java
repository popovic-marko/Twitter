package com.twitter.poruke;

/**
 * Klasa koja predstavlja TwitterPoruku
 * @author Marko Popovic
 *
 */
public class TwitterPoruka {
	
	/**naziv korisnika */
	private String korisnik;
	/** odgovarajuca poruka*/
	private String poruka;
	
	/**
	 * Vraca vrednost atributa korisnik
	 * @return korisnik koji ce biti vracen
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja vrednost atributa korisnik
	 * @throws java.lang.RuntimeException ukoliko je korisnik null || ""
	 * @param korisnik koji ce biti unet
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca vrednost atributa poruka
	 * @return poruka koja ce biti vracena
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Postavlja vrednost atributa poruka
	 * @throws java.lang.RuntimeException ukoliko je poruka null || duza o znakova
	 * @param poruka koja ce biti postavljena
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}