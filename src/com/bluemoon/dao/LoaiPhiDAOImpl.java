package com.bluemoon.dao;

import com.bluemoon.model.LoaiPhi;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LoaiPhiDAOImpl implements LoaiPhiDAO {

    @Override
    public List<LoaiPhi> getList1() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_phi, ten_phi, tien_m2 FROM loai_phi WHERE tien_m2 <> 0 OR tien_tu_thien <> 0";
        List<LoaiPhi> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhi loaiPhi = new LoaiPhi();
                loaiPhi.setMa_phi(rs.getString("ma_phi"));
                loaiPhi.setTen_phi(rs.getString("ten_phi"));
                loaiPhi.setTien_m2(rs.getInt("tien_m2"));
                list.add(loaiPhi);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<LoaiPhi> getList3() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_phi, ten_phi, tien_so FROM loai_phi WHERE tien_so <> 0;";
        List<LoaiPhi> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhi loaiPhi = new LoaiPhi();
                loaiPhi.setMa_phi(rs.getString("ma_phi"));
                loaiPhi.setTen_phi(rs.getString("ten_phi"));
                loaiPhi.setTien_so(rs.getInt("tien_so"));
                list.add(loaiPhi);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<LoaiPhi> getList2() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_phi, ten_phi, tien_xe FROM loai_phi WHERE tien_xe <> 0;";
        List<LoaiPhi> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhi loaiPhi = new LoaiPhi();
                loaiPhi.setMa_phi(rs.getString("ma_phi"));
                loaiPhi.setTen_phi(rs.getString("ten_phi"));
                loaiPhi.setTien_xe(rs.getInt("tien_xe"));
                list.add(loaiPhi);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(ma_phi) AS tong FROM loai_phi";
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
