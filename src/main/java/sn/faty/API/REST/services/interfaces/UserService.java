package sn.faty.API.REST.services.interfaces;

import sn.faty.API.REST.entity.User;
import sn.faty.API.REST.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO addUser(UserDTO user) ;

    UserDTO getUserById(Long id) ;

    List<UserDTO> getAllUsers() ;

    UserDTO updateUsers(User user) ;

    void deleteUser(Long id) ;
}
