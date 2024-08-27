package be.bstorm.tf_java_2024_demospringmvc.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MustBeTheSameValidator.class)
public @interface MustBeTheSame {

    String message() default "mustBeTheSame";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field1() default "password";
    String field2() default "confirmPassword";
}
