package com.example.zay_phyo.movieme.event;

import com.example.zay_phyo.movieme.data.DetailConvector;

public class detailevent {

    DetailConvector detailConvector;

    boolean success;

    public detailevent() {

    }

    public DetailConvector getDetailConvector() {
        return detailConvector;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setDetailConvector(DetailConvector detailConvector)
    {this.detailConvector=detailConvector;}

    public void setSuccess(boolean success)
    {
        this.success=success;
    }

}
