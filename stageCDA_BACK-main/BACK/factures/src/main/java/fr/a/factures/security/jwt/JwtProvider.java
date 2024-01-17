/**
 *  Class for Jwt provider
 */
package fr.a.factures.security.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import fr.a.factures.security.utils.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

/**
 * @author Stagiaire
 *
 */
@Component
public class JwtProvider {

	/**
	 * secret for JwtProvider.
	 */
	@Value("${app.jwtSecretKey}")
	private String secret;

	/**
	 * jwtExpirationInMs for JwtProvider.
	 */
	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	/**
	 * Key for JwtProvider.
	 */
	private Key key;

//	/**
//	 * logger.
//	 */
//	private final Log logger = LogFactory.getLog(getClass());

	private Key getSigningKey() {
		if (key == null) {
			byte[] keyBytes = Base64.getUrlDecoder().decode(this.secret);
			key = Keys.hmacShaKeyFor(keyBytes);
		}
		return key;
	}

	/**
	 * for generate a token.
	 * @param authentication
	 * @return jwts
	 */
	public String generateToken(final Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

		return Jwts.builder().setSubject(userPrincipal.getUsername())
				.setIssuedAt(new Date()).setExpiration(expiryDate)
				.signWith(getSigningKey(), SignatureAlgorithm.HS512).compact();
	}

	/**
	 * get User username from Jwt.
	 * @param token
	 * @return claims.getSubject()
	 */
	public String getUserUsernameFromJWT(final String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getSigningKey())
				.build().parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	/**
	 * for validate the Token.
	 * @param authToken
	 * @return boolean
	 */
	public boolean validateToken(final String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
		} catch (MalformedJwtException ex) {
		} catch (ExpiredJwtException ex) {
		} catch (UnsupportedJwtException ex) {
		} catch (IllegalArgumentException ex) {
		}
		return false;
	}

}
