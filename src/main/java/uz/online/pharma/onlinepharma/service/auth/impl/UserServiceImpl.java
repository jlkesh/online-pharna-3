package uz.online.pharma.onlinepharma.service.auth.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.online.pharma.onlinepharma.dto.auth.UserCreateDTO;
import uz.online.pharma.onlinepharma.dto.auth.UserCriteria;
import uz.online.pharma.onlinepharma.dto.auth.UserDTO;
import uz.online.pharma.onlinepharma.dto.auth.UserUpdateDTO;
import uz.online.pharma.onlinepharma.mapper.UserMapper;
import uz.online.pharma.onlinepharma.response.Data;
import uz.online.pharma.onlinepharma.service.AbstractService;
import uz.online.pharma.onlinepharma.service.auth.UserService;
import uz.online.pharma.onlinepharma.utils.validator.auth.UserValidator;

import java.util.List;


@Service
public class UserServiceImpl extends AbstractService<UserValidator, UserMapper, UserRepository> implements UserService {

    public UserServiceImpl(UserValidator validator, UserMapper mapper, UserRepository repository) {
        super(validator, mapper, repository);
    }

    @Override
    public ResponseEntity<Data<Void>> create(UserCreateDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> update(UserUpdateDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long key) {
        return null;
    }

    @Override
    public ResponseEntity<Data<UserDTO>> get(Long key) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<UserDTO>>> getAll(UserCriteria criteria) {
        return null;
    }
}
