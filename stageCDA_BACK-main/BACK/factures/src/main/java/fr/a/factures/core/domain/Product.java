/**
 * class for product entity
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "product")
public class Product {

	/**
	 * id of product.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private Long id;

	/**
	 * description of product.
	 */
	@Column(name = "pro_description")
	private String description;

	/**
	 * price of product.
	 */
	@Column(name = "pro_price")
	private Double price;

	/**
	 * start date of product.
	 */
	@Column(name = "pro_from")
	private Date from;

	/**
	 * end date of product.
	 */
	@Column(name = "pro_to")
	private Date to;

	/**
	 * list of invoiceProduct for product.
	 */
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	private List<InvoiceProduct> invoiceProducts;

	/**
	 * default constructor of product.
	 */
	public Product() {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param pDescription the description to set
	 */
	public void setDescription(final String pDescription) {
		this.description = pDescription;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param pPrice the price to set
	 */
	public void setPrice(final Double pPrice) {
		this.price = pPrice;
	}

	/**
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param pFrom the from to set
	 */
	public void setFrom(final Date pFrom) {
		this.from = pFrom;
	}

	/**
	 * @return the to
	 */
	public Date getTo() {
		return to;
	}

	/**
	 * @param pTo the to to set
	 */
	public void setTo(final Date pTo) {
		this.to = pTo;
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
