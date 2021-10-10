/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.service;

import br.com.pa.alex.getnet.model.GetnetAuthorizationTokenResponse;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 03/10/2021
 */
public interface GetnetAuthorizationService {

    GetnetAuthorizationTokenResponse getAuthorizationToken() ;

}