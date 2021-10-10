/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.util;

import br.com.ecommerce.mongo.lib.base.BaseDocument;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.util.ReflectionUtils;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
public class CascadingMongoEventListener extends AbstractMongoEventListener<BaseDocument> {

    private final MongoOperations mongoOperations;

    public CascadingMongoEventListener(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseDocument> event) {
        BaseDocument source = event.getSource();
        ReflectionUtils.doWithFields(source.getClass(), new CascadeCallback(source, mongoOperations));
    }
}