package sk.radicalservice.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.radicalservice.common.APIResponse;
import sk.radicalservice.domain.Transaction;
import sk.radicalservice.dto.TransactionDTO;
import sk.radicalservice.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public APIResponse patchUpdateTransaction(Transaction transaction, String id) {
        APIResponse response = new APIResponse();

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

        transaction = transactionRepository.save(dbTransaction);
        response.setData(transaction);

        return response;
    }

    public APIResponse createTransaction(TransactionDTO transactionDTO) {

        APIResponse apiResponse = new APIResponse();
        //validate

        // save
        Transaction transaction = transactionDTO.convertToEntity(transactionDTO);
        transaction = transactionRepository.insert(transaction);

        TransactionDTO dto = new TransactionDTO(transaction);
        // return
        apiResponse.setData(dto);
        return apiResponse;
    }

    public APIResponse getTransactions() {
        APIResponse apiResponse = new APIResponse();

        List<Transaction> transactions = transactionRepository.findAll();
        apiResponse.setData(transactions);

        return apiResponse;
    }
}
