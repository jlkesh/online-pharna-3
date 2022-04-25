package uz.online.pharma.onlinepharma.service.auth;

import uz.online.pharma.onlinepharma.dto.auth.UserCreateDTO;
import uz.online.pharma.onlinepharma.dto.auth.UserCriteria;
import uz.online.pharma.onlinepharma.dto.auth.UserDTO;
import uz.online.pharma.onlinepharma.dto.auth.UserUpdateDTO;
import uz.online.pharma.onlinepharma.service.GenericCRUDService;

public interface UserService extends GenericCRUDService<UserDTO, UserCreateDTO, UserUpdateDTO, UserCriteria, Long> {
}
