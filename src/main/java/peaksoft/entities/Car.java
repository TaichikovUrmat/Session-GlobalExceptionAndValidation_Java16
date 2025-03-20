package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     Long id;
     String marke;
     int  price;
     LocalDate dateOfMade;
     String driver;
     String typ;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private AutoSalon autoSalon;

}
