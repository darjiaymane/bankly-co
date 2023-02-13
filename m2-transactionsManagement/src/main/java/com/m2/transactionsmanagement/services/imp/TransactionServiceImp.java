package com.m2.transactionsmanagement.services.imp;

import com.m2.transactionsmanagement.DTO.ResponseDTO;
import com.m2.transactionsmanagement.DTO.WalletDto;
import com.m2.transactionsmanagement.models.Transaction;
import com.m2.transactionsmanagement.repositories.TransactRepository;
import com.m2.transactionsmanagement.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImp implements TransactionService {

    private final TransactRepository transactionRepository;

    /**
     * Constructor for TransactionServiceImp, to inject the TransactionRepository bean.
     * @param transactionRepository is an instance of TransactionRepository.
     */
    public TransactionServiceImp(TransactRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Method to execute transactions.
     * @param wallet is the WalletDto object which contains the information about the wallet.
     * @param transaction is the Transaction object that contains information about the transaction to be executed.
     * @return a ResponseDTO object which contains the result of the transaction execution.
     */
    @Override
    public ResponseDTO executeTransaction(WalletDto wallet, Transaction transaction) {

        // Set the walletUuid of the transaction to the UUID of the wallet.
        transaction.setWalletUuid(wallet.getUuid());

        // Check if the transaction amount is positive.
        if(transaction.getAmount() <= 0) {
            // Return an error response with a message "Amount must be positive".
            return new ResponseDTO("Amount must be positive", "error");
        }

        // Check if the transaction type is a withdrawal.
        if (transaction.getType().equals("withdrawal")) {
            // Check if the wallet has sufficient balance.
            if (transaction.getAmount() <= wallet.getSolde()) {
                // Deduct the transaction amount from the wallet balance.
                wallet.setSolde(wallet.getSolde() - transaction.getAmount());
                // Save the transaction in the database.
                transactionRepository.save(transaction);
                // Return a success response with the updated wallet balance.
                return new ResponseDTO("Transaction executed successfully", wallet,"success");
            }
            else {
                // Return an error response with a message "Insufficient balance".
                return new ResponseDTO("Insufficient balance", "error");
            }
        }
        // Check if the transaction type is a deposit.
        else if (transaction.getType().equals("deposit")) {
            // Add the transaction amount to the wallet balance.
            wallet.setSolde(wallet.getSolde() + transaction.getAmount());
            // Save the transaction in the database.
            transactionRepository.save(transaction);
            // Return a success response with the updated wallet balance.
            return new ResponseDTO("Transaction executed successfully", wallet,"success");
        }
        else {
            // Return an error response with a message "Invalid transaction type".
            return new ResponseDTO("Invalid transaction type", "error");
        }
    }

    /**
     * Method to delete a transaction.
     * @param id is the id of the transaction to be deleted.
     */
    @Override
    public void deleteTransaction(String id) {
        // Delete the transaction from the database using the id.
        transactionRepository.deleteById(id);
    }
    /**
     * Method to retrieve a wallet all transaction.
     * @param walletId is the id of the transaction to be deleted.
     * @return a list of transactions.
     */
    @Override
    public List<Transaction> getTransactionsByWalletId(UUID walletId) {
        return transactionRepository.findAllByWalletUUID(walletId);
    }
}
