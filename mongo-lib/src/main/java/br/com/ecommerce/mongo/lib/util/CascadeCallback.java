/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.util;


import br.com.ecommerce.mongo.lib.annotation.CascadeSave;
import org.springframework.data.mapping.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
public class CascadeCallback implements FieldCallback {

    private final Object source;
    private MongoOperations mongoOperations;

    CascadeCallback(final Object source, final MongoOperations mongoOperations) {
        this.source = source;
        this.setMongoOperations(mongoOperations);
    }

    @Override
    public void doWith(@NotNull final Field field) throws IllegalArgumentException, IllegalAccessException {
        ReflectionUtils.makeAccessible(field);

        if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
            final Object fieldValue = field.get(source);

            if (fieldValue instanceof List<?>) {
                for (Object item : (List<?>) fieldValue) {
                    checkNSave(item);
                }
            } else {
                checkNSave(fieldValue);
            }
        }

    }

    private void setMongoOperations(final MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    private void checkNSave(Object fieldValue) {
        CustomFieldCallback callback = new CustomFieldCallback();
        ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

        if (!callback.isIdFound()) {
            throw new MappingException("Oops, something went wrong. Child doesn't have @Id?");
        }

        mongoOperations.save(fieldValue);
    }
}
