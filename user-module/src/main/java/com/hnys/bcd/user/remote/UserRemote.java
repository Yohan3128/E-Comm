package com.hnys.bcd.user.remote;

import com.hnys.bcd.user.dto.UserDTO;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface UserRemote {
    UserDTO getUser(Long id);
    UserDTO getUserByEmail(String email);
    UserDTO createUser(UserDTO userDto);
    UserDTO updateUser(UserDTO userDto);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
}
