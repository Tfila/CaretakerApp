package pl.sullag.caretakerapp;

import lombok.Getter;
import lombok.Setter;
import pl.sullag.caretakerapp.validation.PasswordsMatchConstraint;
import pl.sullag.caretakerapp.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@PasswordsMatchConstraint(message = "passwords don't match")
public class UserDTO {

    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    private String repeatPassword;

    private Roles role;
    private Group assignedGroupId;
}
