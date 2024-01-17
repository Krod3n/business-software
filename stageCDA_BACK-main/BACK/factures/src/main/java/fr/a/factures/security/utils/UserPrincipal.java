/**
 * class for User principal
 */
package fr.a.factures.security.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Stagiaire
 *
 */
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 928073442559839991L;

	/**
	 * username for UserPrincipal.
	 */
	private String username;

	/**
	 * password for UserPrincipal.
	 */
	private String password;

	/**
	 * enabled for UserPrincipal.
	 */
	private boolean enabled;

	/**
	 * Collection.
	 */
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * get authorities of UserPrincipal.
	 * @return authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * get password of UserPrincipal.
	 * @return password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * get username of UserPrincipal.
	 * @return username
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * if account is non expired.
	 * @return boolean
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * if account non locked.
	 * @return boolean
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * is credentails non expired.
	 * @return boolean
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * if is enabled.
	 * @return enabled
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * set username for UserPrincipal.
	 * @param pUsername
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}

	/**
	 * set password for UserPrincipal.
	 * @param pPassword
	 */
	public void setPassword(final String pPassword) {
		this.password = pPassword;
	}

	/**
	 * set enabled for UserPrincipal.
	 * @param pEnabled
	 */
	public void setEnabled(final boolean pEnabled) {
		this.enabled = pEnabled;
	}

	/**
	 * set authorities for UserPrincipal.
	 * @param pAuthorities
	 */
	public void setAuthorities(final Collection<? extends GrantedAuthority> pAuthorities) {
		this.authorities = pAuthorities;
	}

}
