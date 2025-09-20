package io.muehlbachler.bswe.controller.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UserListDtoTest {
  @Test
  void testNoArgsConstructor() {
    final UserListDto dto = new UserListDto();
    assertNotNull(dto);
  }

  // TODO: add more tests
}
