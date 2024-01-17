/**
 * Mapper for FinancialMovement
 */
package fr.a.factures.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.a.factures.core.domain.FinancialMovement;
import fr.a.factures.dto.FinancialMovementDTO;

/**
 * @author Stagiaire
 *
 */
public class FinancialMovementMapper {

	/**
	 * Transform FinancialMovement entity to dto.
	 * @param finance is FinancialMovement entity
	 * @return dto is FinancialMovementDTO
	 */
	public static FinancialMovementDTO toDto (final FinancialMovement finance) {
		FinancialMovementDTO dto = null;

		if (finance != null) {
			dto = new FinancialMovementDTO();
			dto.setId(finance.getId());
			dto.setDate(finance.getDate());
			dto.setThirdParty(finance.getThirdParty());
			dto.setDescription(finance.getDescription());
			dto.setAmount(finance.getAmount());

		}

		return dto;
	}

	/**
	 * Transform FinancialMovement dto to entity.
	 * @param dto is FinancialMovementDTO
	 * @return entity is FinancialMovement entity
	 */
	public static FinancialMovement toEntity (final FinancialMovementDTO dto) {
		FinancialMovement entity = null;

		if (dto != null) {
			entity = new FinancialMovement();
			entity.setId(dto.getId());
			entity.setDate(dto.getDate());
			entity.setThirdParty(dto.getThirdParty());
			entity.setDescription(dto.getDescription());
			entity.setAmount(dto.getAmount());

		}

		return entity;
	}

	/**
	 * Transform List of FinancialMovement entity to List of FinancialMovement dto.
	 * @param entitys List of FinancialMovement entity
	 * @return dtos List of FinancialMovementDTO
	 */
	public static List<FinancialMovementDTO> toListOfDto(final List<FinancialMovement> entitys) {
		List<FinancialMovementDTO> dtos = null;

		if (entitys != null) {
			dtos = new ArrayList<>();

			for (FinancialMovement fm : entitys) {
				dtos.add(toDto(fm));
			}
		}

		return dtos;
	}

}
