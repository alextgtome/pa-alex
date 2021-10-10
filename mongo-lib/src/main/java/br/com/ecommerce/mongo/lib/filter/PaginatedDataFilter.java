/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.filter;

import org.springframework.data.domain.Pageable;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
public interface PaginatedDataFilter extends DataFilter {

    void setOrder(Boolean order);

    void setOrderBy(String orderBy);

    /**
     * Return a page to filter data
     *
     * @return Spring pageable
     */
    Pageable getPaginationFilter();
}
