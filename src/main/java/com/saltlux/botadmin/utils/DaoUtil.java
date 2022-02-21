package com.saltlux.botadmin.utils;
import com.saltlux.botadmin.common.SearchCriteria;
import com.saltlux.botadmin.exception.BadRequestException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DaoUtil {
    public static Predicate buildPredicate(Path path, CriteriaBuilder builder, SearchCriteria criteria) {
        String operation = criteria.getOperation();
        List<String> values = null;
        if (criteria.getValue() instanceof Collection) {
            values = (List<String>) criteria.getValue();
        }
        String valueString = null == criteria.getValue() ? null : String.valueOf(criteria.getValue());

        if (operation.equalsIgnoreCase(":")) {
            if (path.getJavaType() == String.class) {
                if (null == valueString) {
                    return builder.isNull(path);
                }
                if (Objects.isNull(values) || values.size() == 0) {
                    return builder.like(path, "%" + valueString + "%");
                } else {
                    Predicate p = builder.like(path, "%" + values.get(0) + "%");
                    for (int i = 1; i < values.size(); i++) {
                        p = builder.or(p, builder.like(path, "%" + values.get(i) + "%"));
                    }
                    return p;
                }

            } else if (path.getJavaType() == Date.class) {
                try {
                    Date dateVal = new SimpleDateFormat("yyyy-MM-dd").parse(valueString);
                    return builder.equal(path, dateVal);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            } else {
                return builder.equal(path, valueString);
            }
        } else if (operation.equalsIgnoreCase(">")) {
            if (path.getJavaType() == Date.class) {
                try {
                    Date dateVal = new SimpleDateFormat("yyyy-MM-dd").parse(valueString);
                    return builder.greaterThanOrEqualTo(path, dateVal);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
            return builder.greaterThanOrEqualTo(path, valueString);

        } else if (operation.equalsIgnoreCase("<")) {
            if (path.getJavaType() == Date.class) {
                try {
                    Date dateVal = new SimpleDateFormat("yyyy-MM-dd").parse(valueString);
                    return builder.lessThanOrEqualTo(path, dateVal);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
            return builder.lessThanOrEqualTo(path, valueString);
        }

        return null;
    }

    public static String like(String param) {
        return "%" + (Objects.isNull(param) ? "" : param.trim()) + "%";
    }


    public static Pageable buildPageable(int page, int size,String orderBy,  String sortDirection) {
        return PageRequest.of(page, size, "desc".equalsIgnoreCase(sortDirection) ? Sort.Direction.DESC : Sort.Direction.ASC,orderBy);
    }


    public static Order buildOrder(CriteriaBuilder cb, Root root, String orderBy, String sortDirection) {
        if(Objects.isNull(orderBy)){
            throw new BadRequestException("orderBy is invalid");
        }
        if (Objects.nonNull(sortDirection) && "desc".equalsIgnoreCase(sortDirection)) {
            return cb.desc(root.get(orderBy));
        } else {
            return cb.asc(root.get(orderBy));
        }
    }
}
