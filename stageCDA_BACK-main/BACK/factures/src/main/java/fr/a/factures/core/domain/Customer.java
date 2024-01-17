/**
 * class for Customer entity
 */
package fr.a.factures.core.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "customer")
public class Customer {

	/**
	 * id of costumer.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cus_id")
	private Long id;

	/**
	 * address of customer.
	 */
	@Column(name = "cus_address")
	private String address;

	/**
	 * zip of costumer.
	 */
	@Column(name = "cus_zip")
	private String zip;

	/**
	 * tradename of customer.
	 */
	@Column(name = "cus_tradename")
	private String tradename;

	/**
	 * website of customer.
	 */
	@Column(name = "cus_website")
	private String website;

	/**
	 * email of customer.
	 */
	@Column(name = "cus_email")
	private String email;

	/**
	 * phone of customer.
	 */
	@Column(name = "cus_phone")
	private String phone;

	/**
	 * mobile of customer.
	 */
	@Column(name = "cus_mobile")
	private String mobile;

	/**
	 * city of customer.
	 */
	@Column(name = "cus_city")
	private String city;

	/**
	 * list of invoice for the customer.
	 */
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private List<Invoice> invoices;

	/**
	 * default constructor of Customer.
	 */
	public Customer() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param pWebsite the website to set
	 */
	public void setWebsite(final String pWebsite) {
		this.website = pWebsite;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param pEmail the email to set
	 */
	public void setEmail(final String pEmail) {
		this.email = pEmail;

	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param pPhone the phone to set
	 */
	public void setPhone(final String pPhone) {
		this.phone = pPhone;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param pMobile the mobile to set
	 */
	public void setMobile(final String pMobile) {
		this.mobile = pMobile;
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
	 * @return the invoices
	 */
	public List<Invoice> getInvoices() {
		return invoices;
	}

	/**
	 * @param pInvoices the invoices to set
	 */
	public void setInvoices(final List<Invoice> pInvoices) {
		this.invoices = pInvoices;
	}

}
