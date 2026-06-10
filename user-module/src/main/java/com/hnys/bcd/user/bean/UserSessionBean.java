package com.hnys.bcd.user.bean;

import com.hnys.bcd.user.dto.UserDTO;
import com.hnys.bcd.user.remote.UserRemote;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class UserSessionBean implements UserRemote {
    @Override
    public UserDTO getUser(Long id) {
        return new UserDTO();
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return new UserDTO();
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        return new UserDTO();
    }

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        return new UserDTO();
    }

    @Override
    public void deleteUser(Long id) {
        System.out.println("UserSessionBean.deleteUser");
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}
