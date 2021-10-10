/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.mongo.lib.configuration;

import br.com.ecommerce.mongo.lib.util.CascadingMongoEventListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: Mongo lib
 * @since 23/01/2021
 */
@Log4j2
@RequiredArgsConstructor
@Configuration
public class MongoConfiguration {

    private MongoTemplate mongoTemplate;

    private MongoConverter mongoConverter;

    private MongoOperations mongoOperations;

    @Autowired
    public MongoConfiguration(MongoOperations mongoOperations, MongoTemplate mongoTemplate, MongoConverter mongoConverter) {
        this.mongoOperations = mongoOperations;
        this.mongoTemplate = mongoTemplate;
        this.mongoConverter = mongoConverter;
    }

    @Bean
    public CascadingMongoEventListener userCascadingMongoEventListener() {
        return new CascadingMongoEventListener(mongoOperations);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        log.info("Mongo InitIndicesAfterStartup init");
        long init = System.currentTimeMillis();
        MongoMappingContext mappingContext = (MongoMappingContext) this.mongoConverter.getMappingContext();
        for (BasicMongoPersistentEntity<?> persistentEntity : mappingContext.getPersistentEntities()) {
            Class clazz = persistentEntity.getType();
            if (!clazz.isAnnotationPresent(Document.class)) {
                continue;
            }
            MongoPersistentEntityIndexResolver resolver = new MongoPersistentEntityIndexResolver(mappingContext);
            IndexOperations indexOps = mongoTemplate.indexOps(clazz);
            resolver.resolveIndexFor(clazz).forEach(indexOps::ensureIndex);
        }
        log.info("Mongo InitIndicesAfterStartup take: {}", (System.currentTimeMillis() - init));
    }

}
