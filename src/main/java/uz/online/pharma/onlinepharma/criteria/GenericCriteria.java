package uz.online.pharma.onlinepharma.criteria;

import lombok.*;
import uz.online.pharma.onlinepharma.enums.SelectOrder;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenericCriteria implements BaseCriteria {
    private Integer page;
    private Integer size;

    private SelectOrder orderDirection;

    public String getOrderDirection() {
        return Objects.nonNull(orderDirection) ? orderDirection.name() : " ASC ";
    }

    public Integer getPage() {
        return Objects.nonNull(page) ? page : 0;
    }

    public Integer getSize() {
        return Objects.nonNull(size) ? size : 10;
    }
}
