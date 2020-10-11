package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.User;
//import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaWsdlMappingType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class MD5Util {
    /**
     * MD5加密类
     * @param str 要加密的字符串
     * @return    加密后的字符串
     */
    private static final Logger logger= LoggerFactory.getLogger(MD5Util.class);
    private static String secret="abc123456"; //加密的secret
    private static long ttl=365*6000;  //token超时时间 秒
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
    //传入user对象，返回生成token的方法
    public  static String getToken(User user){
        String token="";
        token= JWT.create().withAudience(user.getId()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
    //生成用户token，设置token超时时间
    public static String createToken(User user){
        Date expireDate=new Date(System.currentTimeMillis()+ttl*1000);
        Map<String,Object> map=new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token=JWT.create()
                .withHeader(map)
                .withClaim("id",user.getId())
                .withClaim("name",user.getUsername())
                .withExpiresAt(expireDate)
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(secret));
        return token;

    }
    //校验token并解析token
    public static Map<String, Claim> verifyToken(String token) throws Exception{
        try{
            JWTVerifier verifier=JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT jwt=verifier.verify(token);
            return jwt.getClaims();
        }catch (TokenExpiredException e){
            logger.error("token已过期");
            throw new Exception("token已过期");
        }catch(JWTVerificationException e){
            logger.error("token不存在或不正确");
            throw new Exception("token不存在或不正确");
        }


    }
    //token解析-这个方法是正确的
    public static Claims verifyJwt(String token){
        Claims claims;
        try {
            claims=Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        }catch (Exception e){
            claims=null;
        }
        return claims;
    }
    //生成token的方法
    public static String generateToken(User user){
       String userId=user.getId();
        Date nowDate=new Date();
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        //过期时间
        Date expireDate=new Date(nowDate.getTime()+ttl*1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(signatureAlgorithm,secret)
                .compact();
    }
    public static Claims getClaimByToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    public static void main(String[] args) {
        System.out.println("要加密的字符串是："+code("1"));
    }
}
