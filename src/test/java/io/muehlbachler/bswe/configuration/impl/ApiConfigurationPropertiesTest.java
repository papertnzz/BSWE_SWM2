package io.muehlbachler.bswe.configuration.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.muehlbachler.bswe.configuration.ApiConfiguration.ApiConnectionInformation;
import org.junit.jupiter.api.Test;

public class ApiConfigurationPropertiesTest {
  @Test
  void testNoArgsConstructor() {
    final ApiConfigurationProperties config = new ApiConfigurationProperties();
    assertNotNull(config);
  }

  @Test
  void testAllArgsConstructor() {
    final ApiConnectionInformation geocoding = new ApiConnectionInformation("geo-url");

    final ApiConfigurationProperties config = new ApiConfigurationProperties(geocoding);

    assertNotNull(config);
    assertEquals(geocoding, config.getGeocoding());
  }

  @Test
  void testSetters() {
    final ApiConfigurationProperties config = new ApiConfigurationProperties();
    final ApiConnectionInformation geocoding = new ApiConnectionInformation("geo-url");

    config.setGeocoding(geocoding);

    assertEquals(geocoding, config.getGeocoding());
  }
}
