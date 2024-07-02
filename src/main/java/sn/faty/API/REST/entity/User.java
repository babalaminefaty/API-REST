package sn.faty.API.REST.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long id ;
    private  String firstName ;
    private  String lastName;
    @Column(nullable = false, unique = true)
    private  String email ;
}
