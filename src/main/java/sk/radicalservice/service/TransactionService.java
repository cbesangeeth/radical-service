package sk.radicalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.radicalservice.domain.Transaction;
import sk.radicalservice.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction patchUpdateTransaction(Transaction transaction, String id) {
        Transaction dbTransaction = transactionRepository.findById(id).get();

        if (transaction.getAmount() != null) {
            dbTransaction.setAmount(transaction.getAmount());
        }

        if (transaction.getDescription() != null) {
            dbTransaction.setDescription(transaction.getDescription());
        }

        if (transaction.getType() != null) {
            dbTransaction.setType(transaction.getType());
        }

        if (transaction.getTransactionDate() != null) {
            dbTransaction.setTransactionDate(transaction.getTransactionDate());
        }

        return transactionRepository.save(dbTransaction);
    }
}
