package domain.userEntity;

import base.domin.BaseEntity;
import domain.enumurations.ExpertStatus;
import domain.other.Comments;
import domain.other.Wallet;
import domain.serviceEntity.SubService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Expert extends BaseEntity<Integer> {

    String firstName;
    String lastName;
    String email;
    String userName;
    String password;
    LocalDate dateOfSigningIn;

    byte[] personalPhoto;
    Integer stars;
    @OneToMany(mappedBy = "expert")
    List<SubService> subServiceList;

    @Enumerated(value = EnumType.STRING)
    ExpertStatus expertStatus;

    @OneToOne
    Wallet wallet;

    @OneToOne
    Comments comments;

    @ManyToOne
    Admin admin;

    public Expert(String firstName, String lastName, String email, String userName, String password,
                  LocalDate dateOfSigningIn, byte[] personalPhoto, Integer stars, ExpertStatus expertStatus) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.dateOfSigningIn = dateOfSigningIn;
        this.personalPhoto = personalPhoto;
        this.stars = stars;
        this.expertStatus = expertStatus;
    }

    public Expert(String firstName, String lastName, String email,
                  String userName, String password, LocalDate dateOfSigningIn, byte[] personalPhoto) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.dateOfSigningIn = dateOfSigningIn;
        this.personalPhoto = personalPhoto;
    }
}
