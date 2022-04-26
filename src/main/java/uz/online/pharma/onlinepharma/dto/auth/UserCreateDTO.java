package uz.online.pharma.onlinepharma.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.online.pharma.onlinepharma.dto.BaseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO implements BaseDTO {
    private String username;
}
