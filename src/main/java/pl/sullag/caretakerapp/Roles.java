package pl.sullag.caretakerapp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="role")
public enum Roles {
    ADMIN,
    USER;
}
