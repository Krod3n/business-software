package fr.a.facture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.a.facture.service.IDashboardService;
import fr.a.factures.helpers.MagicNumber;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:3000", maxAge = MagicNumber.ORIGIN)
public class DashboardController {

	@Autowired
	private IDashboardService dashboardService;
	
	@GetMapping("/invoiceDelay")
	public Long GetInvoiceDelay() {
		return dashboardService.InvoiceDelay();
	}
	
	@GetMapping("/invoiceToIssue")
	public Long GetInvoiceIssue() {
		return dashboardService.InvoiceIssue();
	}
	
	@GetMapping("/monthTurnover")
	public List <Object[]> MonthTurnover() {
		return dashboardService.MonthTurnover();
	}
	
	@GetMapping("/pastMonthTurnover")
	public List <Object[]> PastMonthTurnover()  {
		return dashboardService.PastMonthTurnover();
	}
	
	@GetMapping("/yearTurnover")
	public Long GetYearTurnover() {
		return dashboardService.YearTurnover();
	}
	
	@GetMapping("/pastYearTurnover")
	public Long GetPastYearTurnover() {
		return dashboardService.PastYearTurnover();
	}
	
	@GetMapping ("/yearTurnoverCumulated")
	public List <Object[]> YearTurnoverCumulated() {
		return dashboardService.YearTurnoverCumulated();
	}
	
	@GetMapping("/pastYearTurnoverCumulated")
	public List <Object[]> PastYearTurnoverCumulated() {
		return dashboardService.PastYearTurnoverCumulated();
	}
}
