package uz.online.pharma.onlinepharma.service;

import org.springframework.http.ResponseEntity;
import uz.online.pharma.onlinepharma.criteria.GenericCriteria;
import uz.online.pharma.onlinepharma.dto.BaseDTO;
import uz.online.pharma.onlinepharma.dto.GenericDTO;
import uz.online.pharma.onlinepharma.response.Data;

import java.io.Serializable;

public interface GenericCRUDService<
        D extends GenericDTO,
        CD extends BaseDTO,
        UD extends GenericDTO,
        C extends GenericCriteria,
        K extends Serializable>
        extends GenericService<D, C, K> {
    ResponseEntity<Data<Void>> create(CD dto);

    ResponseEntity<Data<Void>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K key);
}
