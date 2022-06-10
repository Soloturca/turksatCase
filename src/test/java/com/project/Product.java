package com.project;

public class Product {
    private String display_value;
    private String charge_aggr_key;
    private String jnl_line_id;
    private String service_id;
    private String point;
    private String point_id;
    private String jurisdiction;
    private String seqnum;
    private String content_id;

    public Product(String display_value, String charge_aggr_key, String jnl_line_id, String service_id, String point, String point_id, String jurisdiction, String seqnum, String content_id) {
        this.display_value = display_value;
        this.charge_aggr_key = charge_aggr_key;
        this.jnl_line_id = jnl_line_id;
        this.service_id = service_id;
        this.point = point;
        this.point_id = point_id;
        this.jurisdiction = jurisdiction;
        this.seqnum = seqnum;
        this.content_id = content_id;
    }
    public Product(){

    }




    public String getDisplay_value() {
        return display_value;
    }

    public void setDisplay_value(String display_value) {
        this.display_value = display_value;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }





    public String getCharge_aggr_key() {
        return charge_aggr_key;
    }

    public void setCharge_aggr_key(String charge_aggr_key) {
        this.charge_aggr_key = charge_aggr_key;
    }

    public String getJnl_line_id() {
        return jnl_line_id;
    }

    public void setJnl_line_id(String jnl_line_id) {
        this.jnl_line_id = jnl_line_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }


    public String getPoint_id() {
        return point_id;
    }

    public void setPoint_id(String point_id) {
        this.point_id = point_id;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getSeqnum() {
        return seqnum;
    }

    public void setSeqnum(String seqnum) {
        this.seqnum = seqnum;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }




}
