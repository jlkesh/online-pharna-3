package uz.online.pharma.onlinepharma.criteria.auth;

import lombok.*;
import uz.online.pharma.onlinepharma.criteria.GenericCriteria;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria extends GenericCriteria {
    private String principal;


    @Builder(builderMethodName = "childBuilder")
    public UserCriteria(Long selfId, Integer page, Integer perPage, String sortBy, String sortDirection, String principal) {
        super(selfId, page, perPage, sortBy, sortDirection);
        this.principal = principal;
    }
}
