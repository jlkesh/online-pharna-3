package uz.online.pharma.onlinepharma.repository.auth;

import org.springframework.stereotype.Repository;
import uz.online.pharma.onlinepharma.criteria.auth.UserCriteria;
import uz.online.pharma.onlinepharma.dao.GenericDao;
import uz.online.pharma.onlinepharma.domains.auth.Users;

@Repository
public class UserRepository extends GenericDao<Users, UserCriteria> {

}
