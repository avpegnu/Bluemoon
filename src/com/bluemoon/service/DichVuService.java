package com.bluemoon.service;

import com.bluemoon.model.DichVu;
import java.util.List;

public interface DichVuService {
    public List<DichVu> getList();
    
    public String CreateOrUpdate(DichVu dichVu);
    public String Remove(DichVu dichVu);
}
