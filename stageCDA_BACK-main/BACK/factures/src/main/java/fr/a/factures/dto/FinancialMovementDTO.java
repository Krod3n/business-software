/**
 * Class for FinancialMovement dto
 */
package fr.a.factures.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Stagiaire
 *
 */
public class FinancialMovementDTO {

	/**
	 * id of FinancialMovement dto.
	 */
	private Long id;

	/**
	 * description of FinancialMovement dto.
	 */
	private String description;

	/**
	 * date of FinancialMovement dto.
	 */
	@JsonFormat(pattern="yyyy-MM-dd", timezone= "Europe/Paris")
	private Date date;

	/**
	 * third party of FinancialMovement dto.
	 */
	private String thirdParty;

	/**
	 * amount of FinancialMovement dto.
	 */
	private Double amount;

	/**
	 * default constructor for FiancialMovementDTO.
	 */
	public FinancialMovementDTO() {
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
