package io.muehlbachler.bswe.controller;

import java.util.List;

import io.muehlbachler.bswe.controller.dto.UserCreateDto;
import io.muehlbachler.bswe.controller.dto.UserListDto;
import io.muehlbachler.bswe.error.ApiException;
import io.muehlbachler.bswe.model.Coordinates;
import io.muehlbachler.bswe.model.User;
import io.muehlbachler.bswe.service.GeocodingService;
import io.muehlbachler.bswe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/geocoding")
@CrossOrigin
public class GeocodingController {
  @Autowired
  private final GeocodingService geocodingService;

  @GetMapping("/")
  public ResponseEntity<Coordinates> fetch(@RequestParam String location) {
    final Coordinates coordinates = geocodingService.fetchCoordinates(location);
    if (coordinates == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(coordinates, HttpStatus.OK);
  }
}
