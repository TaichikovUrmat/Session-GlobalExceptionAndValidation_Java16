package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "auto_salon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AutoSalon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "autoSalon", fetch = FetchType.LAZY)
    private List<Car> cars;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User users;



}
