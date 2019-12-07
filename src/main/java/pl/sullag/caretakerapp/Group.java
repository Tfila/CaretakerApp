package pl.sullag.caretakerapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(name="group_id")
    private Long id;

    @OneToMany(mappedBy = "assignedGroup")
    private Set<User> users = new HashSet<>();


}
