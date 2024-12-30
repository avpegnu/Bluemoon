package com.bluemoon.service;

import com.bluemoon.dao.DichVuDAO;
import com.bluemoon.dao.DichVuDAOImpl;
import com.bluemoon.model.DichVu;
import java.util.List;

public class DichVuServiceImpl implements DichVuService {
    private DichVuDAO dichVuDAO = null;

    public DichVuServiceImpl() {
        this.dichVuDAO = new DichVuDAOImpl();
    }
    @Override
    public List<DichVu> getList() {
        return dichVuDAO.getList();
    }

    @Override
    public String CreateOrUpdate(DichVu dichVu) {
        return dichVuDAO.CreateOrUpdate(dichVu);
    }

    @Override
    public String Remove(DichVu dichVu) {
        return dichVuDAO.Remove(dichVu);
    }
    
}
