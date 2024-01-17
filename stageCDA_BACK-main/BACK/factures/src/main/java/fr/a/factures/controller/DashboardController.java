package fr.a.factures.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.a.factures.dto.ChartDTO;
import fr.a.factures.dto.mapper.ChartMapper;
import fr.a.factures.helpers.MagicNumber;
import fr.a.factures.service.IDashboardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:3000", maxAge = MagicNumber.ORIGIN)
public class DashboardController {

	/**
	 * An instance of IDashboardService, automatically injected by the framework.
	 */
	@Autowired
	private IDashboardService dashboardService;

	/**
	 * Returns the delay of invoices.
	 *
	 * @return delay of invoices in milliseconds.
	 */
	@GetMapping("/invoiceDelay")
	public Long getInvoiceDelay() {
		return dashboardService.invoiceDelay();
	}

	/**
	 * Returns the number of invoices to be issued.
	 *
	 * @return number of invoices to be issued.
	 */
	@GetMapping("/invoiceToIssue")
	public Long getInvoiceIssue() {
		return dashboardService.invoiceIssue();
	}

	/**
	 * Returns the turnover for a given year.
	 *
	 * @param year The year for which the turnover is required.
	 * @return the turnover for the given year.
	 */
	@GetMapping("/yearTurnover/{year}")
	public Long getYearTurnover(final @PathVariable("year") int year) {
		return dashboardService.yearTurnover(year);
	}

	/**
	 * Returns the chart data for a given year.
	 *
	 * @param year The year for which the chart data is required.
	 * @return list of ChartDTO objects representing the chart data.
	 */
	@GetMapping("/chartList/{year}")
	public List<ChartDTO> getChartList(final @PathVariable("year") int year) {
		return ChartMapper.toDTOs(dashboardService.getMonth(year), dashboardService.getMonth(year - 1),
				dashboardService.getforecast(year));
	}

}
