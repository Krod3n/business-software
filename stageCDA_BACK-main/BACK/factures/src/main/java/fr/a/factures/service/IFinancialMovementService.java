/**
 * Interface service for FinancialMovement
 */
package fr.a.factures.service;

import java.util.List;

import fr.a.factures.core.domain.FinancialMovement;

/**
 * @author Stagiaire
 *
 */

public interface IFinancialMovementService {

	/**
	 * get List of FinancialMovement.
	 * @return List of FinancialMovement
	 */
	List<FinancialMovement> getAllMovements();

	/**
	 * Add new FinancialMovement entity.
	 * @param entity FinancialMovement
	 * @return new FinancialMovement
	 */
	FinancialMovement saveFinancial(FinancialMovement entity);

	/**
	 * Delete one FinancialMovement by id.
	 * @param id
	 */
	void deleteMovement(long id);

	/**
	 * Find FinancialMovement with is id.
	 * @param id id of a Financial movement
	 * @return FinancialMovement
	 */
	FinancialMovement getMovement(long id);

}
