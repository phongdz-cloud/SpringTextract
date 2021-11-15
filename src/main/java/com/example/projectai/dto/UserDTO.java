package com.example.projectai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

  private String id;
  private String username;
  private String password;
  private String email;
  private RoleDTO role;
}
