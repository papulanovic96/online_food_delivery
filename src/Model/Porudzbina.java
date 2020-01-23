package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Porudzbina implements Serializable {

	private static final long serialVersionUID = 1069683917851330615L;

	private HashMap<Artikal, Integer> lista_stavki;
	private String porudzbina_datumivrijeme;
	private Korisnik porudzbina_kupac;
	private Dostavljac porudzbina_dostavljac;
	private String porudzbina_status;
	private String porudzbina_napomena;
	
	public Porudzbina()
	{
		super();
		this.lista_stavki = new HashMap<Artikal, Integer>();
		this.porudzbina_datumivrijeme = "";
		this.porudzbina_kupac = new Korisnik();
		this.porudzbina_dostavljac = new Dostavljac();
		this.porudzbina_status = "";
		this.porudzbina_napomena = "";
	}
	
	public Porudzbina(HashMap<Artikal, Integer> lista_stavki, String porudzbina_datumivrijeme, Korisnik porudzbina_kupac, Dostavljac porudzbina_dostavljac, String porudzbina_status, String porudzbina_napomena, List<String> porudzbina_komentari) {
		super();
		this.lista_stavki = lista_stavki;
		this.porudzbina_datumivrijeme = porudzbina_datumivrijeme;
		this.porudzbina_kupac = porudzbina_kupac;
		this.porudzbina_dostavljac = porudzbina_dostavljac;
		this.porudzbina_status = porudzbina_status;
		this.porudzbina_napomena = porudzbina_napomena;
	}
	public HashMap<Artikal, Integer> getLista_stavki() {
		return lista_stavki;
	}
	public String cjena_Porudzbe()
	{
		double novi_kljuc = 0.0;
		for(Artikal kljuc:lista_stavki.keySet())
		{
			novi_kljuc = kljuc.getJedinicna_cjena();
		}
		String aa = String.valueOf(novi_kljuc);
	    return aa;
	}
	public List<String> ispis_mape()
	{
		if(lista_stavki == null)
		{
			lista_stavki = new HashMap<Artikal, Integer>();
		}
		List<String> novi_kljuc = new ArrayList<String>();
		for(Artikal kljuc:lista_stavki.keySet())
		{
			novi_kljuc.add(kljuc.getNaziv_artikla());
		}
	    return novi_kljuc;
	}
	public List<String> ispis_mape_vrijednost()
	{
		List<String> nova_vri = new ArrayList<String>();
		for(int vrijednost:lista_stavki.values())
		{
			String aa = String.valueOf(vrijednost);
			nova_vri.add(aa);
		}
	    return nova_vri;
	}
	public int ispis_mape_vrijednost_int()
	{
		Integer nova_vri = 0;
		for(int vrijednost:lista_stavki.values())
		{
			nova_vri = vrijednost;
		}
	    return  nova_vri;
	}
	public String ispis_mape_STRING()
	{
		String nova_vri = "";
		for(Artikal vrijednost:lista_stavki.keySet())
		{
			nova_vri = vrijednost.getNaziv_artikla();
		}
	    return  nova_vri;
	}
	
	public void setLista_stavki(HashMap<Artikal, Integer> lista_stavki) {
		this.lista_stavki = lista_stavki;
	}
	public String getPorudzbina_datumivrijeme() {
		return porudzbina_datumivrijeme;
	}
	public void setPorudzbina_datumivrijeme(String porudzbina_datumivrijeme) {
		this.porudzbina_datumivrijeme = porudzbina_datumivrijeme;
	}
	public Korisnik getPorudzbina_kupac() {
		return porudzbina_kupac;
	}
	public String getPorudzbina_kupac_NAZIV()
	{
		if(porudzbina_kupac == null)
		{
			porudzbina_kupac = new Korisnik();
		}
		return porudzbina_kupac.getName();
	}
	public void setPorudzbina_kupac(Korisnik porudzbina_kupac) {
		this.porudzbina_kupac = porudzbina_kupac;
	}
	public Dostavljac getPorudzbina_dostavljac() {
		return porudzbina_dostavljac;
	}
	public String getPorudzbina_dostavljac_NAZIV()
	{
		if(porudzbina_dostavljac == null)
		{
			porudzbina_dostavljac = new Dostavljac();
		}
		return porudzbina_dostavljac.getName();
	}
	public void setPorudzbina_dostavljac(Dostavljac porudzbina_dostavljac) {
		this.porudzbina_dostavljac = porudzbina_dostavljac;
	}
	public String getPorudzbina_status() {
		return porudzbina_status;
	}
	public void setPorudzbina_status(String porudzbina_status) {
		this.porudzbina_status = porudzbina_status;
	}
	public String getPorudzbina_napomena() {
		return porudzbina_napomena;
	}
	public void setPorudzbina_napomena(String porudzbina_napomena) {
		this.porudzbina_napomena = porudzbina_napomena;
	}
}
