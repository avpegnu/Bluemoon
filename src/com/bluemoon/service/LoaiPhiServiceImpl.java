package com.bluemoon.service;

import com.bluemoon.dao.LoaiPhiDAO;
import com.bluemoon.dao.LoaiPhiDAOImpl;
import com.bluemoon.model.LoaiPhi;
import java.util.List;

public class LoaiPhiServiceImpl implements LoaiPhiService {
    private LoaiPhiDAO loaiPhiDAO = null;

    public LoaiPhiServiceImpl() {
        this.loaiPhiDAO = new LoaiPhiDAOImpl();
    }
    
    @Override
    public List<LoaiPhi> getList1() {
        return loaiPhiDAO.getList1();
    }

    @Override
    public List<LoaiPhi> getList2() {
        return loaiPhiDAO.getList2();
    }

    @Override
    public List<LoaiPhi> getList3() {
        return loaiPhiDAO.getList3();
    }

    @Override
    public int getCount() {
        return loaiPhiDAO.getCount();
    }
}
