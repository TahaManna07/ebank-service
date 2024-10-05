package ma.enset.ebankservice.web;

import lombok.AllArgsConstructor;
import ma.enset.ebankservice.dto.BankAccountRequestDTO;
import ma.enset.ebankservice.dto.BankAccountResponseDTO;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import ma.enset.ebankservice.service.AccountService;
import ma.enset.ebankservice.service.AccountServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AccountGraphQlController {

    private BankAccountRepository accountRepository;
    private AccountService accountService;


    // la méthode doit contenir le meme nom du méthode dans le fichire schema.graphqls
    @QueryMapping
    public List<BankAccount> accounts() {
        return accountRepository.findAll();

    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
         accountService.deleteAccount(id);
         return true;
    }


}
