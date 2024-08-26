package be.bstorm.tf_java_2024_demospringmvc.models;

import lombok.*;

@Getter
@ToString @EqualsAndHashCode
public class User {
    private static Long nextId = 1L;

    private User(){
        this.id = nextId++;
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    private Long id;
    @Setter
    private String username;
    @Setter
    private String password;
}
