package ma.enset.ebankservice.service;

import ma.enset.ebankservice.dto.BankAccountRequestDTO;
import ma.enset.ebankservice.dto.BankAccountResponseDTO;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO);
    public void deleteAccount(String id);

    }
