package gn.boulet.springsecuritylatest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String email;
    private String password;
    private String roles;
}
