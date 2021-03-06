package pers.gg.yh.manager.common.util;

import java.util.Calendar;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	private static final String SIGN_KEY = "123456";
	private static final Integer DEFAULT_EXPIRES = 60 * 30;
	private static final Integer DEFAULT_TOKEN_SIZE = 3;
	
	public static String getToken(Map<String, String> map) throws Exception {
        return getToken(map, DEFAULT_EXPIRES);
    }
	
	public static String getToken(Map<String, String> map, Integer expires) throws JWTDecodeException {
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND, expires);
		JWTCreator.Builder builder = JWT.create();
		
		map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
		
		String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SIGN_KEY));
		
		return confoundPayload(token);
	}
	
	public static DecodedJWT verify(String token) throws Exception {
        if (token == null || "".equals(token)) {
            throw new JWTDecodeException("Invalid token!");
        }
        String dToken = deConfoundPayload(token.substring("Bearer ".length()));
        return JWT.require(Algorithm.HMAC256(SIGN_KEY)).build().verify(dToken);

    }
	
	private static String deConfoundPayload(String token) throws Exception {
        String[] split = token.split("\\.");
        if (split.length != DEFAULT_TOKEN_SIZE) {
            throw new JWTDecodeException("Incorrect signature!");
        }
        String payload = split[1];
        return split[0] + "." + reversePayload(payload, payload.length() / 2) + "." + split[2];
    }
	
	private static String confoundPayload(String token) throws JWTDecodeException {
        String[] split = token.split("\\.");
        if (split.length != DEFAULT_TOKEN_SIZE) {
            throw new JWTDecodeException("Incorrect signature!");
        }
        String payload = split[1];
        int length = payload.length() / 2;
        int index = payload.length() % 2 != 0 ? length + 1 : length;
        return split[0] + "." + reversePayload(payload, index) + "." + split[2];
    }
	
	private static String reversePayload(String payload, Integer index) {
        return payload.substring(index) + payload.substring(0, index);
    }
}
