package co.develhope.nosqlorm.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {


    @Override
    protected String getDatabaseName() {
        return "develhope";
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("co.develhope");
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://Gneffo:@cluster0.zk7dwd2.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
