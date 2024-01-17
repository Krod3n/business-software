/**
 * Interface for FinancialMovement Repository
 */
package fr.a.factures.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.a.factures.core.domain.FinancialMovement;

/**
 * @author Stagiaire
 *
 */
@Repository
public interface IFinancialMovementRepository extends JpaRepository<FinancialMovement, Long> {

}
