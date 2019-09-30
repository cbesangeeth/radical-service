package sk.radicalservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sk.radicalservice.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

//@Repository
//public interface UserRepository {
//
//}