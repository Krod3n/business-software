package fr.a.factures.dto;

public class ChartDTO {

	/**
	 * This field represents the month.
	 */
	private String month;

	/**
	 * This field represents the forecast value.
	 */
	private Double forecast;

	/**
	 * This field represents the monthly turnover.
	 */
	private Double monthTurnover;

	/**
	 * This field represents the past monthly turnover.
	 */
	private Double pastMonthTurnover;

	/**
	 * This method returns the month value.
	 *
	 * @return String
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * This method sets the month.
	 *
	 * @param chartMonth String
	 */
	public void setMonth(final String chartMonth) {
		this.month = chartMonth;
	}

	/**
	 * This method returns the forecast value.
	 *
	 * @return Double
	 */
	public Double getForecast() {
		return forecast;
	}

	/**
	 * This method sets the forecast value.
	 *
	 * @param chartForecast Double
	 */
	public void setForecast(final Double chartForecast) {
		this.forecast = chartForecast;
	}

	/**
	 * This method returns the monthly turnover.
	 *
	 * @return Double
	 */
	public Double getMonthTurnover() {
		return monthTurnover;
	}

	/**
	 * This method sets the monthly turnover.
	 *
	 * @param chartMonthTurnover Double
	 */
	public void setMonthTurnover(final Double chartMonthTurnover) {
		this.monthTurnover = chartMonthTurnover;
	}

	/**
	 * This method returns the past monthly turnover.
	 *
	 * @return Double
	 */
	public Double getPastMonthTurnover() {
		return pastMonthTurnover;
	}

	/**
	 * This method sets the past monthly turnover.
	 *
	 * @param chartPastMonthTurnover Double
	 */
	public void setPastMonthTurnover(final Double chartPastMonthTurnover) {
		this.pastMonthTurnover = chartPastMonthTurnover;
	}

}
