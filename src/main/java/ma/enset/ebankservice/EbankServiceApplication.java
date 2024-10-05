package ma.enset.ebankservice;

import ma.enset.ebankservice.entities.BankAccount;
import ma.enset.ebankservice.entities.Customer;
import ma.enset.ebankservice.enums.AccountType;
import ma.enset.ebankservice.repositories.BankAccountRepository;
import ma.enset.ebankservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository accountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Taha","Souhail","Manna").forEach(c->{

                        Customer customer = Customer.builder()
                                .name(c)
                                .build();
                        customerRepository.save(customer);

                    });


        customerRepository.findAll().forEach(customer -> {
            BankAccount bankAccount = BankAccount.builder()
                    .accountNumber(UUID.randomUUID().toString())
                    .balance(679110.0)
                    .currency("USD")
                    .type(AccountType.CURRENT)
                    .creationDate(new Date())
                    .customer(customer)
                    .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .accountNumber(UUID.randomUUID().toString())
                    .balance(6800.1547)
                    .currency("DA")
                    .type(AccountType.SAVING)
                    .creationDate(new Date())
                    .customer(customer)
                    .build();
            BankAccount bankAccount3 = BankAccount.builder()
                    .accountNumber(UUID.randomUUID().toString())
                    .balance(6000.0)
                    .currency("USD")
                    .type(AccountType.CURRENT)
                    .creationDate(new Date())
                    .customer(customer)
                    .build();
            accountRepository.save(bankAccount);
            accountRepository.save(bankAccount2);
            accountRepository.save(bankAccount3);
        });





        };
    }


}
