package domain.userEntity;

import base.domin.BaseEntity;
import domain.enumurations.ExpertStatus;
import domain.other.Comments;
import domain.other.Wallet;
import domain.serviceEntity.SubService;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Expert extends BaseEntity<Integer> {

    String firstName;
    String lastName;
    String email;
    String userName;
    String password;
    LocalDate dateOfSigningIn;

    File file;
    Integer stars;
    @OneToMany(mappedBy = "expert")
    List<SubService> subServiceList;

    @Enumerated(value = EnumType.STRING)
    ExpertStatus expertStatus;

    @OneToOne
    Wallet wallet;

    @OneToOne
    Comments comments;
}
