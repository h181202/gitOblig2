package no.hvl.dat104;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

/**
 * @author David Korsrud Bråten
 *
 */
@Entity
public class User {

	@Id
	private int mobil;
	private String fnavn;
	private String enavn;
	private boolean sex;
	private boolean betalt;
	
		
	
	public int getMobil() {
		return mobil;
	}
	public void setMobil(int mobil) {
		this.mobil = mobil;
	}
	public String getFnavn() {
		return fnavn;
	}
	public void setFnavn(String fnavn) {
		this.fnavn = fnavn;
	}
	public String getEnavn() {
		return enavn;
	}
	public void setEnavn(String enavn) {
		this.enavn = enavn;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public boolean isBetalt() {
		return betalt;
	}
	public void setBetalt(boolean betalt) {
		this.betalt = betalt;
	}
	

}
