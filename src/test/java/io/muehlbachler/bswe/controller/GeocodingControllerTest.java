package io.muehlbachler.bswe.controller;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import io.muehlbachler.bswe.service.GeocodingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GeocodingControllerTest {
  private GeocodingController controller;

  @Mock
  private GeocodingService geocodingService;

  @BeforeEach
  public void setUp() {
    controller = new GeocodingController(geocodingService);

    reset(geocodingService);
  }

  @AfterEach
  public void tearDown() {
    verifyNoMoreInteractions(geocodingService);
  }

  // TODO: add more tests
}
