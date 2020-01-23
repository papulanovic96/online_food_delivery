package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dostavljac implements Serializable{

	private static final long serialVersionUID = 5436567863099229924L;

	private String dostavljac_username;
	private String dostavljac_password;
	private String dostavljac_ime;
	private String dostavljac_prezime;
	private String dostavljac_uloga;
	private String dostavljac_telefon;
	private String dostavljac_email;
	private String dostavljac_datum;
	private Vozila dostavljac_vozilo;
	private List<Porudzbina> dostavljac_porudzbine;
	
	public Dostavljac()
	{
		super();
		this.dostavljac_username = "";
		this.dostavljac_password = "";
		this.dostavljac_ime = "";
		this.dostavljac_prezime = "";
		this.dostavljac_uloga = "";
		this.dostavljac_telefon = "";
		this.dostavljac_email = "";
		this.dostavljac_datum = "";
		this.setDostavljac_vozilo(null);
		this.dostavljac_porudzbine = new ArrayList<Porudzbina>();
		
	}
	
	public Dostavljac(String user_name, String user_password, String name, String lastname, String user_type,
			String contact_phone, String email, String registration_date) {
		super();
		this.dostavljac_ime = user_name;
		this.dostavljac_password = user_password;
		this.dostavljac_ime = name;
		this.dostavljac_prezime = lastname;
		this.dostavljac_uloga = user_type;
		this.dostavljac_telefon = contact_phone;
		this.dostavljac_email = email;
		this.dostavljac_datum = registration_date;
	}
	
	public String getUser_name() {
		return dostavljac_username;
	}
	public void setUser_name(String user_name) {
		this.dostavljac_username = user_name;
	}
	public String getUser_password() {
		return dostavljac_password;
	}
	public void setUser_password(String user_password) {
		this.dostavljac_password = user_password;
	}
	public String getName() {
		return dostavljac_ime;
	}
	public void setName(String name) {
		this.dostavljac_ime = name;
	}
	public String getLastname() {
		return dostavljac_prezime;
	}
	public void setLastname(String lastname) {
		this.dostavljac_prezime = lastname;
	}
	public String getUser_type() {
		return dostavljac_uloga;
	}
	public void setUser_type(String user_type) {
		this.dostavljac_uloga = user_type;
	}
	public String getContact_phone() {
		return dostavljac_telefon;
	}
	public void setContact_phone(String contact_phone) {
		this.dostavljac_telefon = contact_phone;
	}
	public String getEmail() {
		return dostavljac_email;
	}
	public void setEmail(String email) {
		this.dostavljac_email = email;
	}
	public String getRegistration_date() {
		return dostavljac_datum;
	}
	public void setRegistration_date(String registration_date) {
		this.dostavljac_datum = registration_date;
	}

	public List<Porudzbina> getDostavljac_porudzbine() {
		return dostavljac_porudzbine;
	}
	
	public List<String> getDostavljac_porudzbine_String()
	{
		if(dostavljac_porudzbine == null)
		{
			dostavljac_porudzbine = new ArrayList<Porudzbina>();
		}
		List<String> lista = new ArrayList<String>();
		for(Porudzbina a:dostavljac_porudzbine)
		{
			lista = a.ispis_mape();
		}
		return lista;
	}
	
	public void setDostavljac_porudzbine(List<Porudzbina> dostavljac_porudzbine) {
		this.dostavljac_porudzbine = dostavljac_porudzbine;
	}

	public Vozila getDostavljac_vozilo() {
		return dostavljac_vozilo;
	}
	
	public String getDostavljac_vozilo_String() {
		String novi = "";
		if(dostavljac_vozilo != null)
		{
			novi = dostavljac_vozilo.getModel_vozila();
		}
		return novi;
	}

	public void setDostavljac_vozilo(Vozila dostavljac_vozilo) {
		this.dostavljac_vozilo = dostavljac_vozilo;
	}
}
