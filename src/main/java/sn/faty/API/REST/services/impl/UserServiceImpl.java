package sn.faty.API.REST.services.impl;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.API.REST.entity.User;
import sn.faty.API.REST.exceptions.UtilisateurNotFoundException;
import sn.faty.API.REST.repository.UserRepository;
import sn.faty.API.REST.services.dto.UserDTO;
import sn.faty.API.REST.services.interfaces.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@NoArgsConstructor

public class UserServiceImpl implements UserService {

    private  UserRepository userRepository ;
    private ModelMapper modelMapper ;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper= modelMapper ;
    }

    /**
     * @param
     * @return
     */
    @Override
    public UserDTO addUser(UserDTO userDTO) {

       // User user= UserMapper.toEntity(userDTO) ;

        User user= modelMapper.map(userDTO,User.class) ;

        User user1= userRepository.save(user);

     //  UserDTO userDTO1= UserMapper.toDto(user1) ;

        UserDTO userDTO1= modelMapper.map(user, UserDTO.class);

        return  userDTO1 ;

    }

    /**
     * @param id
     * @return
     */
    @Override
    public UserDTO getUserById(Long id) {

        Optional<User> userOptional= userRepository.findById(id) ;

          if(userOptional.isEmpty()){

              throw new UtilisateurNotFoundException() ;
          }

     //   return UserMapper.toDto(userOptional.get()) ;

        return modelMapper.map(userOptional.get(),UserDTO.class) ;

      //
    }

    /**
     * @return
     */
    @Override
    public List<UserDTO> getAllUsers() {

    //  return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());

        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public UserDTO updateUsers(User user) {

        User existingUser= userRepository.findById(user.getId()).get();

          if(existingUser != null){

              existingUser.setFirstName(user.getFirstName());
              existingUser.setLastName(user.getLastName());
              existingUser.setEmail(user.getEmail());
              User user1=  userRepository.save(existingUser) ;
          //    return    UserMapper.toDto(user1) ;
              return    modelMapper.map(existingUser, UserDTO.class) ;

          //    return  user1 ;
          }
        return null;
    }

    /**
     * @param
     */
    @Override
    public void deleteUser(Long id) {

        userRepository.findById(id).orElseThrow( () -> new UtilisateurNotFoundException()) ;

           userRepository.deleteById(id);
    }

}
