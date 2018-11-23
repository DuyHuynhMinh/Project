package com.ca.message;

public class Source {
    private String host;
    private long port;
    private String version;
    private String vendor;
    private String name;
    private String componentid;
    private Tenant tenant;
    private Resource resource;
    private int deltatime;

    public String getHost()
    {
        return host;
    }

    public void setHost( String host )
    {
        this.host = host;
    }

    public long getPort()
    {
        return port;
    }

    public void setPort( long port )
    {
        this.port = port;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion( String version )
    {
        this.version = version;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor( String vendor )
    {
        this.vendor = vendor;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Tenant getTenant()
    {
        return tenant;
    }

    public void setTenant( Tenant tenant )
    {
        this.tenant = tenant;
    }

    public Resource getResource()
    {
        return resource;
    }

    public void setResource( Resource resource )
    {
        this.resource = resource;
    }

    public int getDeltatime()
    {
        return deltatime;
    }

    public void setDeltatime( int deltatime )
    {
        this.deltatime = deltatime;
    }

    public String getComponentid()
    {
        return componentid;
    }

    public void setComponentid( String componentid )
    {
        this.componentid = componentid;
    }

}
