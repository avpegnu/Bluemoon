package com.bluemoon.dao;


import com.bluemoon.model.ThuPhi;
import java.util.List;

public interface ThuPhiDAO {
    public List<ThuPhi> getList1();
    public List<ThuPhi> getList2();
    public List<ThuPhi> getList3();
    
    public String CreateOrUpdate(ThuPhi thuPhi);
    public String Remove(ThuPhi thuPhi);
}
