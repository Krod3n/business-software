package fr.a.factures.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.a.factures.dto.Chart;
import fr.a.factures.dto.ChartDTO;

public class ChartMapper {

	/**
	 * A final static constant list of month names.
	 */
	final static private List<String> MONTH = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec");

	/**
	 * This method converts the list of Chart objects into a list of ChartDTO
	 * objects.
	 *
	 * @param actuCh     The list of Chart objects representing the actual turnover
	 *                   data.
	 * @param prevCh     The list of Chart objects representing the past turnover
	 *                   data.
	 * @param forecastCh The list of Chart objects representing the forecast
	 *                   turnover data.
	 * @return The list of ChartDTO objects representing the actual, past, and
	 *         forecast turnover data.
	 */
	public static List<ChartDTO> toDTOs(final List<Chart> actuCh, final List<Chart> prevCh,
			final List<Chart> forecastCh) {
		List<ChartDTO> dtos = null;

		dtos = new ArrayList<>();
		for (String sm : MONTH) {
			ChartDTO dto = new ChartDTO();
			dto.setMonth(sm);
			if (actuCh != null) {
				for (Chart ch : actuCh) {
					if (ch.getMonth().equals(sm)) {
						dto.setMonthTurnover(ch.getTotal());
					}
				}
			}
			if (forecastCh != null) {
				for (Chart fch : forecastCh) {
					if (fch.getMonth().equals(sm)) {
						dto.setForecast(fch.getTotal());
					}
				}
			}
			if (prevCh != null) {
				for (Chart pch : prevCh) {
					if (pch.getMonth().equals(sm)) {
						dto.setPastMonthTurnover(pch.getTotal());
					}
				}
			}
			if (dto.getForecast() == null) {
				dto.setForecast(0D);
			}
			if (dto.getPastMonthTurnover() == null) {
				dto.setPastMonthTurnover(0D);
			}
			if (dto.getMonthTurnover() == null) {
				dto.setMonthTurnover(0D);
			}
			dtos.add(dto);

		}
		return dtos;
	}

}
