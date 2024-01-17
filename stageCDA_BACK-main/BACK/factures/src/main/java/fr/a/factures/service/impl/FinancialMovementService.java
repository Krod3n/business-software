/**
 * Service for FinancialMovement
 */
package fr.a.factures.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.a.factures.core.domain.FinancialMovement;
import fr.a.factures.core.repository.IFinancialMovementRepository;
import fr.a.factures.service.IFinancialMovementService;

/**
 * @author Stagiaire
 *
 */
@Service("FinancialMovementService")
public class FinancialMovementService implements IFinancialMovementService {

	/**
	 * call to Interface FinancialMovement Repository.
	 */
	@Autowired
	private IFinancialMovementRepository financeRepo;

	/**
	 * get List of FinancialMovement.
	 */
	@Override
	public List<FinancialMovement> getAllMovements() {
		return financeRepo.findAll();
	}

	/**
	 * Add a new FinancialMovement.
	 */
	@Override
	public FinancialMovement saveFinancial(final FinancialMovement entity) {
		return financeRepo.saveAndFlush(entity);
	}

	/**
	 * Delete one FinancialMovement.
	 */
	@Override
	public void deleteMovement(final long id) {
		financeRepo.deleteById(id);
	}

	/**
	 * find a FinancialMovement with is id.
	 */
	@Override
	public FinancialMovement getMovement(final long id) {
		return financeRepo.getReferenceById(id);
	}

}
