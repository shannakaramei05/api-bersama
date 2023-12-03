//package bakabakayow.restApi.services;
//
//import bakabakayow.restApi.dto.Response;
//import bakabakayow.restApi.model.Users;
//import bakabakayow.restApi.repository.UserRepository;
//import bakabakayow.restApi.utils.SetResponse;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import javax.crypto.spec.SecretKeySpec;
//import java.security.Key;
//import java.util.Base64;
//import java.util.Date;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//@Slf4j
//public class AuthorizationService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @Value("${security.jwt.token.secret-key}")
//    private String secretKey;
//
//    private Key hmacKey;
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//        hmacKey= new SecretKeySpec(Base64.getDecoder().decode(secretKey), SignatureAlgorithm.HS256.getJcaName());
//    }
//
//    public String createTokenByEmail (Users user) {
//        Claims claims = Jwts.claims().setSubject(user.getEmail());
//        Date today = new Date();
//        Date validity = new Date(today.getTime() + 3600000);
//        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secretKey),SignatureAlgorithm.ES256.getJcaName());
//        return Jwts.builder().setClaims(claims).setIssuedAt(today).setExpiration(validity).signWith(hmacKey).compact();
//    }
//
//    public Response<Users> validateToken (String token) {
//        String userEmail = "";
//        Users user = null;
//        Response<Users> response = new Response<Users>();
//        try {
//            userEmail = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(token).getBody().getSubject();
//            Optional<Users> userAuth= userRepository.findUserByEmail(userEmail);
//            if(!userAuth.isPresent()) {
//                return SetResponse.setResponseEmailNotFound();
//            }
//            user = userAuth.get();
//            user.setRefreshToken("");
//            String refreshToken = createTokenByEmail(user);
//            user.setRefreshToken(refreshToken);
//            log.info( " Refresh Token : {}",refreshToken);
//            userRepository.save(user);
//        }catch (ExpiredJwtException e) {
//            if(e.toString().contains("expired")) {
//                userEmail = e.getClaims().getSubject();
//                Optional<Users> userAuth = userRepository.findUserByEmail(userEmail);
//                if (!userAuth.isPresent()) {
//                    return SetResponse.setResponseEmailNotFound();
//                }
//
//                user = userAuth.get();
//
//                if (user.getRefreshToken() != null && !user.getRefreshToken().equals("")) {
//                    String refreshToken = user.getRefreshToken();
//
//                    try {
//                        userEmail = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(refreshToken).getBody().getSubject();
//                        user.setRefreshToken("");
//                        user.setRefreshToken(createTokenByEmail(user));
//                        userRepository.save(user);
//                        response = SetResponse.setStatusMessageSuccess(user);
//                    } catch (ExpiredJwtException ex) {
//                        response = SetResponse.setResponseExpired(ex);
//                    }
//                }
//            }
//        }catch (Exception e) {
//            response= SetResponse.setResponseException(e);
//        }
//
//        return response;
//    }
//
//    public Response<Users> createNewUser (Users newUser) {
//        Optional<Users> user = userRepository.findUserByEmail(newUser.getEmail());
//        if(user.isPresent()) {
//            return SetResponse.setResponseEmailAreadyUsed();
//        }
//
//        String password = passwordEncoder.encode(newUser.getPassword());
//        newUser.setPassword(password);
//
//        userRepository.save(newUser);
//        return SetResponse.setStatusMessageSuccess(null);
//    }
//
//}
