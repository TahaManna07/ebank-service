package ma.enset.ebankservice.entities;


import jakarta.persistence.*;
import lombok.*;
import ma.enset.ebankservice.enums.AccountType;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount   {
    @Id
    private String accountNumber;
    private Date creationDate;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

}
