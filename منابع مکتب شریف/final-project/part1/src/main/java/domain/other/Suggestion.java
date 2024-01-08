package domain.other;

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
public class Suggestion extends BaseEntity<Integer> {

    LocalDate timeOfSendSuggestion;

    Double suggestionPrice;

    LocalDate timeOfStartingWork;

    LocalDate durationTimeOfWork;


}
