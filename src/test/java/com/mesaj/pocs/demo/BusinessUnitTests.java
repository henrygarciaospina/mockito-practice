package com.mesaj.pocs.demo;

import com.mesaj.pocs.demo.controllers.UserController;
import com.mesaj.pocs.demo.model.User;
import com.mesaj.pocs.demo.model.thirdparty.ThirdPartyUser;
import com.mesaj.pocs.demo.repositories.UserRepository;
import com.mesaj.pocs.demo.services.ThirdPartyService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BusinessUnitTests {

    @Mock
    private ThirdPartyService thirdPartyService;

    @Mock
    private UserController userController;

    @Mock
    private UserRepository userRepository;



    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenUserIsAnAdultShouldBeRegistered(){
        Long userId = 123L;
        String name = "Pepito";
        String lastName = "Pérez";

        ThirdPartyUser mockedUser = ThirdPartyUser
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .isAlive(true)
                .maritalStatus("single")
                .birthday(LocalDate.of(2000, Month.JANUARY, 1))
                .build();

        Mockito.when(thirdPartyService.getThirdPartyUser(userId))
                .thenReturn(mockedUser);

        User userToRegister = User
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .id(userId)
                .username("123456")
                .build();

        userController.save(userToRegister);

        verify(userRepository, times(1))
                .save(userToRegister);
    }

    @Test
    public void givenUserIsAChildlShouldNotBeRegistered(){
        Long userId = 123L;
        String name = "Pepito";
        String lastName = "Pérez";

        ThirdPartyUser mockedUser = ThirdPartyUser
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .isAlive(true)
                .maritalStatus("single")
                .birthday(LocalDate.of(2005, Month.JANUARY, 1))
                .build();

        Mockito.when(thirdPartyService.getThirdPartyUser(userId))
                .thenReturn(mockedUser);

        User userToRegister = User
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .id(userId)
                .username("123456")
                .build();

        userController.save(userToRegister);

        verify(userRepository, times(0))
                .save(userToRegister);
    }

    @Test
    public void givenUserIsAnAdultButIsDeadShouldNotBeRegistered(){
        Long userId = 123L;
        String name = "Pepito";
        String lastName = "Pérez";

        ThirdPartyUser mockedUser = ThirdPartyUser
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .isAlive(false)
                .maritalStatus("single")
                .birthday(LocalDate.of(2005, Month.JANUARY, 1))
                .build();

        Mockito.when(thirdPartyService.getThirdPartyUser(userId))
                .thenReturn(mockedUser);

        User userToRegister = User
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .id(userId)
                .username("123456")
                .build();

        userController.save(userToRegister);

        verify(userRepository, times(1))
                .save(userToRegister);
    }
}