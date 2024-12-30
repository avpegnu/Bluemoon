package com.bluemoon.model;

import java.io.Serializable;
import java.util.Date;

public class ThuPhi implements Serializable {
    private String ma_thu;
    private String ma_phi;
    private String ma_hogd;
    private String ma_nhan_khau;
    private Date ngay_thu;
    private int so_tien;
    private String ten_phi;

    public String getMa_thu() {
        return ma_thu;
    }

    public void setMa_thu(String ma_thu) {
        this.ma_thu = ma_thu;
    }

    public String getMa_phi() {
        return ma_phi;
    }

    public void setMa_phi(String ma_phi) {
        this.ma_phi = ma_phi;
    }

    public String getMa_hogd() {
        return ma_hogd;
    }

    public void setMa_hogd(String ma_hogd) {
        this.ma_hogd = ma_hogd;
    }

    public String getMa_nhan_khau() {
        return ma_nhan_khau;
    }

    public void setMa_nhan_khau(String ma_nhan_khau) {
        this.ma_nhan_khau = ma_nhan_khau;
    }

    public Date getNgay_thu() {
        return ngay_thu;
    }

    public void setNgay_thu(Date ngay_thu) {
        this.ngay_thu = ngay_thu;
    }

    public int getSo_tien() {
        return so_tien;
    }

    public void setSo_tien(int so_tien) {
        this.so_tien = so_tien;
    }

    public String getTen_phi() {
        return ten_phi;
    }

    public void setTen_phi(String ten_phi) {
        this.ten_phi = ten_phi;
    } 
}
