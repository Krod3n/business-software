/**
 * test for {@link FinancialMovementMapper}
 */
package fr.a.factures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.a.factures.core.domain.FinancialMovement;
import fr.a.factures.dto.FinancialMovementDTO;
import fr.a.factures.dto.mapper.FinancialMovementMapper;

/**
 * @author Stagiaire
 *
 */
@SpringBootTest
public class FinancialMovementTest {

	/**
	 * Test for {@link FinancialMovement} Constructor.
	 */
	@Test
	void financialMovementConstructor(){
		// given

		// when
		Object m = new FinancialMovementMapper();

		// then
		assertEquals(m.getClass(), FinancialMovementMapper.class);
	}

	/**
	 * Test for {@link FinancialMovement} entity to {@link FinancialMovementDTO}.
	 */
	@Test
	public void movementToDto() {
		// given
		FinancialMovement move = new FinancialMovement();

		move.setAmount(2D);
		move.setId(1L);
		move.setDate(new Date());
		move.setDescription("descrition");
		move.setThirdParty("third party");

		// when
		FinancialMovementDTO dto = FinancialMovementMapper.toDto(move);

		// then
		assertThat(dto.getId()).isEqualTo(move.getId());
		assertThat(dto.getAmount()).isEqualTo(move.getAmount());
		assertThat(dto.getDate()).isEqualTo(move.getDate());
		assertThat(dto.getDescription()).isEqualTo(move.getDescription());
		assertThat(dto.getThirdParty()).isEqualTo(move.getThirdParty());
	}

	/**
	 * Test for {@link FinancialMovement} entity to {@link FinancialMovementDTO}.
	 */
	@Test
	public void movementDtoToEntity() {
		// given
		FinancialMovementDTO dto = new FinancialMovementDTO();

		dto.setAmount(2D);
		dto.setId(1L);
		dto.setDate(new Date());
		dto.setDescription("descrition");
		dto.setThirdParty("third party");

		// when
		FinancialMovement move = FinancialMovementMapper.toEntity(dto);

		// then
		assertThat(move.getId()).isEqualTo(dto.getId());
		assertThat(move.getAmount()).isEqualTo(dto.getAmount());
		assertThat(move.getDate()).isEqualTo(dto.getDate());
		assertThat(move.getDescription()).isEqualTo(dto.getDescription());
		assertThat(move.getThirdParty()).isEqualTo(dto.getThirdParty());
	}

	/**
	 * test for {@link FinancialMovementDTO} null to {@link FinancialMovement} entity.
	 */
	@Test
	public void movementDtoNullToEntity() {
		// given
		FinancialMovementDTO dto = null;


		// when
		FinancialMovement move = FinancialMovementMapper.toEntity(dto);

		// then
		assertThat(move).isNull();
	}

	/**
	 * test for {@link FinancialMovement} entity null to {@link FinancialMovementDTO}.
	 */
	@Test
	public void movementEntityNullToDto() {
		// given
		FinancialMovement move = null;


		// when
		FinancialMovementDTO dto = FinancialMovementMapper.toDto(move);

		// then
		assertThat(dto).isNull();
	}

	/**
	 * test for a List of {@link FinancialMovement} entity null to List of {@link FinancialMovementDTO}.
	 */
	@Test
	public void movementListEntityToListOfDto() {
		// given
		List<FinancialMovement> moves = null;

		// when
		List<FinancialMovementDTO> dtos = FinancialMovementMapper.toListOfDto(moves);

		// then
		assertThat(dtos).isNull();
	}

	/**
	 * test for a List of {@link FinancialMovement} entity to List of {@link FinancialMovementDTO}.
	 */
	@Test
	public void listOfMovementToListOfDto() {
		// given
		List<FinancialMovement> moves = new ArrayList<>();

		for (long i = 0; i < 2; i++) {
			moves.add(new FinancialMovement(1L, "description", new Date(), "party", 2D ));
		}

		// when
		List<FinancialMovementDTO> dtos = FinancialMovementMapper.toListOfDto(moves);

		// then
		assertThat(dtos).isNotNull().hasSameSizeAs(moves);
	}

}
