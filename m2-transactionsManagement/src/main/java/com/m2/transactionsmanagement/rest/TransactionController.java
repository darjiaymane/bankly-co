package com.m2.transactionsmanagement.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2.transactionsmanagement.DTO.ResponseDTO;
import com.m2.transactionsmanagement.DTO.WalletDto;
import com.m2.transactionsmanagement.models.Transaction;
import com.m2.transactionsmanagement.openFeignCLient.UserWallet;
import com.m2.transactionsmanagement.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController{
    TransactionService transactionService;
    UserWallet userWallet;
    public TransactionController(TransactionService walletService, UserWallet userWallet){
        this.transactionService = walletService;
        this.userWallet = userWallet;
    }

    /**
     * Executes a transaction for a given wallet ID and transaction data.
     *
     * @param walletId The ID of the wallet to execute the transaction on.
     * @param transaction The transaction data to execute.
     * @return A ResponseEntity containing the transaction execution response data.
     */
    @PostMapping("/{walletId}")
    public ResponseEntity<ResponseDTO> executeTransaction(@PathVariable String walletId, @RequestBody Transaction transaction) {
        // Call the wallet microservice to get the wallet data for the given wallet ID.
        ResponseEntity<ResponseDTO> walletResponse = userWallet.getWalletByUuid(walletId);

        // Check if the wallet was found. If not, return a 400 Bad Request response.
        if (walletResponse.getBody() == null || walletResponse.getBody().getData() == null) {
            return ResponseEntity.badRequest().body(new ResponseDTO("Wallet not found", "error"));
        }

        // Convert the wallet data from the response to a WalletDto object.
        WalletDto wallet = new ObjectMapper().convertValue(walletResponse.getBody().getData(), WalletDto.class);

        // Execute the transaction on the wallet.
        ResponseDTO transactionExecutionResponse = transactionService.executeTransaction(wallet, transaction);

        // If the transaction execution response indicates an error, return a 400 Bad Request response.
        if (transactionExecutionResponse.getStatus().equals("error")) {
            return ResponseEntity.badRequest().body(transactionExecutionResponse);
        }

        // Update the wallet data with the result of the transaction.
        wallet = (WalletDto) transactionExecutionResponse.getData();

        // Call the wallet microservice to update the wallet data with the new balance.
        ResponseEntity<ResponseDTO> updateWalletResponse = userWallet.updateWallet(walletId, wallet.getSolde());

        // If the wallet update response indicates an error, return a 400 Bad Request response.
        if (updateWalletResponse.getBody().getStatus().equals("error")) {
            return ResponseEntity.badRequest().body(updateWalletResponse.getBody());
        }

        // Return the transaction execution response as a 200 OK response.
        return ResponseEntity.ok(transactionExecutionResponse);
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

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<ResponseDTO> deleteTransaction(@PathVariable String transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok(new ResponseDTO("Transaction deleted successfully", "success"));
    }
}
