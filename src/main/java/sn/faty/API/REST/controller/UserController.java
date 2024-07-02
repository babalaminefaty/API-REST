package sn.faty.API.REST.controller;

import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.faty.API.REST.entity.User;
import sn.faty.API.REST.services.dto.UserDTO;
import sn.faty.API.REST.services.interfaces.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class UserController {
    private UserService userService ;

    private  final Logger log= LoggerFactory.getLogger(UserController.class) ;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public  ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO){

        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long idUser){

          log.debug("identifiant**********", idUser);

          return new ResponseEntity<>(userService.getUserById(idUser),HttpStatus.FOUND);

    }

    @GetMapping("/allUsers")
  public   ResponseEntity<List<UserDTO>> getAllUsers(){

        List<UserDTO> users= userService.getAllUsers() ;

        return  ResponseEntity.ok().body(users);

    }


    @PutMapping("/updateUsers")
    public  ResponseEntity<UserDTO> updateUsers(@Valid @RequestBody  User user){

        UserDTO userUpdated= userService.updateUsers(user) ;

        return  ResponseEntity.ok().body(userUpdated);

    }

    @DeleteMapping("/deleteUsers/{id}")
    public  Void updateUsers(@PathVariable("id") Long id){

         userService.deleteUser(id); ;

        return null;
    }
}
