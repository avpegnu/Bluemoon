package com.bluemoon.service;

import com.bluemoon.model.HoGiaDinh;
import java.util.List;

public interface HoGiaDinhService {
    public List<HoGiaDinh> getList();
    
    public String CreateOrUpdate(HoGiaDinh hoGiaDinh);
    public String Remove(HoGiaDinh hoGiaDinh);
    public int getCount();
}
