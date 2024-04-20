package org.floss;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.floss.model.LicenseResponse;

@Path("/license")
public class LicenseResource {

    @RestClient
    CkanClient ckanClient;

    /**
     * Returns the number of licenses grouped by their OK conformance value.
     *
     * @return key: OD conformance status; value: amount of affected license
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> licensesByOkConformance() {

        final LicenseResponse licenseResponse = ckanClient.getLicenses();

        return licenseResponse.result.stream()
                .collect(groupingBy((l) -> l.od_conformance, counting()));
    }
}
