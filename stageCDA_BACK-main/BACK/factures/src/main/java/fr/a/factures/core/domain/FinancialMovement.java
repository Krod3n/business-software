/**
 * class for Financial movement entity
 */
package fr.a.factures.core.domain;

import java.util.Date;

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
@Table(name = "financial_movement")
public class FinancialMovement {

	/**
	 * id of financial movement.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fmt_id")
	private Long id;

	/**
	 * description of financial movement.
	 */
	@Column(name = "fmt_description")
	private String description;

	/**
	 * date of financial movement.
	 */
	@Column(name = "fmt_date")
//	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;

	/**
	 * third party of financial movement.
	 */
	@Column(name = "fmt_thirdparty")
	private String thirdParty;

	/**
	 * amount of financial movement.
	 */
	@Column(name = "fmt_amount")
	private Double amount;

	/**
	 * default constructor for financial movement entity.
	 */
	public FinancialMovement() {
		super();
	}

	/**
	 * @param pId of {@link FinancialMovement}
	 * @param pDescription of {@link FinancialMovement}
	 * @param pDate of {@link FinancialMovement}
	 * @param pThirdParty of {@link FinancialMovement}
	 * @param pAmount of {@link FinancialMovement}
	 */
	public FinancialMovement(final Long pId, final String pDescription,
			final Date pDate, final String pThirdParty, final Double pAmount){
		super();
		this.id = pId;
		this.description = pDescription;
		this.date = pDate;
		this.thirdParty = pThirdParty;
		this.amount = pAmount;
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
	 * @return the thirdParty
	 */
	public String getThirdParty() {
		return thirdParty;
	}

	/**
	 * @param pThirdParty the thirdParty to set
	 */
	public void setThirdParty(final String pThirdParty) {
		this.thirdParty = pThirdParty;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param pAmount the amount to set
	 */
	public void setAmount(final Double pAmount) {
		this.amount = pAmount;
	}

}
