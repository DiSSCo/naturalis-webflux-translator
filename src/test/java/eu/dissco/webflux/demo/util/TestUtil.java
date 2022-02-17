package eu.dissco.webflux.demo.util;

import eu.dissco.webflux.demo.domain.Authoritative;
import eu.dissco.webflux.demo.domain.Image;
import eu.dissco.webflux.demo.domain.OpenDSWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.core.io.ClassPathResource;

public class TestUtil {

  public static final String INSTITUTION_NAME = "Naturalis Biodiversity Center";
  public static final String ROR_INSTITUTION = "https://ror.org/0566bfb96";
  public static final String OCCURRENCE_ID = "https://data.biodiversitydata.nl/naturalis/specimen/L.3892015";
  public static final String ID = "L.3892015@BRAHMS";
  public static final String BASIS_OF_RECORD = "Herbarium sheet";
  public static final String SCIENTIFIC_NAME = "Argyrolobium zanonii (Turra) P.W.Ball";
  public static final String IMAGE_URI = "https://medialib.naturalis.nl/file/id/L.3892015/format/large";

  public static String loadResourceFile(String fileName) throws IOException {
    return new String(new ClassPathResource(fileName).getInputStream()
        .readAllBytes(), StandardCharsets.UTF_8);
  }

  public static OpenDSWrapper testOpenDSWrapper() {
    return OpenDSWrapper.builder().authoritative(testAuthoritative()).images(List.of(testImage()))
        .sourceId("translator-service").build();
  }

  public static Authoritative testAuthoritative() {
    return Authoritative.builder()
        .midslevel(1)
        .curatedObjectID(OCCURRENCE_ID)
        .physicalSpecimenId(ID)
        .institutionCode(INSTITUTION_NAME)
        .institution(ROR_INSTITUTION)
        .materialType(BASIS_OF_RECORD)
        .name(SCIENTIFIC_NAME)
        .build();
  }

  public static Image testImage() {
    return Image.builder()
        .imageUri(IMAGE_URI)
        .build();
  }

}
