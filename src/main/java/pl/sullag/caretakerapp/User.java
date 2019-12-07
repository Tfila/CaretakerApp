package pl.sullag.caretakerapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column
    private String email;

    @Column(name="password")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column
    private Roles role;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group assignedGroup;

}
