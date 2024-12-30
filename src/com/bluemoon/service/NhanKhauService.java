package com.bluemoon.service;

import com.bluemoon.model.NhanKhau;
import java.util.List;

public interface NhanKhauService {
    public List<NhanKhau> getList();
    
    public String CreateOrUpdate(NhanKhau nhanKhau);
    public String Remove(NhanKhau nhanKhau);
    public int getCount();
}
