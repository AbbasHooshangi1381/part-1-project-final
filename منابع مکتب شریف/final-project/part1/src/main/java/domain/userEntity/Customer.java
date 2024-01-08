package domain.userEntity;

import base.domin.BaseEntity;
import domain.other.Comments;
import domain.other.CustomerOrder;
import domain.other.Wallet;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
