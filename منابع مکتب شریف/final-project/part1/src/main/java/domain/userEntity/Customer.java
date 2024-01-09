package domain.userEntity;

import base.domin.BaseEntity;
import domain.other.Comments;
import domain.other.CustomerOrder;
import domain.other.Wallet;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends BaseEntity<Integer> {

    String firstName;
    String lastName;
    String email;
    String userName;
    String password;
    LocalDate dateOfSigningIn;

    @OneToMany(mappedBy = "customer")
    List<CustomerOrder> customerOrderList;

    @OneToOne
    Wallet wallet;

    @OneToOne
    Comments comments;

    @ManyToOne
    Admin admin;

    public Customer(String firstName, String lastName, String email, String userName, String password,
                    LocalDate dateOfSigningIn, List<CustomerOrder> customerOrderList, Wallet wallet, Comments comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password format!");
        } else {
            this.password = password;
        }
        this.dateOfSigningIn = dateOfSigningIn;
        // this.customerOrderList = customerOrderList;
        // this.wallet = wallet;
        //   this.comments = comments;
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
