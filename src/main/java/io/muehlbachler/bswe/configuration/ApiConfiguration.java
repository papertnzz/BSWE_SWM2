package io.muehlbachler.bswe.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface ApiConfiguration {
  ApiConnectionInformation getGeocoding();

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  class ApiConnectionInformation {
    private String url;
  }
}
