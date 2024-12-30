package com.bluemoon.dao;

import com.bluemoon.model.LoaiPhi;
import java.util.List;

public interface LoaiPhiDAO {
    public List<LoaiPhi> getList1();
    public List<LoaiPhi> getList2();
    public List<LoaiPhi> getList3();
    public int getCount();
}
