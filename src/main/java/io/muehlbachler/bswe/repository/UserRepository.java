package io.muehlbachler.bswe.repository;

import io.muehlbachler.bswe.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
