package pl.sullag.caretakerapp;

import javax.persistence.Table;


@Table(name="role")
public enum Roles {
    ADMIN,
    USER;
}
