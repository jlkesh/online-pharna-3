package uz.online.pharma.onlinepharma.service;

import lombok.RequiredArgsConstructor;
import uz.online.pharma.onlinepharma.mapper.BaseMapper;
import uz.online.pharma.onlinepharma.repository.BaseRepository;
import uz.online.pharma.onlinepharma.utils.validator.BaseValidator;

@RequiredArgsConstructor
public abstract class AbstractService<V extends BaseValidator, M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final V validator;
    protected final M mapper;
    protected final R repository;
}
