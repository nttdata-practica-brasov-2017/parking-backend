package ro.nttdata.bv.parking.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

public class FutureDateValidator implements ConstraintValidator<FutureDate, Date> {
    public final void initialize(final FutureDate annotation) {}

    public final boolean isValid(final Date value,
                                 final ConstraintValidatorContext context) {
        if(value == null) {
            return true;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return value.compareTo(calendar.getTime()) >= 0;
        }
    }
}
