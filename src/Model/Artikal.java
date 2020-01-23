package Model;

import java.io.Serializable;

public class Artikal implements Serializable {

	private static final long serialVersionUID = 8513445087785125526L;
	
	private String artikal_naziv;
	private double artikal_cjena;
	private String artikal_opis;
	private int artikal_kolicina;
	private String artikal_tip;
	private String artikal_kolicina_vr;
	Restoran restoran_artikal;

	public Artikal()
	{
		super();
		this.artikal_naziv = "";
		this.artikal_cjena = -1.0;
		this.artikal_opis = "";
		this.artikal_kolicina = -1;
		this.artikal_tip = "";
		this.artikal_kolicina_vr = "";
		this.restoran_artikal = new Restoran();
	}
	
	public Artikal(String naziv_artikla, double jedinicna_cjena, String opis_artikla, int kolicina_artikla, String tip_artikla, String kolicinaX, Restoran r) 
	{
		super();
		this.artikal_naziv = naziv_artikla;
		this.artikal_cjena = jedinicna_cjena;
		this.artikal_opis = opis_artikla;
		this.artikal_kolicina = kolicina_artikla;
		this.artikal_tip = tip_artikla;
		this.artikal_kolicina_vr = kolicinaX;
		this.restoran_artikal = r;
	}
	public String getNaziv_artikla() 
	{
		return artikal_naziv;
	}
	public void setNaziv_artikla(String naziv_artikla) 
	{
		this.artikal_naziv = naziv_artikla;
	}
	public double getJedinicna_cjena() 
	{
		return artikal_cjena;
	}
	public void setJedinicna_cjena(double jedinicna_cjena) 
	{
		this.artikal_cjena = jedinicna_cjena;
	}
	public String getOpis_artikla() 
	{
		return artikal_opis;
	}
	public void setOpis_artikla(String opis_artikla) 
	{
		this.artikal_opis = opis_artikla;
	}
	public int getKolicina_artikla() 
	{
		return artikal_kolicina;
	}
	public void setKolicina_artikla(int kolicina_artikla) 
	{
		this.artikal_kolicina = kolicina_artikla;
	}

	public String getArtikal_tip() {
		return artikal_tip;
	}

	public void setArtikal_tip(String artikal_tip) {
		this.artikal_tip = artikal_tip;
	}

	public String getArtikal_kolicina_vr() {
		String news = "";
		if(artikal_tip.equals("jelo"))
		{
			news = artikal_kolicina_vr + " g";
		} else if(artikal_tip.equals("pice"))
		{
			news = artikal_kolicina_vr + " ml";
		} else
		{
			news = artikal_kolicina_vr;
		}
		return news;
	}

	public void setArtikal_kolicina_vr(String artikal_kolicina_vr) {
		this.artikal_kolicina_vr = artikal_kolicina_vr;
	}
	
	public Restoran getRestoran_artikal() {
		return restoran_artikal;
	}
	public String getRestoran_artikal_STRING() {
		String baba = "";
		if(restoran_artikal != null)
		{
			baba = restoran_artikal.getRestoran_naziv();
		}
		return baba;
	}

	public void setRestoran_artikal(Restoran restoran_artikal) {
		this.restoran_artikal = restoran_artikal;
	}
}
