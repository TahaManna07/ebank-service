package ma.enset.ebankservice.service;

import lombok.AllArgsConstructor;
import ma.enset.ebankservice.dto.BankAccountRequestDTO;
import ma.enset.ebankservice.dto.BankAccountResponseDTO;
import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.mappers.BankAccountMapper;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository accountRepository;
    private  BankAccountMapper bankAccountMapper;




    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount account = bankAccountMapper.fromRequestDTOToBankAccount(bankAccountDTO);
        account.setAccountNumber(UUID.randomUUID().toString());
        account.setCreationDate(new Date());
        BankAccount savedBankAccount = accountRepository.save(account);

        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccountToResponseDTO(savedBankAccount);

        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount account = bankAccountMapper.fromRequestDTOToBankAccount(bankAccountDTO);
        account.setAccountNumber(id);
        account.setCreationDate(new Date());
        account.setCurrency(bankAccountDTO.getCurrency());
        account.setType(bankAccountDTO.getType());
        BankAccount savedBankAccount = accountRepository.save(account);

        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccountToResponseDTO(savedBankAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public void deleteAccount(String id) {
         accountRepository.deleteById(id);
    }


}
