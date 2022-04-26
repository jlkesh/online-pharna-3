package uz.online.pharma.onlinepharma.utils;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BaseUtils {

    public boolean isEmpty(Object obj) {
        return obj == null;
    }

    public boolean isEmpty(String obj) {
        return obj == null || obj.length() == 0;
    }

    public boolean isEmpty(Collection<Object> objs) {
        return objs == null || objs.size() == 0;
    }

}
