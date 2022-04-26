package uz.online.pharma.onlinepharma.dto.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.online.pharma.onlinepharma.domains.auth.Users;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final Users user;
    private final UserDto userDto;

    public UserDetails(Users user, UserDto userDto) {
        this.user = user;
        this.userDto = userDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            role.getPermissions().forEach(permission ->
                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getAuthority())));
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !user.getState().equals(State.DELETED);
    }

    public _User getUser() {
        return user;
    }

    public UserDto getUserDto() {
        return userDto;
    }
}
