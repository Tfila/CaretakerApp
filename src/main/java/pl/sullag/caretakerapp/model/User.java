package pl.sullag.caretakerapp.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;

    private String firstName;

    private String lastName;

    @Column
    private String email;

    @Column(name="password")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @ManyToOne
    @JoinTable(name="group_users")
    private Group assignedGroup;

}
