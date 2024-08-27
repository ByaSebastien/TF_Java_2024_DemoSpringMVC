package be.bstorm.tf_java_2024_demospringmvc.models;

import be.bstorm.tf_java_2024_demospringmvc.validators.BeforeToday;
import be.bstorm.tf_java_2024_demospringmvc.validators.MustBeTheSame;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@MustBeTheSame
public class UserRegisterForm {

    @NotBlank(message = "username cannot be blank")
    private String username;

    @NotBlank
    @Size(min = 5)
    private String password;

    private String confirmPassword;

    @NotNull
    @Range(min = 1, max = 300)
    private int size;

    @NotNull
    @BeforeToday
    private LocalDate birthdate;

    public User toUser(){
        return new User(username,password,size,birthdate);
    }
}
