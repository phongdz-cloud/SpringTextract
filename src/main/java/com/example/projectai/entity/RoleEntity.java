package com.example.projectai.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Role")
public class RoleEntity {

  @Id
  private String id;
  @Indexed(unique = true)
  @Field(value = "name")
  @NotNull(message = "Role name must not null")
  @Size(min = 2, max = 15)
  private String name;

}
