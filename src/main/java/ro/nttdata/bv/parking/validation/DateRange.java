package ro.nttdata.bv.parking.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy=DateRangeValidator.class)
@Documented
public @interface DateRange {
    String message() default "End date must be after start date";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
