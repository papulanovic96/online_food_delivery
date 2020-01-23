package Model;

import java.io.Serializable;

public class Administrator implements Serializable{

	private static final long serialVersionUID = 2048588839153594215L;
	
	private String admin_username;
	private String admin_password;
	private String admin_ime;
	private String admin_prezime;
	private String admin_uloga;
	private String admin_telefon;
	private String admin_email;
	private String admin_datum;
	
	public Administrator()
	{
		super();
		this.admin_username = "";
		this.admin_password = "";
		this.admin_ime = "";
		this.admin_prezime = "";
		this.admin_uloga = "";
		this.admin_telefon = "";
		this.admin_email = "";
		this.admin_datum = "";
	}
	
	public Administrator(String user_name, String user_password, String name, String lastname, String user_type,
			String contact_phone, String email, String registration_date) {
		super();
		this.admin_ime = user_name;
		this.admin_password = user_password;
		this.admin_ime = name;
		this.admin_prezime = lastname;
		this.admin_uloga = user_type;
		this.admin_telefon = contact_phone;
		this.admin_email = email;
		this.admin_datum = registration_date;
	}
	
	public String getUser_name() {
		return admin_username;
	}
	public void setUser_name(String user_name) {
		this.admin_username = user_name;
	}
	public String getUser_password() {
		return admin_password;
	}
	public void setUser_password(String user_password) {
		this.admin_password = user_password;
	}
	public String getName() {
		return admin_ime;
	}
	public void setName(String name) {
		this.admin_ime = name;
	}
	public String getLastname() {
		return admin_prezime;
	}
	public void setLastname(String lastname) {
		this.admin_prezime = lastname;
	}
	public String getUser_type() {
		return admin_uloga;
	}
	public void setUser_type(String user_type) {
		this.admin_uloga = user_type;
	}
	public String getContact_phone() {
		return admin_telefon;
	}
	public void setContact_phone(String contact_phone) {
		this.admin_telefon = contact_phone;
	}
	public String getEmail() {
		return admin_email;
	}
	public void setEmail(String email) {
		this.admin_email = email;
	}
	public String getRegistration_date() {
		return admin_datum;
	}
	public void setRegistration_date(String registration_date) {
		this.admin_datum = registration_date;
	}

}
