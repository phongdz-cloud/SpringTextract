package com.example.projectai.controller;

import com.example.projectai.dto.RoleDTO;
import com.example.projectai.exception.RecordNotFoundException;
import com.example.projectai.manager.IRoleManagerService;
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
public class RoleController {

  @Autowired
  private IRoleManagerService roleManagerService;

  @GetMapping("/role")
  public ResponseEntity<List<RoleDTO>> findAllRole() {
    List<RoleDTO> roleDTOS = roleManagerService.findAllRoleDTO();
    if (roleDTOS == null) {
      throw new RecordNotFoundException("Not Role!");
    }
    return ResponseEntity.ok(roleDTOS);
  }

  @PostMapping("/role")
  public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO) {
    RoleDTO role = roleManagerService.save(roleDTO);
    if (role == null) {
      throw new RecordNotFoundException("Create Role failed username: " + roleDTO.getName());
    }
    return ResponseEntity.ok(role);
  }
}
