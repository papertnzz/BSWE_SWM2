package io.muehlbachler.bswe.service.model.geocoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class GeocodingResultEntryTest {
  @Test
  void testNoArgsConstructor() {
    GeocodingResultEntry entry = new GeocodingResultEntry();

    assertNotNull(entry);
    assertEquals(0.0, entry.getLongitude(), 0.001);
    assertEquals(0.0, entry.getLatitude(), 0.001);
    assertEquals(0.0f, entry.getElevation(), 0.001);
  }

  @Test
  void testAllArgsConstructor() {
    double longitude = 16.363449;
    double latitude = 48.210033;
    float elevation = 151.5f;

    GeocodingResultEntry entry = new GeocodingResultEntry(longitude, latitude, elevation);

    assertNotNull(entry);
    assertEquals(longitude, entry.getLongitude(), 0.000001);
    assertEquals(latitude, entry.getLatitude(), 0.000001);
    assertEquals(elevation, entry.getElevation(), 0.001);
  }

  // TODO: add more tests
}
