/**
 * class for invoice entity.
 */
package fr.a.factures.core.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "invoice")
public class Invoice {

	/**
	 * id of invoice.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inv_id")
	private Long id;

	/**
	 * order of invoice.
	 */
	@Column(name = "inv_order")
	private String order;

	/**
	 * date of invoice.
	 */
	@Column(name = "inv_date")
	private Date date;

	/**
	 * deadline for payment of invoice.
	 */
	@Column(name = "inv_deadline")
	private Date deadline;

	/**
	 * date of payment for invoice.
	 */
	@Column(name = "inv_payment")
	private Date payment;


	/**
	 * boolean for taxe in invoice.
	 */
	@Column(name = "inv_taxe")
	private Boolean taxe;

	/**
	 * total price of invoice.
	 */
	@Column(name = "inv_totalprice")
	private Double totalPrice;

	/**
	 * reference of invoice.
	 */
	@Column(name = "inv_reference")
	private String reference;

	/**
	 * the customer for invoice.
	 */
	@ManyToOne
	@JoinColumn(name="cus_id", referencedColumnName = "cus_id", nullable = false)
	private Customer customer;

	/**
	 * List of product in the invoice.
	 */
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.REMOVE)
	private List<InvoiceProduct> invoiceProducts;

	/**
	 * default constructor of Invoice.
	 */
	public Invoice() {
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
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param pOrder the order to set
	 */
	public void setOrder(final String pOrder) {
		this.order = pOrder;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param pDate the date to set
	 */
	public void setDate(final Date pDate) {
		this.date = pDate;
	}

	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param pDeadline the deadline to set
	 */
	public void setDeadline(final Date pDeadline) {
		this.deadline = pDeadline;
	}

	/**
	 * @return the payment
	 */
	public Date getPayment() {
		return payment;
	}

	/**
	 * @param pPayment the payment to set
	 */
	public void setPayment(final Date pPayment) {
		this.payment = pPayment;
	}

	/**
	 * @return the taxe
	 */
	public Boolean getTaxe() {
		return taxe;
	}

	/**
	 * @param pTaxe the taxe to set
	 */
	public void setTaxe(final Boolean pTaxe) {
		this.taxe = pTaxe;
	}

	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param pTotalPrice the totalPrice to set
	 */
	public void setTotalPrice(final Double pTotalPrice) {
		this.totalPrice = pTotalPrice;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param pReference the reference to set
	 */
	public void setReference(final String pReference) {
		this.reference = pReference;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param pCustomer the customer to set
	 */
	public void setCustomer(final Customer pCustomer) {
		this.customer = pCustomer;
	}

	/**
	 * @return the invoiceProducts
	 */
	public List<InvoiceProduct> getInvoiceProducts() {
		return invoiceProducts;
	}

	/**
	 * @param pInvoiceProducts the invoiceProducts to set
	 */
	public void setInvoiceProducts(final List<InvoiceProduct> pInvoiceProducts) {
		this.invoiceProducts = pInvoiceProducts;
	}

}
