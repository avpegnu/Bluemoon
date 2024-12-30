package com.bluemoon.service;

import com.bluemoon.dao.ThuPhiDAO;
import com.bluemoon.dao.ThuPhiDAOImpl;
import com.bluemoon.model.ThuPhi;
import java.util.List;

public class ThuPhiServiceImpl implements ThuPhiService {
    private ThuPhiDAO thuPhiDAO = null;

    public ThuPhiServiceImpl() {
        this.thuPhiDAO = new ThuPhiDAOImpl();
    }
    @Override
    public List<ThuPhi> getList1() {
        return thuPhiDAO.getList1();
    }
    @Override
    public List<ThuPhi> getList2() {
        return thuPhiDAO.getList2();
    }
    @Override
    public List<ThuPhi> getList3() {
        return thuPhiDAO.getList3();
    }
    @Override
    public String CreateOrUpdate(ThuPhi thuPhi){
        return thuPhiDAO.CreateOrUpdate(thuPhi);
    }
    
    @Override
    public String Remove(ThuPhi thuPhi){
        return thuPhiDAO.Remove(thuPhi);
    }
    
}
