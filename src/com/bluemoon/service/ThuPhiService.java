package com.bluemoon.service;

import com.bluemoon.model.ThuPhi;
import java.util.List;

public interface ThuPhiService {
    public List<ThuPhi> getList1();
    public List<ThuPhi> getList2();
    public List<ThuPhi> getList3();
    
    public String CreateOrUpdate(ThuPhi thuPhi);
    public String Remove(ThuPhi thuPhi);
}
