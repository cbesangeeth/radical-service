package sk.radicalservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sk.radicalservice.domain.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
