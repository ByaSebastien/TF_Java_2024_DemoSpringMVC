package be.bstorm.tf_java_2024_demospringmvc.models;

import lombok.*;

import java.time.LocalDate;

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

    public User(String username, String password,int size, LocalDate birthDate){
        this(username,password);
        this.size = size;
        this.birthDate = birthDate;
    }

    private Long id;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private int size;
    @Setter
    private LocalDate birthDate;
}
