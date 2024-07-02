package sn.faty.API.REST.services.mapper;


import sn.faty.API.REST.entity.User;
import sn.faty.API.REST.services.dto.UserDTO;


public class UserMapper {

public static UserDTO toDto(User user){

    UserDTO userDTO= new UserDTO(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail() ) ;
     return  userDTO ;
}
    public static User toEntity(UserDTO userDTO){

        User user= new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail() ) ;

        return  user ;
    }



}
