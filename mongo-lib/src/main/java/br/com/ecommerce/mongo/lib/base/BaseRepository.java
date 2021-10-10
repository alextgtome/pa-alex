/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.base;

import br.com.ecommerce.mongo.lib.filter.DataFilter;
import br.com.ecommerce.mongo.lib.filter.PaginatedDataFilter;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.query.Query;

import static java.util.Optional.ofNullable;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
public abstract class BaseRepository {

    protected static final String ID = "id";

    protected void addBaseFilter(Query query, DataFilter baseFilter) {
        ofNullable(baseFilter).ifPresent(b -> {
            ofNullable(b.getId()).ifPresent(s -> query.addCriteria(where(ID).is(s)));
            ofNullable(b.getDatePropertyFilter()).ifPresent(s -> betweenDateFilter(query, b.getDatePropertyFilter(), b.getStartDate(), b.getEndDate()));
        });
    }

    protected void addBaseFilter(Query query, PaginatedDataFilter baseFilter) {
        ofNullable(baseFilter).ifPresent(b -> {
            ofNullable(b.getId()).ifPresent(s -> query.addCriteria(where(ID).is(s)));
            ofNullable(b.getDatePropertyFilter()).ifPresent(s -> betweenDateFilter(query, b.getDatePropertyFilter(), b.getStartDate(), b.getEndDate()));
        });
    }

    protected void betweenDateFilter(Query query, String datePropertyFilter, DateTime startDate, DateTime endDate) {
        query.addCriteria(where(datePropertyFilter).gte(startDate).lte(endDate));
    }

}
