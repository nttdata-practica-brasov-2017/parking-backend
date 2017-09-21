package ro.nttdata.bv.parking.validation;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class UserValidator implements ConstraintValidator<AuthUser, String> {

   public String getCurrentlyAuthenticatedUser() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String currentPrincipalName = authentication.getName();
       return currentPrincipalName;
   }

    @Override
    public void initialize(AuthUser authUser) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName.equals(username);
    }
}
