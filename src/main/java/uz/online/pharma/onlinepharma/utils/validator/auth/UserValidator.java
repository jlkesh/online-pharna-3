package uz.online.pharma.onlinepharma.utils.validator.auth;

import org.springframework.stereotype.Component;
import uz.online.pharma.onlinepharma.dto.auth.UserCreateDTO;
import uz.online.pharma.onlinepharma.dto.auth.UserUpdateDTO;
import uz.online.pharma.onlinepharma.utils.validator.AbstractValidator;


@Component
public class UserValidator extends AbstractValidator<UserCreateDTO, UserUpdateDTO, Long> {

}
