package com.bluemoon.service;

import com.bluemoon.model.TaiKhoan;
import java.util.List;

public interface TaiKhoanService {
    public TaiKhoan login(String tenDangNhap, String matKhau);
    
    public List<TaiKhoan> getList();
    public int CreateOrUpdate(TaiKhoan taiKhoan);
    public int Remove(TaiKhoan taiKhoan);
}
