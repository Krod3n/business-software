/**
 *  Class for Jwt response
 */
package fr.a.factures.security.controller.dto;

/**
 * @author Stagiaire
 *
 */
public class JwtResponse {

	/**
	 * token for JwtResponse.
	 */
	private String token;

	/**
	 * tokenHeader for JwtResponse.
	 */
	private String tokenHeader;

	/**
	 *
	 */
	public JwtResponse() {
		super();
	}

	/**
	 * @param pToken token
	 * @param pTokenHeader tokenHeader of JwtResponse
	 */
	public JwtResponse(final String pToken, final String pTokenHeader) {
		super();
		this.token = pToken;
		this.tokenHeader = pTokenHeader;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param pToken the token to set
	 */
	public void setToken(final String pToken) {
		this.token = pToken;
	}

	/**
	 * @return the tokenHeader
	 */
	public String getTokenHeader() {
		return tokenHeader;
	}

	/**
	 * @param pTokenHeader the tokenHeader to set
	 */
	public void setTokenHeader(final String pTokenHeader) {
		this.tokenHeader = pTokenHeader;
	}

}
