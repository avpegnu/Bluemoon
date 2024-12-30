package com.bluemoon.model;

import java.io.Serializable;

public class LoaiPhi implements Serializable {
    
    private String ma_phi;
    private String ten_phi;
    private int tien_m2;
    private int tien_xe;
    private int tien_so;
    private int tong;

    public String getMa_phi() {
        return ma_phi;
    }

    public void setMa_phi(String ma_phi) {
        this.ma_phi = ma_phi;
    }

    public String getTen_phi() {
        return ten_phi;
    }

    public void setTen_phi(String ten_phi) {
        this.ten_phi = ten_phi;
    }

    public int getTien_m2() {
        return tien_m2;
    }

    public void setTien_m2(int tien_m2) {
        this.tien_m2 = tien_m2;
    }

    public int getTien_xe() {
        return tien_xe;
    }

    public void setTien_xe(int tien_xe) {
        this.tien_xe = tien_xe;
    }

    public int getTien_so() {
        return tien_so;
    }

    public void setTien_so(int tien_so) {
        this.tien_so = tien_so;
    } 

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }
    
    
}
