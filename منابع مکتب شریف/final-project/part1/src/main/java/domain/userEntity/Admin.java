package domain.userEntity;

import base.domin.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Admin extends BaseEntity<Integer> {
    String firstName;
    String lastName;
    String email;
    String userName;
    String password;
    LocalDate dateOfSigningIn;
}
