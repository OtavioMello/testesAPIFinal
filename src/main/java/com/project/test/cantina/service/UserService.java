package com.project.test.cantina.service;

import com.project.test.cantina.dto.UserDTO;
import com.project.test.cantina.dto.UserFormDTO;
import com.project.test.cantina.entities.User;
import com.project.test.cantina.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO postUser(UserFormDTO userFormDTO) {
        User user = userRepository.save(modelMapper.map(userFormDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }


}
