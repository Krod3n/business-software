/**
 * class for Role entity
 */
package fr.a.factures.security.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.a.factures.helpers.MagicNumber;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "roles")
public class Role {

	/**
	 * id for Role.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private Integer id;

	/**
	 * name about RoleName for Role.
	 */
	@Enumerated(EnumType.STRING)
	@Column(length = MagicNumber.VINGHT, name = "rol_name")
	private RoleName name;

	/**
	 * default constructor for Role.
	 */
	public Role() {
	}

	/**
	 * @param pName the name
	 */
	public Role(final RoleName pName) {
		this.name = pName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param pId the id to set
	 */
	public void setId(final Integer pId) {
		this.id = pId;
	}

	/**
	 * @return name the name
	 */
	public RoleName getName() {
		return name;
	}

	/**
	 * @param pName the name to set
	 */
	public void setName(final RoleName pName) {
		this.name = pName;
	}

}
