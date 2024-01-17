/**
 * class for Enterprise entity
 */
package fr.a.factures.core.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "enterprise")
public class Enterprise {

	/**
	 * id of enterprise.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ent_duns")
	private String duns;

	/**
	 * lastname of enterprise.
	 */
	@Column(name = "ent_lastname")
	private String lastname;

	/**
	 * firstname of enterprise.
	 */
	@Column(name = "ent_firstname")
	private String firstname;

	/**
	 * zip of enterprise.
	 */
	@Column(name = "ent_zip")
	private String zip;

	/**
	 * city of enterprise.
	 */
	@Column(name = "ent_city")
	private String city;

	/**
	 * address of enterprise.
	 */
	@Column(name = "ent_address")
	private String address;

	/**
	 * tradename of enterprise.
	 */
	@Column(name = "ent_tradename")
	private String tradename;

	/**
	 * phonenumber of enterprise.
	 */
	@Column(name = "ent_phonenumber")
	private String phonenumber;

	/**
	 * logo of enterprise.
	 */
	@Column(name = "ent_logo")
	private Blob logo;

	/**
	 * default constructor for enterprise entity.
	 */
	public Enterprise() {
		super();
	}

	/**
	 * @return the duns
	 */
	public String getDuns() {
		return duns;
	}

	/**
	 * @param pDuns the duns to set
	 */
	public void setDuns(final String pDuns) {
		this.duns = pDuns;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param pZip the zip to set
	 */
	public void setZip(final String pZip) {
		this.zip = pZip;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param pCity the city to set
	 */
	public void setCity(final String pCity) {
		this.city = pCity;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param pAddress the address to set
	 */
	public void setAddress(final String pAddress) {
		this.address = pAddress;
	}

	/**
	 * @return the tradename
	 */
	public String getTradename() {
		return tradename;
	}

	/**
	 * @param pTradename the tradename to set
	 */
	public void setTradename(final String pTradename) {
		this.tradename = pTradename;
	}

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @param pPhonenumber the phonenumber to set
	 */
	public void setPhonenumber(final String pPhonenumber) {
		this.phonenumber = pPhonenumber;
	}

	/**
	 * @return the logo
	 */
	public Blob getLogo() {
		return logo;
	}

	/**
	 * @param pLogo the logo to set
	 */
	public void setLogo(final Blob pLogo) {
		this.logo = pLogo;
	}

}
