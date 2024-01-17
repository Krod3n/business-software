/**
 * class for invoice product entity
 */
package fr.a.factures.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "invoice_product")
public class InvoiceProduct {

	/**
	 * id of InvoiceProduct.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ipt_id")
	private Long id;

	/**
	 * quantity of InvoiceProduct.
	 */
	@Column(name = "ipt_quantity")
	private Double quantity;

	/**
	 * discount of InvoiceProduct.
	 */
	@Column(name = "ipt_discount")
	private Double discount;

	/**
	 * label of product.
	 */
	@Column(name = "ipt_label")
	private String label;

	/**
	 * invoice of InvoiceProdcut.
	 */
	@ManyToOne
	@JoinColumn(name="inv_id", referencedColumnName = "inv_id", nullable = false)
	private Invoice invoice;

	/**
	 * product of InvoiceProdcut.
	 */
	@ManyToOne
	@JoinColumn(name="pro_id", referencedColumnName = "pro_id", nullable = false)
	private Product product;

	/**
	 * default constructor of InvoiceProduct.
	 */
	public InvoiceProduct() {
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
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * @param pQuantity the quantity to set
	 */
	public void setQuantity(final Double pQuantity) {
		this.quantity = pQuantity;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param pDiscount the discount to set
	 */
	public void setDiscount(final Double pDiscount) {
		this.discount = pDiscount;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param pLabel the label to set
	 */
	public void setLabel(final String pLabel) {
		this.label = pLabel;
	}

	/**
	 * @return the invoice
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * @param pInvoice the invoice to set
	 */
	public void setInvoice(final Invoice pInvoice) {
		this.invoice = pInvoice;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param pProduct the product to set
	 */
	public void setProduct(final Product pProduct) {
		this.product = pProduct;
	}

}
