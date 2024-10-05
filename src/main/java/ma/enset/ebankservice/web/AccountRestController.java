package ma.enset.ebankservice.web;


import lombok.AllArgsConstructor;
import ma.enset.ebankservice.dto.BankAccountRequestDTO;
import ma.enset.ebankservice.dto.BankAccountResponseDTO;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.enums.AccountType;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import ma.enset.ebankservice.service.AccountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountServiceImpl accountService;
    @GetMapping("/accounts/{accountNumber}")
    public BankAccount getAccount(@PathVariable String accountNumber) {
       return bankAccountRepository.findByAccountNumber(accountNumber);
    }
    @GetMapping("/accounts")
    public List<BankAccount> getAccounts() {
        return bankAccountRepository.findAll();
    }


    @PostMapping("/BankAccounts")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO requestDTO){

        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/BankAccounts/{accountNumber}")
    public BankAccount updateAccount(@PathVariable String accountNumber, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getCreationDate()!=null) account.setCreationDate(bankAccount.getCreationDate());
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("/BankAccounts/{accountNumber}")
    public void deleteAccount(@PathVariable String accountNumber){
        bankAccountRepository.deleteById(accountNumber);
    }

}
