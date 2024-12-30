package com.bluemoon.service;

import com.bluemoon.dao.NhanKhauDAO;
import com.bluemoon.dao.NhanKhauDAOImpl;
import com.bluemoon.model.NhanKhau;
import java.util.List;

public class NhanKhauServiceImpl implements NhanKhauService {
    private NhanKhauDAO nhanKhauDAO = null;

    public NhanKhauServiceImpl() {
        this.nhanKhauDAO = new NhanKhauDAOImpl();
    }
    @Override
    public List<NhanKhau> getList() {
        return nhanKhauDAO.getList();
    }
    @Override
    public String CreateOrUpdate(NhanKhau nhanKhau){
        return nhanKhauDAO.CreateOrUpdate(nhanKhau);
    }
    
    @Override
    public String Remove(NhanKhau nhanKhau){
        return nhanKhauDAO.Remove(nhanKhau);
    }

    @Override
    public int getCount() {
        return nhanKhauDAO.getCount();
    }
    
    
}
