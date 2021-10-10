/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.filter;

import org.joda.time.DateTime;


/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
public interface DataFilter {

    String getId();

    String getDatePropertyFilter();

    DateTime getStartDate();

    DateTime getEndDate();

}
