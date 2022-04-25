package uz.online.pharma.onlinepharma.service.auth.impl;

import org.springframework.stereotype.Repository;
import uz.online.pharma.onlinepharma.repository.BaseRepository;

import javax.persistence.EntityManager;

@Repository
public class UserRepository implements BaseRepository {
    private EntityManager entityManager;

}
