package bios.springframework.spring5webapp.dao;

import bios.springframework.spring5webapp.model.Users;
import bios.springframework.spring5webapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersDAO {

    @Autowired
    UsersRepository usersRepository;


    public Users save(Users users){
        return usersRepository.save(users);
    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users findById(Long usersid){
        return usersRepository.findById(usersid).get();
    }

    public void delete(Users users){
        usersRepository.delete(users);
    }
}
