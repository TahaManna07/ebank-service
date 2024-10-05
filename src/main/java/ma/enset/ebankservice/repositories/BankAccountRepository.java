package ma.enset.ebankservice.repositories;

import ma.enset.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    BankAccount findByAccountNumber(String accountNumber);
}
