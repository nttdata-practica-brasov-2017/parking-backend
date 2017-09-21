package ro.nttdata.bv.parking.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({ FIELD, METHOD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidator.class)
@Documented
public @interface AuthUser {
    String message() default "{AuthUser.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
