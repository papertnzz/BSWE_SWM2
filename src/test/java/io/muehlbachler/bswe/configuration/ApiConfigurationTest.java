package io.muehlbachler.bswe.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.muehlbachler.bswe.configuration.ApiConfiguration.ApiConnectionInformation;
import org.junit.jupiter.api.Test;

public class ApiConfigurationTest {
  @Test
  void testApiConnectionInformationNoArgsConstructor() {
    final ApiConnectionInformation info = new ApiConnectionInformation();
    assertNotNull(info);
  }

  @Test
  void testApiConnectionInformationAllArgsConstructor() {
    final ApiConnectionInformation info = new ApiConnectionInformation("url");

    assertNotNull(info);
    assertEquals("url", info.getUrl());
  }

  @Test
  void testApiConnectionInformationSetters() {
    final ApiConnectionInformation info = new ApiConnectionInformation();

    info.setUrl("url");

    assertEquals("url", info.getUrl());
  }
}
