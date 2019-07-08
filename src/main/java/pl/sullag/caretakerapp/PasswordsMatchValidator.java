package pl.sullag.caretakerapp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatchConstraint, UserForm> {
   public void initialize(PasswordsMatchConstraint constraint) {
   }

   public boolean isValid(UserForm userForm, ConstraintValidatorContext context) {

      return  userForm.getPassword().equals(userForm.getRepeatPassword());

   }
}
