package com.mesaj.pocs.demo.controllers;

import com.mesaj.pocs.demo.businnesslogic.ValidateUser;
import com.mesaj.pocs.demo.repositories.UserRepository;
import com.mesaj.pocs.demo.services.ThirdPartyService;
import com.mesaj.pocs.demo.model.User;
import com.mesaj.pocs.demo.model.thirdparty.ThirdPartyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ThirdPartyService thirdPartyService;

    @PostMapping("/users")
    public void save(@RequestBody User user) {
        ThirdPartyUser thirdPartyUser = thirdPartyService.getThirdPartyUser(user.getId());

        ValidateUser validateUser = new ValidateUser(thirdPartyUser);

        if(validateUser.isAlive() && validateUser.isAndAdult()){
            repository.save(user);
        }
    }
}
