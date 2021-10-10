/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.util;

import org.springframework.data.annotation.Id;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import java.lang.reflect.Field;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
public class CustomFieldCallback implements FieldCallback {
    private boolean idFound;

    @Override
    public void doWith(final Field field) throws IllegalArgumentException {
        ReflectionUtils.makeAccessible(field);

        if (field.isAnnotationPresent(Id.class)) {
            idFound = true;
        }
    }

    public boolean isIdFound() {
        return idFound;
    }
}