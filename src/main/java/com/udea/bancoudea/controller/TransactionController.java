package com.udea.bancoudea.controller;

import com.udea.bancoudea.DTO.TransactionDTO;
import com.udea.bancoudea.DTO.TransferRequestDTO;
import com.udea.bancoudea.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionFacade;

    public TransactionController(TransactionService transactionFacade) {
        this.transactionFacade = transactionFacade;
    }

    // Obtener transacciones de una cuenta
    @GetMapping("/{accountNumber}")
    public List<TransactionDTO> getTransactionsByAccountNumber(@PathVariable String accountNumber) {
        return transactionFacade.getTransactionsForAccount(accountNumber);
    }

    // Transferir dinero a partir de una transacción
    @PostMapping("/transfer")
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody TransferRequestDTO transferRequestDTO) {
        if(transferRequestDTO.getAmount() == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        return ResponseEntity.ok(transactionFacade.transferMoney(transferRequestDTO));
    }

}
