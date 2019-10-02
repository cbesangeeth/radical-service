package sk.radicalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.radicalservice.common.APIResponse;
import sk.radicalservice.domain.Transaction;
import sk.radicalservice.dto.TransactionDTO;
import sk.radicalservice.repository.TransactionRepository;
import sk.radicalservice.service.TransactionService;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transactions")
    private ResponseEntity getAllTransactions() {

        APIResponse response = transactionService.getTransactions();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(value = "/transaction")
    private ResponseEntity createTransaction(@RequestBody TransactionDTO transactionDTO) {

        APIResponse response = transactionService.createTransaction(transactionDTO);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(value = "/transactions/{id}")
    private String deleteTransaction(@PathVariable(value = "id") String id){
        transactionRepository.deleteById(id);
        return "Deleted: "+ id;
    }

    @Deprecated
    @PutMapping(value = "/transactions/{id}")
    private Transaction updateTransaction(@PathVariable(value = "id") String id,
                                          @RequestBody Transaction transaction){
        Transaction dbTransaction = transactionRepository.findById(id).get();
        dbTransaction = transaction;
        return transactionRepository.save(dbTransaction);
    }

    @PatchMapping(value = "/transactions/{id}")
    private ResponseEntity patchTransaction(@PathVariable(value = "id") String id,
                                         @RequestBody Transaction transaction){

        APIResponse response = transactionService.patchUpdateTransaction(transaction, id);

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(value = "/transactions/deleteAll")
    private String deleteAllTransaction(){
        transactionRepository.deleteAll();
        return "Deleted all transactions";
    }
}
