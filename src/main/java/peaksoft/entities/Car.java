package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String marke;
    private int  price;
    private LocalDate dateOfMade;
    private String driver;
    private String typ;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private AutoSalon autoSalon;

}
