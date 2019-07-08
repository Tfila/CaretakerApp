package pl.sullag.caretakerapp;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @ManyToOne
    private Group assignedGroupId;


}
