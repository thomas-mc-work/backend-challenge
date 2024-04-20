package org.floss.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class License {

    public boolean domain_content;
    public boolean domain_data;
    public boolean domain_software;
    public String family;
    public String id;
    public boolean is_generic;
    public String maintainer;
    public String od_conformance;
    public String osd_conformance;
    public String status;
    public String title;
    public String url;
    public boolean is_okd_compliant;
    public boolean is_osi_compliant;

}
