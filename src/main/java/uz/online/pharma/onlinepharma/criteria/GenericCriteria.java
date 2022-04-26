package uz.online.pharma.onlinepharma.criteria;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class GenericCriteria implements BaseCriteria, Serializable {

    protected Long selfId;

    protected Integer page;

    protected Integer perPage;

    protected String sortBy;

    protected String sortDirection;

    public String getSortDirection() {
        return sortDirection == null || sortDirection.equals("") ? "ASC" : sortDirection;
    }
}

