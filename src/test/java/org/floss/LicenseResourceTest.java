package org.floss;

import java.util.Arrays;
import java.util.Map;
import org.floss.model.License;
import org.floss.model.LicenseBuilder;
import org.floss.model.LicenseResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LicenseResourceTest {

    @Mock
    CkanClient ckanClient;

    @InjectMocks
    LicenseResource instance;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLicensesByOkConformance() {
        final LicenseResponse response = new LicenseResponse();

        response.result = Arrays.asList(
                new LicenseBuilder().withOd_conformance("v1").build(),
                new LicenseBuilder().withOd_conformance("v1").build(),
                new LicenseBuilder().withOd_conformance("v2").build()
        );

        Mockito.when(ckanClient.getLicenses())
                .thenReturn(response);

        final int expResult = 2;
        final Map<String, Long> result = instance.licensesByOkConformance();

        assertEquals(expResult, result.get("v1"));
    }

}
