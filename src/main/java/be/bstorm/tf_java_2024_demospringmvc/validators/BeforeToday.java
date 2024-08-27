package be.bstorm.tf_java_2024_demospringmvc.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = BeforeTodayValidator.class)
public @interface BeforeToday {

    String message() default "Date must be before today";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
