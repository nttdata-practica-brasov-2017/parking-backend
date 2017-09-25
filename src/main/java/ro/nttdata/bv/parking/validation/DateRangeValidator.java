package ro.nttdata.bv.parking.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.Date;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class DateRangeValidator implements ConstraintValidator<DateRange, Object[]> {
    @Override
    public void initialize(DateRange dateRange) {

    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        if (objects.length != 3) {
            throw new IllegalArgumentException("Illegal method signature");
        }

        if (objects[1] == null || objects[2] == null) {
            return true;
        }

        if (!(objects[1] instanceof Date) || !(objects[2] instanceof Date)) {
            throw new IllegalArgumentException(
                    "Illegal method signature, expected two " +
                            "parameters of type Date."
            );
        }

        return ((Date) objects[1]).compareTo((Date) objects[2]) <= 0;
    }
}
