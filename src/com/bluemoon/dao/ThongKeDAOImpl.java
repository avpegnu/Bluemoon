package com.bluemoon.dao;

import com.bluemoon.bean.ThuPhiChungCuTK;
import com.bluemoon.bean.ThuPhiTienIchTK;
import com.bluemoon.bean.ThuPhiXeTK;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongKeDAOImpl implements ThongKeDAO {

    @Override
    public List<ThuPhiChungCuTK> getListByThuPhiChungCu() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT CONCAT(MONTH(ngay_thu), '/', YEAR(ngay_thu)) AS thang_nam,\n" +
                            "SUM(CASE WHEN ma_phi = 'QLCC' THEN so_tien ELSE 0 END) AS so_tien_qlcc,\n" +
                            "SUM(CASE WHEN ma_phi = 'DVCC' THEN so_tien ELSE 0 END) AS so_tien_dvcc,\n" +
                            "SUM(CASE WHEN ma_phi = 'TT' THEN so_tien ELSE 0 END) AS so_tien_tt\n" +
                     "FROM (\n" +
                     "    SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (hgd.dien_tich * lp.tien_m2) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "    FROM thu_phi tp\n" +
                     "    JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                     "    JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "    JOIN ho_gia_dinh hgd ON hgd.ma_hogd = tp.ma_hogd\n" +
                     "    WHERE lp.tien_m2 <> 0 AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n" +
                     "    UNION\n" +
                     "    SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                     "    FROM thu_phi tp\n" +
                     "    JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                     "    JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                     "    JOIN ho_gia_dinh hgd ON hgd.ma_hogd = tp.ma_hogd\n" +
                     "    WHERE lp.tien_tu_thien <> 0\n" +
                     ") phi_chung_cu\n" +
                     "GROUP BY YEAR(ngay_thu), MONTH(ngay_thu);";
        List<ThuPhiChungCuTK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhiChungCuTK thuPhiChungCuTK = new ThuPhiChungCuTK();
                thuPhiChungCuTK.setThang_nam(rs.getString("thang_nam"));
                thuPhiChungCuTK.setSoTienQLCC(rs.getInt("so_tien_qlcc"));
                thuPhiChungCuTK.setSoTienDVCC(rs.getInt("so_tien_dvcc"));
                thuPhiChungCuTK.setSoTienTT(rs.getInt("so_tien_tt"));
                list.add(thuPhiChungCuTK);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThuPhiXeTK> getListByThuPhiXe() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT CONCAT(MONTH(ngay_thu), '/', YEAR(ngay_thu)) AS thang_nam,\n" +
                                "SUM(CASE WHEN ma_phi = 'XM' THEN so_tien ELSE 0 END) AS so_tien_xe_may,\n" +
                                "SUM(CASE WHEN ma_phi = 'OT' THEN so_tien ELSE 0 END) AS so_tien_o_to\n" +
                     "FROM (\n" +
                            "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.xe_may * lp.tien_xe) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                            "FROM thu_phi tp\n" +
                            "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                            "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                            "WHERE lp.tien_xe <> 0 AND tp.ma_phi = 'XM' AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n" +
                            "UNION\n" +
                            "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.o_to * lp.tien_xe) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
                            "FROM thu_phi tp\n" +
                            "JOIN loai_phi lp ON lp.ma_phi = tp.ma_phi\n" +
                            "JOIN dich_vu dv ON dv.ma_hogd = tp.ma_hogd\n" +
                            "WHERE lp.tien_xe <> 0 AND tp.ma_phi = 'OT'AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n"+
                          ") phi_xe\n " +
                     "GROUP BY YEAR(ngay_thu), MONTH(ngay_thu);";
        List<ThuPhiXeTK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhiXeTK thuPhiXeTK = new ThuPhiXeTK();
                thuPhiXeTK.setThang_nam(rs.getString("thang_nam"));
                thuPhiXeTK.setSoTienXeMay(rs.getInt("so_tien_xe_may"));
                thuPhiXeTK.setSoTienOTo(rs.getInt("so_tien_o_to"));
                list.add(thuPhiXeTK);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThuPhiTienIchTK> getListByThuPhiTienIch() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT CONCAT(MONTH(ngay_thu), '/', YEAR(ngay_thu)) AS thang_nam,\n " +
                                "SUM(CASE WHEN ma_phi = 'TD' THEN so_tien ELSE 0 END) AS so_tien_dien,\n" +
                                "SUM(CASE WHEN ma_phi = 'TM' THEN so_tien ELSE 0 END) AS so_tien_mang,\n" +
                                "SUM(CASE WHEN ma_phi = 'TN' THEN so_tien ELSE 0 END) AS so_tien_nuoc\n" +
                     "FROM (\n" +
                            "SELECT ma_thu, tp.ma_phi, ten_phi, ngay_thu, (dv.so_dien * lp.tien_so) AS so_tien, ma_nhan_khau, tp.ma_hogd\n" +
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
                            "WHERE lp.tien_so <> 0 AND tp.ma_phi = 'TN'AND MONTH(ngay_thu) = MONTH(thoi_gian) AND YEAR(ngay_thu) = YEAR(thoi_gian)\n" +
                          ") phi_tien_ich\n " +
                     "GROUP BY YEAR(ngay_thu), MONTH(ngay_thu);";
        List<ThuPhiTienIchTK> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuPhiTienIchTK thuPhiTienIchTK = new ThuPhiTienIchTK();
                thuPhiTienIchTK.setThang_nam(rs.getString("thang_nam"));
                thuPhiTienIchTK.setSoTienDien(rs.getInt("so_tien_dien"));
                thuPhiTienIchTK.setSoTienNuoc(rs.getInt("so_tien_nuoc"));
                thuPhiTienIchTK.setSoTienMang(rs.getInt("so_tien_mang"));
                list.add(thuPhiTienIchTK);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
