package week2.Opdracht21;

import java.io.Serializable;

public class Locatie implements Serializable{ 
	private static final long serialVersionUID = 8821811971556117991L;
	private double longitude; 
	private double latitude; 
	private String naam; 

	public Locatie() { 

	} 

	public Locatie(String name, double lo, double la) { 
		this.setNaam(name); 
		this.setLatitude(lo); 
		this.setLongitude(la); 
	} 

	public double getLongitude() { 
		return longitude; 
	} 

	public void setLongitude(double longitude) { 
		this.longitude = longitude; 
	} 

	public double getLatitude() { 
		return latitude; 

	} 
	public void setLatitude(double latitude) { 
		this.latitude = latitude; 
	} 

	public String getNaam() { 
		return naam; 
	} 

	public void setNaam(String naam) { 
		this.naam = naam; 
	} 

	public String toString() { 
		return "Naam: " + naam + ", Latitude: " + latitude + ", Longitude: " + longitude;
	}
	
}