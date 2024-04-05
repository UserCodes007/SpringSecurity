package Spring.Security.Sample.Service;

import Spring.Security.Sample.Model.AuthRequest;
import Spring.Security.Sample.Model.User;
import Spring.Security.Sample.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class UserService implements UserDetailsService {
    UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username);
    }
    public void store(AuthRequest request){
        PasswordEncoder encoder=new BCryptPasswordEncoder();
        User user=User.builder().username(request.getUsername()).password(encoder.encode(request.getPassword())).role("CUSTOMER").build();
        repo.save(user);
    }
    @PostConstruct
    void inti(){
        PasswordEncoder encoder=new BCryptPasswordEncoder();
        repo.save(User.builder().username("admin").password(encoder.encode("admin123")).role("ADMIN").build());
    }
}
