package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class InstanceOPH implements Serializable{

	private static final long serialVersionUID = 7365769283646815932L;
	//geteri i seteri
	public List<Korisnik> getListaKorisnika() {
		return listaKorisnika;
	}

	public void setListaKorisnika(List<Korisnik> listaKorisnika) {
		this.listaKorisnika = listaKorisnika;
	}

	public List<Vozila> getListaVozila() {
		return listaVozila;
	}

	public void setListaVozila(List<Vozila> listaVozila) {
		this.listaVozila = listaVozila;
	}

	public HashMap<Artikal, Integer> getListaTop10() {
		return listaTop10;
	}

	public void setListaTop10(HashMap<Artikal, Integer> listaTop10) {
		this.listaTop10 = listaTop10;
	}

	//polja
	private static InstanceOPH instance = null;
	
	private List<Korisnik> listaKorisnika;
	private List<Administrator> listaAdmina;
	private List<Artikal> listaArtikala;
	private List<Dostavljac> listaDostavljaca;
	private List<Vozila> listaVozila;
	private HashMap<Artikal, Integer> listaTop10;
	private List<Restoran> listaRestorana;
	private List<Restoran> listaOmiljenihRestorana;
	private List<Porudzbina> listaPorudzbina;
	
	
	public static InstanceOPH getInstance()
	{
		if(instance == null)
		{
			instance = new InstanceOPH();
			try {
				InstanceOPH.instance.loadFromFile();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return instance;
	}
	
	private InstanceOPH()
	{
			listaArtikala = new ArrayList<Artikal>();
			listaKorisnika = new ArrayList<Korisnik>();
			listaVozila = new ArrayList<Vozila>();
			listaTop10 = new HashMap<Artikal, Integer>();
			listaAdmina = new ArrayList<Administrator>();
			listaDostavljaca = new ArrayList<Dostavljac>();
			listaRestorana = new ArrayList<Restoran>();
			listaPorudzbina = new ArrayList<Porudzbina>();
			listaOmiljenihRestorana = new ArrayList<Restoran>();
	}
	//ARTIKLI
	public Artikal getArtikal(String naziv)
	{
		if(this.listaArtikala == null)
		{
			listaArtikala = new ArrayList<Artikal>();
		} else
		{
			for(Artikal artikal:listaArtikala)
			{
				if(artikal.getNaziv_artikla().equalsIgnoreCase(naziv))
				{
					return artikal;
				}
			}
		}
		return null;
	}
	public void addArtikal(Artikal artikal)
	{
		if(artikal == null)
		{
			return;
		} else if(this.listaArtikala == null)
		{
			this.listaArtikala = new ArrayList<Artikal>();
		} else if(this.listaArtikala != null)
		{
			this.listaArtikala.add(artikal);
		}
	}
	
	public void deleteArtikal(Artikal artikal)
	{
		if(artikal == null)
		{
			return;
		} else if(this.listaArtikala.contains(artikal))
		{
			this.listaArtikala.remove(artikal);
		}
	}
	
	
	//RESTORANI
	public Restoran getRestoran(String naziv)
	{
		if(this.listaRestorana == null)
		{
			listaRestorana = new ArrayList<Restoran>();
		} else
		{
			for(Restoran restoran:listaRestorana)
			{
				if(restoran.getRestoran_naziv().equalsIgnoreCase(naziv))
				{
					return restoran;
				}
			}
		}
		return null;
	}
	public void addRestoran(Restoran restoran)
	{
		if(restoran == null)
		{
			return;
		} else if(this.listaRestorana == null)
		{
			this.listaRestorana = new ArrayList<Restoran>();
		} else if(this.listaRestorana != null)
		{
			this.listaRestorana.add(restoran);
		}
	}
	
	public void deleteRestoran(Restoran restoran)
	{
		if(restoran == null)
		{
			return;
		} else if(this.listaRestorana.contains(restoran))
		{
			this.listaRestorana.remove(restoran);
		}
	}
	//Omiljeni restorani
	
	public Restoran getRestoran_omiljeni(String naziv)
	{
		if(this.listaOmiljenihRestorana == null)
		{
			listaOmiljenihRestorana = new ArrayList<Restoran>();
		} else
		{
			for(Restoran restoran:listaOmiljenihRestorana)
			{
				if(restoran.getRestoran_naziv().equalsIgnoreCase(naziv))
				{
					return restoran;
				}
			}
		}
		return null;
	}
	public void addRestoran_omiljeni(Restoran restoran)
	{
		if(restoran == null)
		{
			return;
		} else if(this.listaOmiljenihRestorana == null)
		{
			this.listaOmiljenihRestorana = new ArrayList<Restoran>();
		} else if(this.listaOmiljenihRestorana != null)
		{
			this.listaOmiljenihRestorana.add(restoran);
		}
	}
	
	public void deleteRestoran_omiljeni(Restoran restoran)
	{
		if(restoran == null)
		{
			return;
		} else if(this.listaOmiljenihRestorana.contains(restoran))
		{
			this.listaOmiljenihRestorana.remove(restoran);
		}
	}
	
	//VOZILA
	public Vozila getVozilo(String model)
	{
		if(this.listaVozila == null)
		{
			listaVozila = new ArrayList<Vozila>();
		} else
		{
			for(Vozila vozilo:listaVozila)
			{
				if(vozilo.getModel_vozila().equalsIgnoreCase(model))
				{
					return vozilo;
				}
			}
		}
		return null;
	}
	public void addVozilo(Vozila vozilo)
	{
		if(vozilo == null)
		{
			return;
		} else if(this.listaVozila == null)
		{
			this.listaVozila = new ArrayList<Vozila>();
		} else if(this.listaVozila != null)
		{
			this.listaVozila.add(vozilo);
		}
	}
	
	public void deleteVozilo(Vozila vozilo)
	{
		if(vozilo == null)
		{
			return;
		} else if(this.listaVozila.contains(vozilo))
		{
			this.listaVozila.remove(vozilo);
		}
	}
	//KORISNICI
	public Korisnik getKorisnik(String username)
	{
		if(this.listaKorisnika == null)
		{
			listaKorisnika = new ArrayList<Korisnik>();
		} else
		{
			for(Korisnik korisnik:listaKorisnika)
			{
				if(korisnik.getUser_name().equalsIgnoreCase(username))
				{
					return korisnik;
				}
			}
		}
		return null;
	}
	public void addKorisnik(Korisnik korisnik)
	{
		if(korisnik == null)
		{
			return;
		} else if(this.listaKorisnika == null)
		{
			this.listaKorisnika = new ArrayList<Korisnik>();
		} else if(this.listaKorisnika != null)
		{
			this.listaKorisnika.add(korisnik);
		}
	}
	
	public void deleteKorisnik(Korisnik korisnik)
	{
		if(korisnik == null)
		{
			return;
		} else if(this.listaKorisnika.contains(korisnik))
		{
			this.listaKorisnika.remove(korisnik);
		}
	}
	
	//ADMIN
	
	public Administrator getAdmin(String username)
	{
		if(this.listaAdmina == null)
		{
			listaAdmina = new ArrayList<Administrator>();
		} else
		{
			for(Administrator admin:listaAdmina)
			{
				if(admin.getUser_name().equalsIgnoreCase(username))
				{
					return admin;
				}
			}
		}
		return null;
	}
	public void addAdmin(Administrator admin)
	{
		if(admin == null)
		{
			return;
		} else if(this.listaAdmina == null)
		{
			this.listaAdmina = new ArrayList<Administrator>();
		} else if(this.listaAdmina != null)
		{
			this.listaAdmina.add(admin);
		}
	}
	
	public void deleteAdmin(Administrator admin)
	{
		if(admin == null)
		{
			return;
		} else if(this.listaAdmina.contains(admin))
		{
			this.listaAdmina.remove(admin);
		}
	}
	//DOSTAVA
	public Dostavljac getDostava(String username)
	{
		if(this.listaDostavljaca == null)
		{
			listaDostavljaca = new ArrayList<Dostavljac>();
		} else
		{
			for(Dostavljac dostava:listaDostavljaca)
			{
				if(dostava.getUser_name().equalsIgnoreCase(username)) 
				{
					return dostava;
				}
			}
		}
		return null;
	}
	public void addDostavljac(Dostavljac dostava)
	{
		if(dostava == null)
		{
			return;
		} else if(this.listaDostavljaca == null)
		{
			this.listaDostavljaca = new ArrayList<Dostavljac>();
		} else if(this.listaDostavljaca != null)
		{
			this.listaDostavljaca.add(dostava);
		}
	}
	
	public void deleteDostavljac(Dostavljac dostava)
	{
		if(dostava == null)
		{
			return;
		} else if(this.listaDostavljaca.contains(dostava))
		{
			this.listaDostavljaca.remove(dostava);
		}
	}
	//PORUDZBINE
	
	public Porudzbina getPorudzbina(String datentime)
	{
		if(this.listaPorudzbina == null)
		{
			listaPorudzbina = new ArrayList<Porudzbina>();
		} else
		{
			for(Porudzbina poru:listaPorudzbina)
			{
				if(poru.getPorudzbina_datumivrijeme().equalsIgnoreCase(datentime))
				{
					return poru;
				}
			}
		}
		return null;
	}
	public void addPorudzbina(Porudzbina poru)
	{
		if(poru == null)
		{
			return;
		} else if(this.listaPorudzbina == null)
		{
			this.listaPorudzbina = new ArrayList<Porudzbina>();
		} else if(this.listaPorudzbina != null)
		{
			this.listaPorudzbina.add(poru);
		}
	}
	
	public void deletePorudzbina(Porudzbina poru)
	{
		if(poru == null)
		{
			return;
		} else if(this.listaPorudzbina.contains(poru))
		{
			this.listaPorudzbina.remove(poru);
		}
	}
	
	
	public void saveToFile()
	{
		
		FileOutputStream fout=null;
		ObjectOutputStream oos=null;
		
		try {
			fout = new FileOutputStream("C:\\Users\\Papulanovic\\Desktop\\Project F\\workspace_1552\\Project_F_OPH\\WebContent\\lista_svih_admin.txt");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
	        if(oos  != null){
	            try {
	            	System.out.println("saved...");
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         } 
		}
	}
	public void loadFromFile()
	{
		FileInputStream fin=null;
		ObjectInputStream ois=null;
		
		try {
			fin = new FileInputStream("C:\\Users\\Papulanovic\\Desktop\\Project F\\workspace_1552\\Project_F_OPH\\WebContent\\lista_svih_admin.txt");
			ois = new ObjectInputStream(fin);
			InstanceOPH.instance = (InstanceOPH) ois.readObject();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(ois!=null)
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Dostavljac> getListaDostavljaca() {
		return listaDostavljaca;
	}

	public void setListaDostavljaca(List<Dostavljac> listaDostavljaca) {
		this.listaDostavljaca = listaDostavljaca;
	}

	public List<Administrator> getListaAdmina() {
		return listaAdmina;
	}

	public void setListaAdmina(List<Administrator> listaAdmina) {
		this.listaAdmina = listaAdmina;
	}

	public List<Restoran> getListaRestorana() {
		return listaRestorana;
	}

	public void setListaRestorana(List<Restoran> listaRestorana) {
		this.listaRestorana = listaRestorana;
	}


	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}

	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}

	public List<Porudzbina> getListaPorudzbina() {
		return listaPorudzbina;
	}

	public void setListaPorudzbina(List<Porudzbina> listaPorudzbina) {
		this.listaPorudzbina = listaPorudzbina;
	}

	public List<Restoran> getListaOmiljenihRestorana() {
		return listaOmiljenihRestorana;
	}

	public void setListaOmiljenihRestorana(List<Restoran> listaOmiljenihRestorana) {
		this.listaOmiljenihRestorana = listaOmiljenihRestorana;
	}
	public HashMap<Artikal, Integer> sortByComparator(HashMap<Artikal, Integer> unsortMap,  boolean order)
    {

        List<Entry<Artikal, Integer>> list = new LinkedList<Entry<Artikal, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<Artikal, Integer>>()
        {
            public int compare(Entry<Artikal, Integer> o1,
                    Entry<Artikal, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        HashMap<Artikal, Integer> sortedMap = new LinkedHashMap<Artikal, Integer>();
        for (Entry<Artikal, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
