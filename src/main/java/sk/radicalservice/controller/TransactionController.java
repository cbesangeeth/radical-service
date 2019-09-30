package sk.radicalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.radicalservice.domain.Transaction;
import sk.radicalservice.repository.TransactionRepository;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping(value = "/transactions")
    private List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping(value = "/transaction")
    private Transaction createTransaction(@RequestBody Transaction transaction) {

        return transactionRepository.insert(transaction);
    }

    @DeleteMapping(value = "/transactions/{id}")
    private String deleteTransaction(@PathVariable(value = "id") String id){
        transactionRepository.deleteById(id);
        return "Deleted: "+ id;
    }

    @PutMapping(value = "/transactions")
    private Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }

//    @PatchMapping(value = "/transactions/{id}")
//    private Transaction patchTransaction(@PathVariable(value = "id") String id, @RequestBody Transaction transaction){
//        Transaction transaction1 = transactionRepository.findById(id).get();
//        return transactionRepository.save(transaction);
//    }
}
