package com.bluemoon.dao;

import com.bluemoon.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {

   @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
    TaiKhoan taiKhoan = null;
    Connection cons = null;
    
    try {
        cons = DBConnect.getConnection();
        String sql = "SELECT * FROM tai_khoan WHERE ten_tai_khoan = ? AND mat_khau = ?";
        try (PreparedStatement ps = cons.prepareStatement(sql)) {
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    taiKhoan = new TaiKhoan();
                    taiKhoan.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                    taiKhoan.setTen_tai_khoan(rs.getString("ten_tai_khoan"));
                    taiKhoan.setMat_khau(rs.getString("mat_khau"));
                    taiKhoan.setTinh_trang(rs.getBoolean("tinh_trang"));
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBConnect.closeConnection(cons);
    }
        return taiKhoan;
    }
    
    @Override
    public List<TaiKhoan> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM tai_khoan";
        List<TaiKhoan> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setMa_tai_khoan(rs.getInt("ma_tai_khoan"));
                taiKhoan.setHo_ten(rs.getString("ho_ten"));
                taiKhoan.setTen_tai_khoan(rs.getString("ten_tai_khoan"));
                taiKhoan.setMat_khau(rs.getString("mat_khau"));
                taiKhoan.setTinh_trang(rs.getBoolean("tinh_trang"));
                list.add(taiKhoan);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public int CreateOrUpdate(TaiKhoan taiKhoan) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO tai_khoan(ma_tai_khoan, ho_ten, ten_tai_khoan, mat_khau, tinh_trang) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ho_ten =VALUES(ho_ten), ten_tai_khoan = VALUES(ten_tai_khoan), mat_khau = VALUES(mat_khau), tinh_trang = VALUES(tinh_trang);";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, taiKhoan.getMa_tai_khoan());
            ps.setString(2, taiKhoan.getHo_ten());
            ps.setString(3, taiKhoan.getTen_tai_khoan());
            ps.setString(4, taiKhoan.getMat_khau());
            ps.setBoolean(5, taiKhoan.isTinh_trang());
            ps.execute();
            
            ps.close();
            cons.close();
            return taiKhoan.getMa_tai_khoan();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int Remove(TaiKhoan taiKhoan) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM tai_khoan WHERE ma_tai_khoan = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, taiKhoan.getMa_tai_khoan());
            ps.execute();
            
            ps.close();
            cons.close();
            return taiKhoan.getMa_tai_khoan();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    
}
