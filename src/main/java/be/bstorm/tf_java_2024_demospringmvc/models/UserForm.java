package be.bstorm.tf_java_2024_demospringmvc.models;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class UserForm {

    private String username;
    private String password;

    public User toUser(){
        return new User(this.username, this.password);
    }
}
