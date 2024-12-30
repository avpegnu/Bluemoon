package com.bluemoon.dao;

import com.bluemoon.bean.ThuPhiChungCuTK;
import com.bluemoon.bean.ThuPhiTienIchTK;
import com.bluemoon.bean.ThuPhiXeTK;
import java.util.List;

public interface ThongKeDAO {
    
    public List<ThuPhiChungCuTK> getListByThuPhiChungCu();
    public List<ThuPhiXeTK> getListByThuPhiXe();
    public List<ThuPhiTienIchTK> getListByThuPhiTienIch();
    
    
}
