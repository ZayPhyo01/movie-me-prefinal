package com.example.zay_phyo.movieme.mvp.model;

public class ProductionCompany extends BaseModel{





    private String logo_path;

    private String name;


    public String getLogo_path ()
    {
        return logo_path;
    }

    public void setLogo_path (String logo_path)
    {
        this.logo_path = logo_path;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
}
