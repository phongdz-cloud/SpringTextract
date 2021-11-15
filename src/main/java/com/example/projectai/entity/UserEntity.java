package com.example.projectai.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class UserEntity {

  @Id
  private String id;
  @Indexed(unique = true)
  @Field(value = "username")
  @NotNull(message = "Username must be not null!")
  @Size(min = 6, max = 15)
  private String username;
  @Field(value = "password")
  @NotNull(message = "Password must be not null!")
  @Size(min = 6, max = 15)
  private String password;
  @Indexed(unique = true)
  @Field(value = "email")
  @NotNull(message = "Email must be not null!")
  @Email
  private String email;
  @Field(value = "role")
  private RoleEntity role;
}
