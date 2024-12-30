package com.bluemoon.dao;

import com.bluemoon.model.NhanKhau;
import java.util.List;

public interface NhanKhauDAO {
    public List<NhanKhau> getList();
    
    public String CreateOrUpdate(NhanKhau nhanKhau);
    public String Remove(NhanKhau nhanKhau);
    public int getCount();
}
