package peaksoft.config.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import peaksoft.entities.User;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtService jwtService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        // "Bearer "
        String headerToken = request.getHeader(AUTHORIZATION_HEADER);

        if (headerToken != null && headerToken.startsWith(BEARER_PREFIX)) {
            headerToken = headerToken.substring(BEARER_PREFIX.length());
            try {
                User user = jwtService.verifyToken(headerToken);
                if (user != null) {
                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(
                                    new UsernamePasswordAuthenticationToken(
                                            user.getUsername(),
                                            null,
                                            user.getAuthorities()));
                }

            } catch (JWTVerificationException e) {
                System.err.println(e.getMessage());
            }
        }
        filterChain.doFilter(request, response);

    }





//
//    @Override
//    protected void doFilterInternal(
//            @NonNull HttpServletRequest request,
//            @NonNull HttpServletResponse response,
//            @NonNull FilterChain filterChain) throws ServletException, IOException {
//
//        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
//
//        if (header != null && header.startsWith("Bearer ")) {
//            String jwt = header.substring(7);
//
//            try {
//                User user = jwtService.verifyToken(jwt);
//                if (user != null) {
//                    SecurityContextHolder.getContext()
//                            .setAuthentication(
//                                    new UsernamePasswordAuthenticationToken(
//                                            user.getEmail(),
//                                            null,
//                                            user.getAuthorities()
//                                    ));
//                }
//            } catch (JWTVerificationException e) {
//                HttpStatusUNAUTHORIZED
//                response.setStatus(HttpStatusUNAUTHORIZED.value());
//                response.getWriter().write("Invalid or expired JWT token");
//                response.getWriter().flush();
//                return;
//            } catch (Exception e) {
//                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//                response.getWriter().write("An error occurred while processing the token");
//                response.getWriter().flush();
//                return;
//            }
//
//        }
//        filterChain.doFilter(request, response);
//
//    }
}
