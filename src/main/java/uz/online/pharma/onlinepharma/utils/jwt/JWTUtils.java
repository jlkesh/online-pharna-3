package uz.online.pharma.onlinepharma.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JWTUtils {
    public static Long accessTokenExpiry = TimeUnit.MINUTES.toMillis(30);
    public static Long refreshTokenExpiry = TimeUnit.DAYS.toMillis(1);
    public static String secretKey = "123qwe456rty789uio0p,./;'][[][";

    public static Date getExpiryForAccessToken() {
        return new Date(System.currentTimeMillis() + accessTokenExpiry);
    }

    public static Date getExpiryForRefreshToken() {
        return new Date(System.currentTimeMillis() + refreshTokenExpiry);
    }

    public static Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secretKey.getBytes());
    }

    public static JWTVerifier getVerifier() {
        return JWT.require(getAlgorithm()).build();
    }
}
