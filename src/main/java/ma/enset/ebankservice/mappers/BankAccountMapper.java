package ma.enset.ebankservice.mappers;

import ma.enset.ebankservice.dto.BankAccountRequestDTO;
import ma.enset.ebankservice.dto.BankAccountResponseDTO;
import ma.enset.ebankservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class BankAccountMapper {

    public BankAccount fromRequestDTOToBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount account =  new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO,account);
//        account.setAccountType(bankAccountRequestDTO.getAccountType());

        return account;
    }

    public BankAccountResponseDTO fromBankAccountToResponseDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return  bankAccountResponseDTO;
    }
}
