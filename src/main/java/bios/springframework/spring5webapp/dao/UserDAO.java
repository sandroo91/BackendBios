package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.User;
import bios.springframework.spring5webapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO {

    @Autowired
    UserRepository userRepository;


    public User save(User user){ return userRepository.save(user); }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long zaalid){
        return userRepository.findById(zaalid).get();
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
