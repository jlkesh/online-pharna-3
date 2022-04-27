package uz.online.pharma.onlinepharma.mapper;

import uz.online.pharma.onlinepharma.domains.BaseEntity;
import uz.online.pharma.onlinepharma.dto.BaseDTO;
import uz.online.pharma.onlinepharma.dto.GenericDTO;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, D extends GenericDTO, E extends BaseEntity> extends BaseMapper {
    E toCreateDTO(CD dto);

    CD fromCreateDTO(E entity);

    E toUpdateDTO(UD dto);

    UD fromUpdateDTO(E entity);

    E toDTO(D dto);

    D fromDTO(E entity);

    List<E> toListDTO(List<CD> dtoList);

    List<CD> fromListDTO(List<E> entityList);
}
