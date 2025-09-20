package io.muehlbachler.bswe.service;

import java.util.List;

import io.muehlbachler.bswe.error.ApiException;
import io.muehlbachler.bswe.model.User;

public interface UserService {
  boolean exists(String userId);

  List<User> list();

  User save(User user) throws ApiException;

  boolean delete(String userId);
}
