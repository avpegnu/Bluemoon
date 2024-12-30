package com.bluemoon.dao;

import com.bluemoon.model.NhanKhau;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanKhauDAOImpl implements NhanKhauDAO {

    @Override
    public List<NhanKhau> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM nhan_khau";
        List<NhanKhau> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setMa_nhan_khau(rs.getString("ma_nhan_khau"));
                nhanKhau.setSo_cccd(rs.getString("so_cccd"));
                nhanKhau.setMa_hogd(rs.getString("ma_hogd"));
                nhanKhau.setHo_ten(rs.getString("ho_ten"));
                nhanKhau.setNgay_sinh(rs.getDate("ngay_sinh"));
                nhanKhau.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                nhanKhau.setQuan_he_chu_ho(rs.getString("quan_he_chu_ho"));
                nhanKhau.setTam_tru(rs.getBoolean("tam_tru"));
                list.add(nhanKhau);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public String CreateOrUpdate(NhanKhau nhanKhau) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhan_khau(ma_nhan_khau, so_cccd, ma_hogd, ho_ten, ngay_sinh, gioi_tinh, quan_he_chu_ho, tam_tru) VALUES(?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE  ho_ten = VALUES(ho_ten), ngay_sinh = VALUES(ngay_sinh), gioi_tinh = VALUES(gioi_tinh), quan_he_chu_ho = VALUES(quan_he_chu_ho), ma_hogd = VALUES(ma_hogd), so_cccd = VALUES(so_cccd), tam_tru = VALUES(tam_tru);";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, nhanKhau.getMa_nhan_khau());
            ps.setString(2, nhanKhau.getSo_cccd());
            ps.setString(3, nhanKhau.getMa_hogd());
            ps.setString(4, nhanKhau.getHo_ten());
            ps.setDate(5, nhanKhau.getNgay_sinh());
            ps.setBoolean(6, nhanKhau.isGioi_tinh());
            ps.setString(7, nhanKhau.getQuan_he_chu_ho());
            ps.setBoolean(8, nhanKhau.isTam_tru());
            ps.execute();
            
            ps.close();
            cons.close();
            return nhanKhau.getMa_nhan_khau();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "NULL";
    }
    
    @Override
    public String Remove(NhanKhau nhanKhau) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM nhan_khau WHERE ma_nhan_khau = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, nhanKhau.getMa_nhan_khau());
            ps.execute();
            
            ps.close();
            cons.close();
            return nhanKhau.getMa_nhan_khau();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "NULL";
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(ma_nhan_khau) AS tong FROM nhan_khau";
        int tong = 0; // Khởi tạo giá trị mặc định
        try (Connection cons = DBConnect.getConnection();
             PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            if (rs.next()) { // Sử dụng if vì chỉ trả về 1 giá trị
               tong = rs.getInt("tong");
            }
        } catch (Exception e) {
             e.printStackTrace();
            }
        return tong;
    }
    
}
    