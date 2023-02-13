package com.m2.transactionsmanagement.rest;

import com.m2.transactionsmanagement.DTO.ResponseDTO;
import com.m2.transactionsmanagement.DTO.WalletDto;
import com.m2.transactionsmanagement.models.Transaction;
import com.m2.transactionsmanagement.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController{
    TransactionService transactionService;
    public TransactionController(TransactionService walletService) {
        this.transactionService = walletService;
    }

    @PostMapping("/{walletId}")
    public ResponseEntity<ResponseDTO> executeTransaction(@PathVariable(required = false) String walletId, @RequestBody Transaction transaction) {
        WalletDto wallet = new WalletDto(0, 20L); //Get wallet from wallet microservice by UserCIN;
        ResponseDTO response = transactionService.executeTransaction(wallet, transaction);
        wallet = (WalletDto) response.getData(); //Update wallet in wallet microservice
        if (response.getStatus().equals("error")) return ResponseEntity.badRequest().body(response);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public Object getAllTransactions() {
        return "hello world";
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<List<Transaction>> getTransactionsByWalletId(@PathVariable UUID walletId) {
        List<Transaction> transactions = transactionService.getTransactionsByWalletId(walletId);
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("/{walletId}/{transactionId}")
    public ResponseEntity<ResponseDTO> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok(new ResponseDTO("Transaction deleted successfully", "success"));
    }
}
