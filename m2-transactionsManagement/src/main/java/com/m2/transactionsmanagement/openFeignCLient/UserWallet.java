package com.m2.transactionsmanagement.openFeignCLient;

import com.m2.transactionsmanagement.DTO.ResponseDTO;
import com.m2.transactionsmanagement.models.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "WALLET-SERVICE", path = "/api/wallets")
public interface UserWallet {
    @GetMapping("/uuid/{uuid}")
    ResponseEntity<ResponseDTO> getWalletByUuid(@PathVariable String uuid) ;

    @PutMapping("/update/{uuid}/{solde}")
    ResponseEntity<ResponseDTO> updateWallet(@PathVariable String uuid, @PathVariable Integer solde);
}
