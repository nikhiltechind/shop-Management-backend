package com.example.Shop.Management.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class TokenService {
    public static final String token_sign="irendnvkxdskerieonsxlkdgfdoigthelzmcvxmnsdif";
    public String createToken(Integer id){
        try{
            Algorithm algoObj = Algorithm.HMAC256(token_sign);
            String token= JWT.
                    create().
                   withClaim("userId",id.toString()).
                    withClaim("createDate",new Date()).
                    sign(algoObj);
            return token;
        }catch(UnsupportedEncodingException | JWTCreationException e){
             e.printStackTrace();
        }

        return null;
    }

    public String getUserIdToken(String token){
        try{
            Algorithm algoObj=Algorithm.HMAC256(token_sign); //signature
            JWTVerifier jwtverifier = JWT.require(algoObj).build(); // it is requiring the sign to match with the token
            DecodedJWT decodedjwt= jwtverifier.verify(token);
            return decodedjwt.getClaim("userId").asString(); // to identify who actually did it
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean isTokenValid(String token){
        String userId = this.getUserIdToken(token);
        return userId!=null;
    }


}
