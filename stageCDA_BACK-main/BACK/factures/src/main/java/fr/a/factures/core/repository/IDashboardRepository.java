package fr.a.factures.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.a.factures.core.domain.Invoice;
import fr.a.factures.dto.Chart;

@Repository
public interface IDashboardRepository extends JpaRepository<Invoice, Long> {

	/**
	 * Returns the number of invoices with a payment date that is null and a
	 * deadline that is not null.
	 *
	 * @return the number of delayed invoices.
	 */
	@Query(value = "select count(i.inv_order) from invoice i \r\n"
			+ "where i.inv_payment is null and i.inv_deadline is not null", nativeQuery = true)
	Long invoiceDelay();

	/**
	 * Returns the number of invoices with a date that is null and a deadline
	 * between today and 30 days from today.
	 *
	 * @return the number of invoices to be issued.
	 */
	@Query(value = "select count(1)  from invoice i \r\n" + "where i.inv_date is null and i.inv_deadline "
			+ "between curdate() and date_add(curdate(),interval 30 day)", nativeQuery = true)
	Long invoiceIssue();

	/**
	 * Returns a list of the monthly turnover for a given year.
	 *
	 * @param year - the year for which to retrieve the monthly turnover.
	 *
	 * @return a list of Chart objects with the month and total turnover for each
	 *         month.
	 */
	@Query(value = "SELECT distinct(SUBSTR(monthname(i.inv_payment),1,3)) as month, "
			+ "sum(i.inv_totalprice) as total \r\n" + "FROM invoice i \r\n" + "WHERE YEAR(i.inv_payment) = :year "
			+ "group by 1 order by i.inv_payment ", nativeQuery = true)
	List<Chart> monthTurnover(@Param("year") int year);

	/**
	 * Returns the total yearly turnover for a given year.
	 *
	 * @param year - the year for which to retrieve the turnover.
	 *
	 * @return the total yearly turnover.
	 */
	@Query(value = "SELECT SUM(i.inv_totalprice)\r\n" + "FROM invoice i \r\n"
			+ "WHERE year(i.inv_payment) = :year", nativeQuery = true)
	Long yearTurnover(@Param("year") int year);

	/**
	 * Returns a list of the monthly forecasted turnover for a given year.
	 *
	 * @param year - the year for which to retrieve the monthly forecasted turnover.
	 *
	 * @return a list of Chart objects with the month and forecasted total turnover
	 *         for each month.
	 */
	@Query(value = "SELECT SUBSTR(monthname(i.inv_deadline),1,3) AS month, " + "SUM(i.inv_totalprice) AS total "
			+ "FROM invoice i " + "WHERE YEAR(inv_deadline) = :year AND inv_deadline IS NOT NULL "
			+ "GROUP BY month(i.inv_deadline) ORDER BY month(i.inv_deadline);", nativeQuery = true)
	List<Chart> forecast(@Param("year") int year);

}
