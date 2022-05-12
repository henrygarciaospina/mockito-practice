package com.mesaj.pocs.demo.services;

import com.mesaj.pocs.demo.model.thirdparty.ThirdPartyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyService {

    @Autowired
    RestTemplate restTemplate;
    public ThirdPartyUser getThirdPartyUser(Long id) {
        ResponseEntity<ThirdPartyUser> resp =
                restTemplate.getForEntity( "http://localhost:8080/users/" + id, ThirdPartyUser.class);

                return  resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }

}
