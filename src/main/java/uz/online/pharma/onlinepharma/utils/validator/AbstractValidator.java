package uz.online.pharma.onlinepharma.utils.validator;

import uz.online.pharma.onlinepharma.dto.BaseDTO;
import uz.online.pharma.onlinepharma.dto.GenericDTO;
import uz.online.pharma.onlinepharma.exceptions.exception.InvalidValidationException;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractValidator<CD extends BaseDTO, UD extends GenericDTO, K extends Serializable> implements BaseValidator {

    protected void validOnCreateDTO(CD dto) throws InvalidValidationException {
        if (Objects.isNull(dto)) throw new InvalidValidationException();
    }

    protected void validOnUpdateDTO(UD dto) throws InvalidValidationException {
        if (Objects.isNull(dto)) throw new InvalidValidationException();
    }

    protected void validOnKey(K key) throws InvalidValidationException {
        if (Objects.isNull(key)) throw new InvalidValidationException();
    }

}
