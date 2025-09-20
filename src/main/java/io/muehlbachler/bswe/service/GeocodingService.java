package io.muehlbachler.bswe.service;

import io.muehlbachler.bswe.model.Coordinates;

@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface GeocodingService {
  Coordinates fetchCoordinates(String location);
}
