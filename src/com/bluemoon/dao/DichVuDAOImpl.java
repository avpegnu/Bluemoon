package com.bluemoon.dao;

import com.bluemoon.model.DichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class DichVuDAOImpl implements DichVuDAO{

    @Override
    public List<DichVu> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_dv, ma_hogd, thoi_gian, CONCAT(MONTH(thoi_gian),'/',YEAR(thoi_gian)) AS thang_nam, xe_may, o_to, so_dien, so_nuoc\n" +
                     "FROM dich_vu;";
        List<DichVu> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu dichVu = new DichVu();
                dichVu.setMa_dv(rs.getString("ma_dv"));
                dichVu.setMa_hogd(rs.getString("ma_hogd"));
                dichVu.setThang_nam(rs.getString("thang_nam"));
                dichVu.setXe_may(rs.getInt("xe_may"));
                dichVu.setO_to(rs.getInt("o_to"));
                dichVu.setSo_dien(rs.getInt("so_dien"));
                dichVu.setSo_nuoc(rs.getFloat("so_nuoc"));
                dichVu.setThoi_gian(rs.getDate("thoi_gian"));
                list.add(dichVu);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String CreateOrUpdate(DichVu dichVu) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO dich_vu(ma_dv, ma_hogd, thoi_gian, xe_may, o_to, so_dien, so_nuoc) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE  ma_hogd = VALUES(ma_hogd), thoi_gian = VALUES(thoi_gian), xe_may = VALUES(xe_may), o_to = VALUES(o_to), so_dien = VALUES(so_dien), so_nuoc = VALUES(so_nuoc);";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, dichVu.getMa_dv());
            ps.setString(2, dichVu.getMa_hogd());
            ps.setDate(3, new Date (dichVu.getThoi_gian().getTime()));
            ps.setInt(4, dichVu.getXe_may());
            ps.setInt(5, dichVu.getO_to());
            ps.setInt(6, dichVu.getSo_dien());
            ps.setDouble(7, dichVu.getSo_nuoc());
            ps.execute();
            
            ps.close();
            cons.close();
            return dichVu.getMa_dv();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "NULL";
    }

    @Override
    public String Remove(DichVu dichVu) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM dich_vu WHERE ma_dv = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, dichVu.getMa_dv());
            ps.execute();
            
            ps.close();
            cons.close();
            return dichVu.getMa_dv();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "NULL";
    }
    
}
