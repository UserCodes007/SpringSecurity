package Spring.Security.Sample.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private JwtUtils jwtUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader=request.getHeader("Authorization");
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
            String token=authorizationHeader.substring(7);
            if (jwtUtils.validateToken(token)) {
                Claims claims=jwtUtils.extractAllClaims(token);
            String username= claims.getSubject();
            List<String> roles =(List<String>) claims.get("roles");
            var authorities = roles.stream()
                    .map(r-> new SimpleGrantedAuthority(r))
                    .collect(Collectors.toList());

            var authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
