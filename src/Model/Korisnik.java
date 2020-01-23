package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Korisnik implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7140199464533533118L;

	private String korisnik_username;
	private String korisnik_password;
	private String korisnik_ime;
	private String korisnik_prezime;
	private String korisnik_uloga;
	private String korisnik_telefon;
	private String korisnik_email;
	private String korisnik_datum_reg;
	private List<Porudzbina> porudzbine;
	private List<Restoran> omiljeni_restorani;
	private int broj_porudzbina;
	
	public Korisnik()
	{
		super();
		this.korisnik_username = "";
		this.korisnik_password = "";
		this.korisnik_ime = "";
		this.korisnik_prezime = "";
		this.korisnik_uloga = "";
		this.korisnik_telefon = "";
		this.korisnik_email = "";
		this.korisnik_datum_reg = "";
		this.broj_porudzbina = 0;
		this.setPorudzbine(new ArrayList<Porudzbina>());
		this.setOmiljeni_restorani(new ArrayList<Restoran>());
	}
	
	public Korisnik(String user_name, String user_password, String name, String lastname, String user_type,
			String contact_phone, String email, String registration_date, List<Porudzbina> porudzbina_new, List<Restoran> restoran_new, int a) {
		super();
		this.korisnik_username = user_name;
		this.korisnik_password = user_password;
		this.korisnik_ime = name;
		this.korisnik_prezime = lastname;
		this.korisnik_uloga = user_type;
		this.korisnik_telefon = contact_phone;
		this.korisnik_email = email;
		this.korisnik_datum_reg = registration_date;
		this.setPorudzbine(porudzbina_new);
		this.setOmiljeni_restorani(restoran_new);
		this.broj_porudzbina = a;
	}
	public String getUser_name() {
		return korisnik_username;
	}
	public void setUser_name(String user_name) {
		this.korisnik_username = user_name;
	}
	public String getUser_password() {
		return korisnik_password;
	}
	public void setUser_password(String user_password) {
		this.korisnik_password = user_password;
	}
	public String getName() {
		return korisnik_ime;
	}
	public void setName(String name) {
		this.korisnik_ime = name;
	}
	public String getLastname() {
		return korisnik_prezime;
	}
	public void setLastname(String lastname) {
		this.korisnik_prezime = lastname;
	}
	public String getUser_type() {
		return korisnik_uloga;
	}
	public void setUser_type(String user_type) {
		this.korisnik_uloga = user_type;
	}
	public String getContact_phone() {
		return korisnik_telefon;
	}
	public void setContact_phone(String contact_phone) {
		this.korisnik_telefon = contact_phone;
	}
	public String getEmail() {
		return korisnik_email;
	}
	public void setEmail(String email) {
		this.korisnik_email = email;
	}
	public String getRegistration_date() {
		return korisnik_datum_reg;
	}
	public void setRegistration_date(String registration_date) {
		this.korisnik_datum_reg = registration_date;
	}
	public Porudzbina getJednuSamo()
	{
		Porudzbina p = new Porudzbina();
		if(porudzbine == null)
		{
			porudzbine = new ArrayList<Porudzbina>();
		}
		for(Porudzbina x:porudzbine)
		{	
				p = x;
				break;
		}
		
		return p;
	}
	public List<Porudzbina> getPorudzbine() {
		return porudzbine;
	}
	public void setBroj_porudzbina(int broj_porudzbina) {
		this.broj_porudzbina = broj_porudzbina;
	}
	public void addPorudzbinu(Porudzbina porudzbina)
	{
		if(porudzbine == null)
		{
			porudzbine = new ArrayList<Porudzbina>();
		} else
		{
			porudzbine.add(porudzbina);
		}
	}
	public int getBrojPorudzbina()
	{
		if(porudzbine == null)
		{
			porudzbine = new ArrayList<Porudzbina>();
		}
		int broj = 0;
		for(Porudzbina p:porudzbine)
		{
			if(p.getPorudzbina_status().equals("Poruèeno"))
			{
				broj += 1;
			}
		}
		broj_porudzbina = broj;
		
		return broj_porudzbina;
	}
	public List<String> getPorString()
	{
		if(porudzbine == null)
		{
			porudzbine = new ArrayList<Porudzbina>();
		}
		List<String> lista = new ArrayList<String>();
		for(Porudzbina a:porudzbine)
		{
			lista = a.ispis_mape();
		}
		return lista;
	}
	public void setPorudzbine(List<Porudzbina> porudzbine) {
		this.porudzbine = porudzbine;
	}

	public List<Restoran> getOmiljeni_restorani() {
		return omiljeni_restorani;
	}
	public List<String> getOmiljeniString()
	{
		if(omiljeni_restorani == null)
		{
			omiljeni_restorani = new ArrayList<Restoran>();
		}
		List<String> lista = new ArrayList<String>();
		for(Restoran a:omiljeni_restorani)
		{
			lista.add(a.getRestoran_naziv());
		}
		return lista;
	}

	public void setOmiljeni_restorani(List<Restoran> omiljeni_restorani) {
		this.omiljeni_restorani = omiljeni_restorani;
	}
	
	public static void addUser(Korisnik kupac, String file)  {
		
		BufferedWriter writer = null;
		try {
			 writer = new BufferedWriter(new FileWriter(new File(file), true));
		
			writer.newLine();
			writer.write(kupac.toString());
	
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}
