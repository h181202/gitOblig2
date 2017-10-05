package no.hvl.dat104;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

public class PaameldingHjelp {
	@EJB
	UserEOA eao; 
	
	private String fornavn; 
	private String etternavn; 
	private String mobilnr; 
	private String kjonn; 
	
	private String fornavnFeil; 
	private String etternavnFeil; 
	private String mobilFeil; 
	
	
	
	public PaameldingHjelp(HttpServletRequest request) {
		fornavn  = request.getParameter("fornavn");
		etternavn = request.getParameter("etternavn");
		mobilnr = request.getParameter("mobil");
		kjonn = request.getParameter("kjonn");
	}
	
	
	public String getKjonn() {
		return kjonn;
	}


	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}


	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public void setFornavnFeil(String fornavnFeil) {
		this.fornavnFeil = fornavnFeil;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public void setEtternavnFeil(String etternavnFeil) {
		this.etternavnFeil = etternavnFeil;
	}

	public String getMobilFeil() {
		return mobilFeil;
	}

	public void setMobilFeil(String mobilFeil) {
		this.mobilFeil = mobilFeil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobilnr() {
		return mobilnr;
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}
	
	public boolean gyldigFornavn() {
		return fornavn != null && fornavn.length() >= 2 && fornavn.length() <= 20 
				&& Character.isUpperCase(fornavn.charAt(0));	
	}
	
	public boolean gyldigEtternavn() {
		return etternavn != null && etternavn.length() >= 2 && etternavn.length() <= 20 
				&& Character.isUpperCase(etternavn.charAt(0));	
	}
	
	public boolean gyldigMobil() {
		return mobilnr != null && fornavn.length() == 8 
				&& (eao.finnUser(Integer.parseInt(mobilnr)) == null);
	}
	
	public boolean alleGyldige() {
		return gyldigFornavn() && gyldigEtternavn() && gyldigMobil(); 
	}
	
	public void feilMelding() {
		if(fornavn == null) {
			fornavnFeil = "Kan ikke være tomt";			
		} if (!Character.isUpperCase(fornavn.charAt(0))) {
			fornavnFeil = "Første tegn skal være stor bokstav";	
		} if(fornavn.length() < 2 || fornavn.length() > 20) {
			fornavn = ""; 
			fornavnFeil = "Må være 2-20 tegn";
		} if(etternavn == null) {
			etternavnFeil = "Kan ikke være tomt";			
		} if (!Character.isUpperCase(etternavn.charAt(0))) {
			etternavnFeil = "Første tegn skal være stor bokstav";	
		} if(etternavn.length() < 2 || fornavn.length() > 20) {
			etternavn = ""; 
			etternavnFeil = "Må være 2-20 tegn";
		} if(mobilnr == null) {
			mobilFeil = "Kan ikke være tomt";
		} if(mobilnr.length() != 8) {
			mobilnr = "";
			mobilFeil = "Må være 8 siffer";
		}
		
		
	}
}
