package pl.sullag.caretakerapp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserForm {

    @NotNull
    @Size(min=2, max=20)
    private String firstName;

    @NotNull
    @Size(min=2, max=20)
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    @ValidPassword
    private String repeatPassword;

    private Roles role;
    private Group assignedGroupId;
}
