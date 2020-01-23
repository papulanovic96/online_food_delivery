package Model;

import java.io.Serializable;

public class Vozila implements Serializable{

	private static final long serialVersionUID = 2082107659978754955L;
	
	private String vozilo_marka;
	private String vozilo_model;
	private String vozilo_tip;
	private String vozilo_registracija;
	private int vozilo_godiste;
	private String vozilo_upotreba;
	private String vozilo_napomena;
	
	public Vozila()
	{
		super();
		this.vozilo_marka = "";
		this.vozilo_model = "";
		this.vozilo_tip = "";
		this.vozilo_registracija = "";
		this.vozilo_godiste = -1;
		this.vozilo_upotreba = "";
		this.vozilo_napomena = "";
	}
	
	public Vozila(String marka_vozila, String model_vozila, String tip_vozila, String registracija_vozila,
			int god_proizvodnje_vozila, String uoptreba_vozila, String napomena) {
		super();
		this.vozilo_marka = marka_vozila;
		this.vozilo_model = model_vozila;
		this.vozilo_tip = tip_vozila;
		this.vozilo_registracija = registracija_vozila;
		this.vozilo_godiste = god_proizvodnje_vozila;
		this.vozilo_upotreba = uoptreba_vozila;
		this.vozilo_napomena = napomena;
	}
	public String getMarka_vozila() {
		return vozilo_marka;
	}
	public void setMarka_vozila(String marka_vozila) {
		this.vozilo_marka = marka_vozila;
	}
	public String getModel_vozila() {
		return vozilo_model;
	}
	public void setModel_vozila(String model_vozila) {
		this.vozilo_model = model_vozila;
	}
	public String getTip_vozila() {
		return vozilo_tip;
	}
	public void setTip_vozila(String tip_vozila) {
		this.vozilo_tip = tip_vozila;
	}
	public String getRegistracija_vozila() {
		return vozilo_registracija;
	}
	public void setRegistracija_vozila(String registracija_vozila) {
		this.vozilo_registracija = registracija_vozila;
	}
	public int getGod_proizvodnje_vozila() {
		return vozilo_godiste;
	}
	public void setGod_proizvodnje_vozila(int god_proizvodnje_vozila) {
		this.vozilo_godiste = god_proizvodnje_vozila;
	}
	public String isUpotreba_vozila() {
		return vozilo_upotreba;
	}
	public void setUpotreba_vozila(String upotreba_vozila) {
		this.vozilo_upotreba = upotreba_vozila;
	}
	public String getNapomena() {
		return vozilo_napomena;
	}
	public void setNapomena(String napomena) {
		this.vozilo_napomena = napomena;
	}

}
