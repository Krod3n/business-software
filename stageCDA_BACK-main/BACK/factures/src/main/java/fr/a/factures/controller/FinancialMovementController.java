/**
 * FinancialMovement controller
 */
package fr.a.factures.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.a.factures.dto.FinancialMovementDTO;
import fr.a.factures.dto.mapper.FinancialMovementMapper;
import fr.a.factures.helpers.MagicNumber;
import fr.a.factures.helpers.MagicString;
import fr.a.factures.service.IFinancialMovementService;

/**
 * @author Stagiaire
 *
 */
@RestController
@RequestMapping("/finance")
@CrossOrigin(origins = MagicString.LOCAL, maxAge = MagicNumber.ORIGIN)
public class FinancialMovementController {

	/**
	 * call interface FinancialMovement Service.
	 */
	@Autowired
	private IFinancialMovementService financeService;

	/**
	 * Get List of all FinancialMovement.
	 * @return List of FinancialMovement dto
	 */
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public List<FinancialMovementDTO> getAllMovements() {
		return FinancialMovementMapper.toListOfDto(financeService.getAllMovements());
	}

	/**
	 * Find a FinancialMovement with is id.
	 * @param id id of a FinancialMovement
	 * @param response
	 * @return dto FinancialMovementDTO
	 */
	@GetMapping("/movement/{id}")
//	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public FinancialMovementDTO getMovement(@PathVariable("id") final long id, final HttpServletResponse response) {
		FinancialMovementDTO dto = FinancialMovementMapper.toDto(financeService.getMovement(id));

		if (dto == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		return dto;
	}

	/**
	 * Add new FinancialMovement.
	 * @param financial FinancialMovementDTO
	 * @return FinancialMovement entity
	 */
	@PostMapping("/add")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public FinancialMovementDTO addMovement(@RequestBody final FinancialMovementDTO financial) {
		return FinancialMovementMapper.toDto(financeService
				.saveFinancial(FinancialMovementMapper.toEntity(financial)));
	}

	/**
	 * Delete FinancialMovement.
	 * @param id
	 */
	@DeleteMapping("/{id}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteMovement(@PathVariable final long id) {
		financeService.deleteMovement(id);
	}

	/**
	 * Update FinancialMovement.
	 * @param id id of FinancialMovement
	 * @param financial FinancialMovementDTO
	 */
	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void setMovement(@PathVariable final long id, @RequestBody final FinancialMovementDTO financial) {
		if (financial.getId() == id) {
			financeService.saveFinancial(FinancialMovementMapper.toEntity(financial));
		}
	}

}
