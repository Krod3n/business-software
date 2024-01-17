package fr.a.factures.service;

import java.util.List;

import fr.a.factures.dto.Chart;

public interface IDashboardService {

	/**
	 * This method returns the delay in invoicing.
	 *
	 * @return Long
	 */
	Long invoiceDelay();

	/**
	 * This method returns the issue with invoicing.
	 *
	 * @return Long
	 */
	Long invoiceIssue();

	/**
	 * This method returns the turnover for a given year.
	 *
	 * @param year int
	 * @return Long
	 */
	Long yearTurnover(int year);

	/**
	 * This method returns the monthly list for a given year.
	 *
	 * @param year int
	 * @return List<Chart>
	 */
	List<Chart> getMonth(int year);

	/**
	 * This method returns the forecast list for a given year.
	 *
	 * @param year int
	 * @return List<Chart>
	 */
	List<Chart> getforecast(int year);

}
