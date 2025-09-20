package io.muehlbachler.bswe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.UUID;

import io.muehlbachler.bswe.controller.dto.UserCreateDto;
import io.muehlbachler.bswe.controller.dto.UserListDto;
import io.muehlbachler.bswe.error.ApiException;
import io.muehlbachler.bswe.model.User;
import io.muehlbachler.bswe.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
  private UserController controller;

  private User user;

  @Mock
  private UserService userService;

  @BeforeEach
  public void setUp() {
    user = User.withId(UUID.randomUUID().toString());
    user.setUsername("username");

    controller = new UserController(userService);

    reset(userService);
  }

  @AfterEach
  public void tearDown() {
    verifyNoMoreInteractions(userService);
  }

  @Test
  public void testList() {
    when(userService.list()).thenReturn(Collections.singletonList(user));

    ResponseEntity<UserListDto> result = controller.list();
    assertEquals(HttpStatus.OK, result.getStatusCode());

    UserListDto results = result.getBody();
    assertNotNull(results);
    assertEquals(1, results.getUsers().size());
    assertEquals(user, results.getUsers().get(0));

    verify(userService, times(1)).list();
  }

  @Test
  public void testListEmpty() {
    when(userService.list()).thenReturn(Collections.emptyList());

    ResponseEntity<UserListDto> result = controller.list();
    assertEquals(HttpStatus.OK, result.getStatusCode());

    UserListDto results = result.getBody();
    assertNotNull(results);
    assertTrue(results.getUsers().isEmpty());

    verify(userService, times(1)).list();
  }

  @Test
  public void testListNull() {
    when(userService.list()).thenReturn(null);

    ResponseEntity<UserListDto> result = controller.list();
    assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    verify(userService, times(1)).list();
  }

  @Test
  public void testCreate() throws ApiException {
    UserCreateDto createDto = new UserCreateDto();
    createDto.setUsername("username");

    when(userService.save(new User())).thenReturn(user);

    ResponseEntity<User> result = controller.create(createDto);
    assertEquals(HttpStatus.CREATED, result.getStatusCode());
    assertEquals(user, result.getBody());

    verify(userService, times(1)).save(new User());
  }

  // TODO: add more tests
}
