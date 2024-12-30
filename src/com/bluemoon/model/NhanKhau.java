package com.bluemoon.model;

import java.io.Serializable;
import java.sql.Date;

public class NhanKhau implements Serializable {
    //private int STT;
    private String ma_nhan_khau;
    private String so_cccd;
    private String ma_hogd;
    private String ho_ten;
    private java.sql.Date ngay_sinh;
    private boolean gioi_tinh;
    private String quan_he_chu_ho;
    private boolean tam_tru;


    public String getMa_nhan_khau() {
        return ma_nhan_khau;
    }

    public void setMa_nhan_khau(String ma_nhan_khau) {
        this.ma_nhan_khau = ma_nhan_khau;
    }

    public String getSo_cccd() {
        return so_cccd;
    }

    public void setSo_cccd(String so_cccd) {
        this.so_cccd = so_cccd;
    }

    public String getMa_hogd() {
        return ma_hogd;
    }

    public void setMa_hogd(String ma_hogd) {
        this.ma_hogd = ma_hogd;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public java.sql.Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(java.sql.Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }
    
    public String getQuan_he_chu_ho() {
        return quan_he_chu_ho;
    }

    public void setQuan_he_chu_ho(String quan_he_chu_ho) {
        this.quan_he_chu_ho = quan_he_chu_ho;
    }

    public boolean isTam_tru() {
        return tam_tru;
    }

    public void setTam_tru(boolean tam_tru) {
        this.tam_tru = tam_tru;
    }
    
    
}
