package fr.a.factures.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.a.factures.dto.MonthTurnover;
import fr.a.factures.dto.MonthTurnoverDTO;

public class MonthTurnoverMapper {

	public static MonthTurnoverDTO toDTO(final MonthTurnover mt) {
		MonthTurnoverDTO dto = null;

		if (mt != null) {
			dto = new MonthTurnoverDTO();
			dto.setMonth(mt.getMonth());
			dto.setTotal(mt.getTotal());
		}
		return dto;
	}

	public static List<MonthTurnoverDTO> listtoDto(final List<MonthTurnover> month) {
		List<MonthTurnoverDTO> dtos = null;

		if (month != null) {
			dtos = new ArrayList<>();

			for (MonthTurnover mt : month) {
				dtos.add(toDTO(mt));
			}
		}

		return dtos;
	}
}
