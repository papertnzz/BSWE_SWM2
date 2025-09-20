package io.muehlbachler.bswe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CoordinatesTest {
  @Test
  void testDefaultConstructor() {
    Coordinates coordinates = new Coordinates();
    assertEquals(0.0, coordinates.getLongitude());
    assertEquals(0.0, coordinates.getLatitude());
    assertEquals(0.0f, coordinates.getElevation());
  }

  @Test
  void testParameterizedConstructor() {
    double longitude = 15.5;
    double latitude = 48.2;
    float elevation = 300.5f;

    Coordinates coordinates = new Coordinates(longitude, latitude, elevation);

    assertEquals(longitude, coordinates.getLongitude());
    assertEquals(latitude, coordinates.getLatitude());
    assertEquals(elevation, coordinates.getElevation());
  }

  // TODO: add more tests
}
