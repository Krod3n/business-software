/**
 * UserDTO about User
 */
package fr.a.factures.security.dto;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import fr.a.factures.security.models.Role;

/**
 * @author Stagiaire
 *
 */
public class UserDTO {

	/**
	 * id for UserDTO.
	 */
	private Long id;

	/**
	 * username for UserDTO.
	 */
	private String username;

	/**
	 * email for UserDTO.
	 */
	private String email;

	/**
	 * password for UserDTO.
	 */
	private String password;

	/**
	 * lastname for UserDTO.
	 */
	private String lastname;

	/**
	 * firstname for UserDTO.
	 */
	private String firstname;


	/**
	 * picture for UserDTO.
	 */
	private Blob picture;

	/**
	 * Role for UserDTO.
	 */
	private Set<Role> roles = new HashSet<>();

	/**
	 * Default UserDTO constructor.
	 */
	public UserDTO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Long pId) {
		this.id = pId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param pUsername the username to set
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param pEmail the email to set
	 */
	public void setEmail(final String pEmail) {
		this.email = pEmail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param pLastname the lastname to set
	 */
	public void setLastname(final String pLastname) {
		this.lastname = pLastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param pFirstname the firstname to set
	 */
	public void setFirstname(final String pFirstname) {
		this.firstname = pFirstname;
	}

	/**
	 * @return the picture
	 */
	public Blob getPicture() {
		return picture;
	}

	/**
	 * @param pPicture the picture to set
	 */
	public void setPicture(final Blob pPicture) {
		this.picture = pPicture;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param pRoles the roles to set
	 */
	public void setRoles(final Set<Role> pRoles) {
		this.roles = pRoles;
	}

}
