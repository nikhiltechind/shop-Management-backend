package com.example.Shop.Management.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Shop-user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
@Id
@GeneratedValue
@Column(name = "id")
 private int userId;
 @Column(name = "username")
 private String username;
 @Column(name = "password1")
 private String password1;
 @Column(name = "password2")
 private String password2;
 @Column(name = "user_email")
 private String email;

}
