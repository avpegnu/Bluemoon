package com.bluemoon.dao;

import com.bluemoon.model.ThuPhi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThuPhiDAOImpl implements ThuPhiDAO{
    
    @Override
    public List<ThuPhi> getList1() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (hgd.dien_tich * lp.tien_m2) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "FROM thu_phi tp\n" +
                     "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                     "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "JOIN ho_gia_dinh hgd ON hgd.ma_hogd = tp.ma_hogd\n" +
                     "WHERE lp.tien_m2 <> 0 AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n" +
                     "UNION\n" +
                     "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "FROM thu_phi tp\n" +
                     "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                     "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "JOIN ho_gia_dinh hgd ON hgd.ma_hogd = tp.ma_hogd\n" +
                     "WHERE lp.tien_tu_thien <> 0;";
        List<ThuPhi> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhi thuPhi = new ThuPhi();
                //nhanKhau.setSTT(rs.getInt("STT"));
                thuPhi.setMa_thu(rs.getString("ma_thu"));
                thuPhi.setMa_phi(rs.getString("ma_phi"));
                thuPhi.setTen_phi(rs.getString("ten_phi"));
                thuPhi.setSo_tien(rs.getInt("so_tien"));
                thuPhi.setNgay_thu(rs.getDate("ngay_thu"));
                thuPhi.setMa_nhan_khau(rs.getString("ma_nhan_khau"));
                thuPhi.setMa_hogd(rs.getString("ma_hogd"));
                list.add(thuPhi);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public String CreateOrUpdate(ThuPhi thuPhi) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO thu_phi(ma_thu, ma_phi, ngay_thu, ma_nhan_khau, ma_hogd, so_tien) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ma_phi = VALUES(ma_phi), ngay_thu = VALUES(ngay_thu), ma_nhan_khau = VALUES(ma_nhan_khau), ma_hogd = VALUES(ma_hogd), so_tien = VALUES(so_tien);";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, thuPhi.getMa_thu());
            ps.setString(2, thuPhi.getMa_phi());
            ps.setDate(3, new Date (thuPhi.getNgay_thu().getTime()));
            ps.setString(4, thuPhi.getMa_nhan_khau());
            ps.setString(5, thuPhi.getMa_hogd());
            ps.setInt(6, thuPhi.getSo_tien());
         
            ps.execute();
            
            ps.close();
            cons.close();
            return thuPhi.getMa_thu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "NULL";
    }

    @Override
    public String Remove(ThuPhi thuPhi) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "DELETE FROM thu_phi WHERE ma_thu = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            //ps.setInt(1, nhanKhau.getSTT());
            ps.setString(1, thuPhi.getMa_thu());
            ps.execute();
            
            ps.close();
            cons.close();
            return thuPhi.getMa_thu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "NULL";
    }

    @Override
    public List<ThuPhi> getList2() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.xe_may * lp.tien_xe) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                      "FROM thu_phi tp\n" +
                      "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                      "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                      "WHERE lp.tien_xe <> 0 AND tp.ma_phi = 'XM' AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n" +
                      "UNION\n" +
                      "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.o_to * lp.tien_xe) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                      "FROM thu_phi tp\n" +
                      "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                      "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                      "WHERE lp.tien_xe <> 0 AND tp.ma_phi = 'OT'AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian);";
        List<ThuPhi> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhi thuPhi = new ThuPhi();
                thuPhi.setMa_thu(rs.getString("ma_thu"));
                thuPhi.setMa_phi(rs.getString("ma_phi"));
                thuPhi.setTen_phi(rs.getString("ten_phi"));
                thuPhi.setSo_tien(rs.getInt("so_tien"));
                thuPhi.setNgay_thu(rs.getDate("ngay_thu"));
                thuPhi.setMa_nhan_khau(rs.getString("ma_nhan_khau"));
                thuPhi.setMa_hogd(rs.getString("ma_hogd"));
                list.add(thuPhi);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ThuPhi> getList3() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.so_dien * lp.tien_so) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "FROM thu_phi tp\n" +
                     "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                     "WHERE lp.tien_so <> 0 AND tp.ma_phi = 'TD' AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n" +
                     "UNION\n" +
                     "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, lp.tien_so AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "FROM thu_phi tp\n" +
                     "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "WHERE lp.tien_so <> 0 AND tp.ma_phi = 'TM' \n" +
                     "UNION\n" +
                     "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.so_nuoc * lp.tien_so) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "FROM thu_phi tp\n" +
                     "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                     "WHERE lp.tien_so <> 0 AND tp.ma_phi = 'TN'AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian);";
        List<ThuPhi> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhi thuPhi = new ThuPhi();
                thuPhi.setMa_thu(rs.getString("ma_thu"));
                thuPhi.setMa_phi(rs.getString("ma_phi"));
                thuPhi.setTen_phi(rs.getString("ten_phi"));
                thuPhi.setSo_tien(rs.getInt("so_tien"));
                thuPhi.setNgay_thu(rs.getDate("ngay_thu"));
                thuPhi.setMa_nhan_khau(rs.getString("ma_nhan_khau"));
                thuPhi.setMa_hogd(rs.getString("ma_hogd"));
                list.add(thuPhi);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    

}
