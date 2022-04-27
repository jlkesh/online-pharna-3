package uz.online.pharma.onlinepharma.repository.auth;

import org.springframework.stereotype.Repository;
import uz.online.pharma.onlinepharma.criteria.auth.AuthTokenCriteria;
import uz.online.pharma.onlinepharma.dao.GenericDao;
import uz.online.pharma.onlinepharma.domains.auth.AuthToken;

@Repository
public class AuthTokenRepository extends GenericDao<AuthToken, AuthTokenCriteria> {
}
