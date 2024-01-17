/**
 *  Class for User entity
 */
package fr.a.factures.security.models;


import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import fr.a.factures.helpers.MagicNumber;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "users")
public class User {

	/**
	 * id for User.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_id")
	private Long id;

	/**
	 * username for User.
	 */
	@NonNull
	@Size(max = MagicNumber.CINQUANTE)
	@Column(name = "use_username")
	private String username;

	/**
	 * email for User.
	 */
	@NonNull
	@Email
	@Size(max = MagicNumber.QUATREVINGHT)
	@Column(name = "use_email")
	private String email;

	/**
	 * password for User.
	 */
	@NonNull
	@Size(max = MagicNumber.TRENTE)
	@Column(name = "use_password")
	private String password;

	/**
	 * lastname for User.
	 */
	@NonNull
	@Size(max = MagicNumber.SIZELONG)
	@Column(name = "use_lastname")
	private String lastname;

	/**
	 * firstname for user.
	 */
	@NonNull
	@Size(max = MagicNumber.CINQUANTE)
	@Column(name = "use_firstname")
	private String firstname;


	/**
	 * picture for User.
	 */
	@Column(name = "use_picture")
	private Blob picture;

	/**
	 * Role for User.
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "use_id"),
	inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * Default Constructor User.
	 */
	public User() {
	}

	/**
	 * @param pId User
	 * @param pUsername User
	 * @param pEmail User
	 * @param pPassword User
	 * @param pLastname User
	 * @param pFirstname User
	 * @param pPicture User
	 * @param pRoles User
	 */
	public User(final Long pId, @Size(max = MagicNumber.CINQUANTE) final String pUsername,
			@Email @Size(max = MagicNumber.QUATREVINGHT) final String pEmail,
			@Size(max = MagicNumber.TRENTE) final String pPassword,
			@Size(max = MagicNumber.SIZELONG) final String pLastname,
			@Size(max = MagicNumber.CINQUANTE) final String pFirstname,
			final Blob pPicture, final Set<Role> pRoles) {
		super();
		this.id = pId;
		this.username = pUsername;
		this.email = pEmail;
		this.password = pPassword;
		this.lastname = pLastname;
		this.firstname = pFirstname;
		this.picture = pPicture;
		this.roles = pRoles;
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
