package com.m2.transactionsmanagement.rest;

import com.m2.transactionsmanagement.DTO.ResponseDTO;
import com.m2.transactionsmanagement.models.Wallet;
import com.m2.transactionsmanagement.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/wallets")
public class WalletController{
    WalletService walletService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<ResponseDTO> createWallet(@PathVariable Long userId) {
        return ResponseEntity.ok(new ResponseDTO("Wallet created successfully", walletService.createWallet(userId), "success"));
    }
    @PutMapping("/update/{uuid}/{solde}")
    public ResponseEntity<ResponseDTO> updateWallet(@PathVariable String uuid, @PathVariable Integer solde) {
        return ResponseEntity.ok(new ResponseDTO("Wallet updated successfully", walletService.updateWallet(UUID.fromString(uuid), solde), "success"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getWallet(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDTO("Wallet retrieved successfully", walletService.getWalletByUserId(id), "success"));
    }
    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<ResponseDTO> getWalletByUuid(@PathVariable String uuid) {
        return ResponseEntity.ok(new ResponseDTO("Wallet retrieved successfully", walletService.getWalletByUuid(uuid), "success"));
    }
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllWallets() {
        return ResponseEntity.ok(new ResponseDTO("Wallets retrieved successfully", walletService.getAllWallets(), "success"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return ResponseEntity.ok(new ResponseDTO("Wallet deleted successfully", null, "success"));
    }
}
