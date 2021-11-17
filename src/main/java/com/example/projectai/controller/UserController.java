package com.example.projectai.controller;

import com.example.projectai.config.FirebaseConfig;
import com.example.projectai.dto.UserDTO;
import com.example.projectai.exception.RecordNotFoundException;
import com.example.projectai.manager.IUserManagerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private IUserManagerService userManagerService;

  @GetMapping("/user")
  public ResponseEntity<List<UserDTO>> findAllUser() {
    List<UserDTO> userDTOS = userManagerService.findAllUserDTO();
    if (userDTOS.size() == 0) {
      throw new RecordNotFoundException("Not User!");
    }
    return ResponseEntity.ok(userDTOS);
  }

  @PostMapping("/user")
  public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
    UserDTO user = userManagerService.save(userDTO);
    if (user == null) {
      throw new RecordNotFoundException("Create failed: " + user.getUsername());
    }

    return ResponseEntity.ok(user);
  }
}
