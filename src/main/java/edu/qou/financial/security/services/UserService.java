package edu.qou.financial.security.services;


import edu.qou.financial.security.payloads.UserDTO;
import edu.qou.financial.security.payloads.UserResponse;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    UserDTO getUserById(Long userId);

    UserDTO getUserByEmail(String email);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    String deleteUser(Long userId);
}
