package fr.a.factures.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.a.factures.core.repository.IDashboardRepository;
import fr.a.factures.dto.Chart;
import fr.a.factures.service.IDashboardService;

@Service
public class DashboardService implements IDashboardService {

	/**
	 * An instance of IDashboardRepository to access the methods for data retrieval.
	 */
	@Autowired
	private IDashboardRepository dashboardRepo;

	/**
	 * This method returns the number of delayed invoices.
	 *
	 * @return Long
	 */
	@Override
	public Long invoiceDelay() {
		// TODO Auto-generated method stub
		return dashboardRepo.invoiceDelay();
	}

	/**
	 * This method returns the number of invoices that have been issued.
	 *
	 * @return Long
	 */
	@Override
	public Long invoiceIssue() {
		return dashboardRepo.invoiceIssue();
	}

	/**
	 * This method returns the turnover for a particular year.
	 *
	 * @param year the year for which turnover is required.
	 * @return Long
	 */
	@Override
	public Long yearTurnover(final int year) {
		return dashboardRepo.yearTurnover(year);
	}

	/**
	 * A constructor that sets the dashboardRepo instance with the passed repository
	 * instance.
	 *
	 * @param dashboardRepository An instance of IDashboardRepository.
	 */
	@Autowired
	public DashboardService(final IDashboardRepository dashboardRepository) {
		this.dashboardRepo = dashboardRepository;
	}

	/**
	 * This method returns a list of Charts containing the monthly turnover for a
	 * particular year.
	 *
	 * @param year the year for which monthly turnover is required.
	 * @return List of Chart
	 */
	@Override
	public List<Chart> getMonth(final int year) {
		return dashboardRepo.monthTurnover(year);
	}

	/**
	 * This method returns a list of Charts containing the forecast data for a
	 * particular year.
	 *
	 * @param year the year for which forecast data is required.
	 * @return List of Chart
	 */
	@Override
	public List<Chart> getforecast(final int year) {
		return dashboardRepo.forecast(year);
	}

}
