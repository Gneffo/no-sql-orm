package co.develhope.nosqlorm.repository;

import co.develhope.nosqlorm.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
