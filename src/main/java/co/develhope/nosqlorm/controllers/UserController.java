package co.develhope.nosqlorm.controllers;

import co.develhope.nosqlorm.entity.User;
import co.develhope.nosqlorm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public void createUser(@RequestBody User user){
        user.setId(null);
        userRepository.save(user);
    }
    @GetMapping("{id}")
    public User getUser(@PathVariable String id)throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
        throw new  Exception("user not found");
        }

    }
    @PutMapping("{id}")
    public User editUser(@PathVariable String id, @RequestBody User user)throws Exception{
        if(!userRepository.existsById(id)) throw new Exception("user not found");
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }

}
