package org.floss;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.floss.model.LicenseResponse;

@RegisterRestClient(configKey="ckan-api")
public interface CkanClient {

    /**
     * @see https://docs.ckan.org/en/2.9/api/index.html#ckan.logic.action.get.license_list
     * @return
     */
    @GET
    @Path("/license_list")
    LicenseResponse getLicenses();
}
