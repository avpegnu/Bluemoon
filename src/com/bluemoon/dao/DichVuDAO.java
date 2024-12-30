package com.bluemoon.dao;

import com.bluemoon.model.DichVu;
import java.util.List;

public interface DichVuDAO {
    public List<DichVu> getList();
    
    public String CreateOrUpdate(DichVu dichVu);
    public String Remove(DichVu dichVu);
}
