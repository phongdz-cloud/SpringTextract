package com.example.projectai.manager.Impl;

import com.example.projectai.dto.RoleDTO;
import com.example.projectai.dto.UserDTO;
import com.example.projectai.entity.RoleEntity;
import com.example.projectai.entity.UserEntity;
import com.example.projectai.manager.IUserManagerService;
import com.example.projectai.service.IUserService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserManagerServiceImpl implements IUserManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private IUserService userService;

  @Override
  public List<UserDTO> findAllUserDTO() {
    List<UserEntity> userEntities = userService.findAllUser();
    return userEntities
        .stream()
        .map(userEntity -> modelMapper.map(userEntities, UserDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public UserDTO save(UserDTO userDTO) {
    UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
    return modelMapper.map(userService.save(userEntity), UserDTO.class);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return userService.existsByEmail(email);
  }

  @Override
  public Boolean existsByUsername(String username) {
    return userService.existsByUsername(username);
  }
}
