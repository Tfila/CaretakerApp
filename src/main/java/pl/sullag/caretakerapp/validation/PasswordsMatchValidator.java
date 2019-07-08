package pl.sullag.caretakerapp.validation;

import pl.sullag.caretakerapp.UserDTO;
import pl.sullag.caretakerapp.validation.PasswordsMatchConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatchConstraint, UserDTO> {
   public void initialize(PasswordsMatchConstraint constraint) {
   }

   public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {

      return  userDTO.getPassword().equals(userDTO.getRepeatPassword());

   }
}
