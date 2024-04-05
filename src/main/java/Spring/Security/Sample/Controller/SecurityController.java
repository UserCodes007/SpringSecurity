package Spring.Security.Sample.Controller;

import Spring.Security.Sample.Model.AuthRequest;
import Spring.Security.Sample.Security.JwtUtils;
import Spring.Security.Sample.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController {
    AuthenticationManager authenticationManager;
    UserService userService;
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public String authenticate(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        return jwtUtils.generateToken(userDetails);
    }
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request){
        userService.store(request);
        return "Registered Successfully";
    }
}
