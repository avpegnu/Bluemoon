package com.bluemoon.service;

import com.bluemoon.bean.ThuPhiChungCuTK;
import com.bluemoon.bean.ThuPhiTienIchTK;
import com.bluemoon.bean.ThuPhiXeTK;
import com.bluemoon.dao.ThongKeDAO;
import com.bluemoon.dao.ThongKeDAOImpl;
import java.util.List;

public class ThongKeServiceImpl implements ThongKeService {
    private ThongKeDAO thongKeDAO = null;
        
    public ThongKeServiceImpl() {
        this.thongKeDAO = new ThongKeDAOImpl();
    }
    
    @Override
    public List<ThuPhiChungCuTK> getListByThuPhiChungCu() {
        return thongKeDAO.getListByThuPhiChungCu();
    }

    @Override
    public List<ThuPhiXeTK> getListByThuPhiXe() {
        return thongKeDAO.getListByThuPhiXe();
    }

    @Override
    public List<ThuPhiTienIchTK> getListByThuPhiTienIch() {
        return thongKeDAO.getListByThuPhiTienIch();
    }
    
}
