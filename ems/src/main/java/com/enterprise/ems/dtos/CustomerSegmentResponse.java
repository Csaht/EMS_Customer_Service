package com.enterprise.ems.dtos;

public class CustomerSegmentResponse {
    private String remarks;
    private String businessMapping;

    public  CustomerSegmentResponse(String remarks,String businessMapping ){
        this.remarks=remarks ;
        this.businessMapping=businessMapping ;
    }



    public String getRemarks(){return  remarks;}
    public void  setRemarks(String remarks){this.remarks = remarks;}


    public  String getBusinessMapping(){  return  businessMapping ; }
    public  void setBusinessMapping(String businessMapping){ this.businessMapping = businessMapping;}

}









