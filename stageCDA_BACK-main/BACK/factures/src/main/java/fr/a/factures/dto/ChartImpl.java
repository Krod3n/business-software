package fr.a.factures.dto;

/**
 * Implementation class for the {@link Chart} interface.
 **/
public class ChartImpl implements Chart {
	/**
	 * This field represents the month.
	 */
	private String month;
	/**
	 * This field represents the total of the month.
	 */
	private Double total;

	/**
	 * Creates a new instance of the ChartImpl class.
	 *
	 * @param chartImplMonth the name of the month
	 * @param chartImplTotal the total value for the month
	 */
	public ChartImpl(final String chartImplMonth, final Double chartImplTotal) {
		this.month = chartImplMonth;
		this.total = chartImplTotal;
	}

	/**
	 * Gets the name of the month.
	 *
	 * @return the name of the month
	 */
	@Override
	public String getMonth() {
		return this.month;
	}

	/**
	 * Gets the total value for the month.
	 *
	 * @return the total value for the month
	 */
	@Override
	public Double getTotal() {
		return this.total;
	}
}
