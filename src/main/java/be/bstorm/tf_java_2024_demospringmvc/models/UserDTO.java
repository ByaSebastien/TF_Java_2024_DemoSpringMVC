package be.bstorm.tf_java_2024_demospringmvc.models;

public record UserDTO(
        Long id,
        String username
) {

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername());
    }
}
