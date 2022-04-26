package uz.online.pharma.onlinepharma.service.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.online.pharma.onlinepharma.domains.auth.Users;
import uz.online.pharma.onlinepharma.enums.auth.UserStatus;
import uz.online.pharma.onlinepharma.repository.auth.UserRepository;
import uz.online.pharma.onlinepharma.service.auth.UserService;

import java.util.Objects;


@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    public Users findById(Long id) throws UsernameNotFoundException {
        Users users = userRepository.find(id);
        if (Objects.isNull(users))
            throw new UsernameNotFoundException("User not found by id :'%s'".formatted(id));
        if (!users.getStatus().equals(UserStatus.ACTIVE))
            throw new RuntimeException("User is not active");
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return null;
    }
}
