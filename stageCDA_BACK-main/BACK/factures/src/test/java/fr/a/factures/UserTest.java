/**
 * Test for {@link UserMapper}
 */
package fr.a.factures;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.a.factures.security.dto.UserDTO;
import fr.a.factures.security.models.User;
import fr.a.factures.security.utils.UserMapper;
import fr.a.factures.security.utils.UserPrincipal;

/**
 * @author Stagiaire
 *
 */
@SpringBootTest
public class UserTest {

	/**
	 * Test for {@link User} Constructor.
	 */
	@Test
	void userConstructor(){
		// given

		// when
		Object m = new UserMapper();

		// then
		assertEquals(m.getClass(), UserMapper.class);
	}

	/**
	 * test for {@link User} to {@link UserDTO}.
	 */
	@Test
	public void userToDto() {
		// given
		User user = new User();

		user.setId(1L);
		user.setUsername("pseudo");
		user.setPassword("password");
		user.setLastname("name");
		user.setFirstname("surname");
		user.setEmail("email");
		user.setPicture(null);
		user.setRoles(null);

		// when
		UserDTO dto = UserMapper.toDto(user);

		// then
		assertThat(dto.getId()).isEqualTo(user.getId());
		assertThat(dto.getUsername()).isEqualTo(user.getUsername());
		assertThat(dto.getPassword()).isEqualTo(user.getPassword());
		assertThat(dto.getLastname()).isEqualTo(user.getLastname());
		assertThat(dto.getFirstname()).isEqualTo(user.getFirstname());
		assertThat(dto.getEmail()).isEqualTo(user.getEmail());
		assertThat(dto.getPicture()).isEqualTo(user.getPicture());
		assertThat(dto.getRoles()).isEqualTo(user.getRoles());

	}

	/**
	 * test for {@link User} entity null to {@link UserDTO}.
	 */
	@Test
	public void userNullToDto() {
		// given
		User user = null;


		// when
		UserDTO dto = UserMapper.toDto(user);

		// then
		assertThat(dto).isNull();
	}

	/**
	 * test {@link UserPrincipal} link with {@link User}.
	 */
	@Test
	public void userPrincipal() {
		// given
		User user = new User();

		user.setUsername("user");
		user.setPassword("mdp");

		// when
		UserPrincipal userp = UserMapper.userToPrincipal(user);

		// then
		assertThat(userp.getUsername()).isEqualTo(user.getUsername());
		assertThat(userp.getPassword()).isEqualTo(user.getPassword());


	}

}
