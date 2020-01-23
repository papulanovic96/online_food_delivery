package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restoran implements Serializable {

	private static final long serialVersionUID = -1004177853210564593L;

	private String restoran_naziv;
	private String restoran_adresa;
	private String restoran_kategorija;
	private List<Artikal> lista_jela;
	private List<Artikal> lista_pica;
	
	public Restoran()
	{
		super();
		this.restoran_naziv = "";
		this.restoran_adresa = "";
		this.restoran_kategorija = "";
		this.lista_jela = new ArrayList<Artikal>();
		this.lista_pica = new ArrayList<Artikal>();
	}
	
	
	public Restoran(String restoran_naziv, String restoran_adresa, String restoran_kategorija, List<Artikal> lista_jela,
			List<Artikal> lista_pica) {
		super();
		this.restoran_naziv = restoran_naziv;
		this.restoran_adresa = restoran_adresa;
		this.restoran_kategorija = restoran_kategorija;
		this.lista_jela = lista_jela;
		this.lista_pica = lista_pica;
	}


	public String getRestoran_naziv() {
		return restoran_naziv;
	}
	public void setRestoran_naziv(String restoran_naziv) {
		this.restoran_naziv = restoran_naziv;
	}
	public String getRestoran_adresa() {
		return restoran_adresa;
	}
	public void setRestoran_adresa(String restoran_adresa) {
		this.restoran_adresa = restoran_adresa;
	}
	public String getRestoran_kategorija() {
		return restoran_kategorija;
	}
	public void setRestoran_kategorija(String restoran_kategorija) {
		this.restoran_kategorija = restoran_kategorija;
	}
	public List<Artikal> getLista_jela() {
		return lista_jela;
	}
	public void setLista_jela(List<Artikal> lista_jela) {
		this.lista_jela = lista_jela;
	}
	public List<Artikal> getLista_pica() {
		return lista_pica;
	}
	public List<String> getLista_pica_NAZIVI() {
		List<String> temp = new ArrayList<String>();
		if(lista_pica == null)
		{
			lista_pica = new ArrayList<Artikal>();
		}
		for(Artikal a:lista_pica)
		{
			temp.add(a.getNaziv_artikla());
		}
		return temp;
	}
	public List<String> getLista_jela_NAZIVI() {
		List<String> temp = new ArrayList<String>();
		if(lista_jela == null)
		{
			lista_jela = new ArrayList<Artikal>();
		}
		for(Artikal a:lista_jela)
		{
			temp.add(a.getNaziv_artikla());
		}
		return temp;
	}
	public void setLista_pica(List<Artikal> lista_pica) {
		this.lista_pica = lista_pica;
	}
}
