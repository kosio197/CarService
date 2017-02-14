package bg.garage.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.garage.model.UserModel;
import bg.garage.services.UserService;

public class UsersDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userService.getUserModel(username);

        if (user == null) {
            throw new AuthenticationServiceException("Invalid Credentials");
        }

        return user;
    }
}
