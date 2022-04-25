package uz.online.pharma.onlinepharma.service;

import org.springframework.http.ResponseEntity;
import uz.online.pharma.onlinepharma.criteria.BaseCriteria;
import uz.online.pharma.onlinepharma.dto.GenericDTO;
import uz.online.pharma.onlinepharma.response.Data;

import java.io.Serializable;
import java.util.List;

public interface GenericService<D extends GenericDTO, C extends BaseCriteria, K extends Serializable> {
    ResponseEntity<Data<D>> get(K key);

    ResponseEntity<Data<List<D>>> getAll(C criteria);
}
