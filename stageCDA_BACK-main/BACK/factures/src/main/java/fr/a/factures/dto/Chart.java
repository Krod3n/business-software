package fr.a.factures.dto;

public interface Chart {

	/**
	 * This method returns the month of a query.
	 *
	 * @return the month as a string.
	 */
	String getMonth();

	/**
	 * This method returns the total of a query.
	 *
	 * @return the total as a double.
	 */
	Double getTotal();

}
