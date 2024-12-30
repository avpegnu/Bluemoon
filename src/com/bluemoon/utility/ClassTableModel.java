package com.bluemoon.utility;

import com.bluemoon.model.DichVu;
import com.bluemoon.model.HoGiaDinh;
import com.bluemoon.model.LoaiPhi;
import com.bluemoon.model.NhanKhau;
import com.bluemoon.model.TaiKhoan;
import com.bluemoon.model.ThuPhi;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    public void centerAlignTable(JTable table){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for(int i = 0; i < table.getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public DefaultTableModel setTableHoGiaDinh(List<HoGiaDinh> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 3: 
                        return Integer.class;
                    case 4: 
                        return Integer.class;
                    case 5: 
                        return Date.class;
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        HoGiaDinh hoGiaDinh = null;
        for (int i = 0; i < num; i++) {
            hoGiaDinh = listItem.get(i);
            obj = new Object[columns];
            obj[0] = hoGiaDinh.getMa_hogd();
            obj[1] = hoGiaDinh.getTen_hogd();
            obj[2] = hoGiaDinh.getDia_chi();
            obj[3] = hoGiaDinh.getSo_luong_nhan_khau();
            obj[4] = hoGiaDinh.getDien_tich();
            obj[5] = hoGiaDinh.getNgay_thue();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableNhanKhau(List<NhanKhau> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 4: 
                        return Date.class;
                    case 7:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhanKhau nhanKhau = null;
        for (int i = 0; i < num; i++) {
            nhanKhau = listItem.get(i);
            obj = new Object[columns];
            obj[0] = nhanKhau.getMa_nhan_khau();
            obj[1] = nhanKhau.getSo_cccd();
            obj[2] = nhanKhau.getMa_hogd();
            obj[3] = nhanKhau.getHo_ten();
            obj[4] = nhanKhau.getNgay_sinh();
            obj[5] = nhanKhau.isGioi_tinh() == true ? "Nam" : "Nữ";
            obj[6] = nhanKhau.getQuan_he_chu_ho();
            obj[7] = nhanKhau.isTam_tru() == true ? "Tạm trú" : "Tạm vắng";
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableThuPhi(List<ThuPhi> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 3: 
                        return Integer.class;
                    case 4:
                        return Date.class;
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        ThuPhi thuPhi = null;
        for (int i = 0; i < num; i++) {
            thuPhi = listItem.get(i);
            obj = new Object[columns];
            obj[0] = thuPhi.getMa_thu();
            obj[1] = thuPhi.getMa_phi();
            obj[2] = thuPhi.getTen_phi();
            obj[3] = thuPhi.getSo_tien();
            obj[4] = thuPhi.getNgay_thu();
            obj[5] = thuPhi.getMa_nhan_khau();
            obj[6] = thuPhi.getMa_hogd();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    
    public DefaultTableModel setTableTaiKhoan(List<TaiKhoan> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0: 
                        return Integer.class;
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        TaiKhoan taiKhoan = null;
        for (int i = 0; i < num; i++) {
            taiKhoan = listItem.get(i);
            obj = new Object[columns];
            obj[0] = taiKhoan.getMa_tai_khoan();
            obj[1] = taiKhoan.getHo_ten();
            obj[2] = taiKhoan.getTen_tai_khoan();
            //obj[2] = taiKhoan.getMat_khau();
            obj[3] = "**************";
            obj[4] = taiKhoan.isTinh_trang() == true ? "Mở" : "Khóa";
            obj[5] = taiKhoan.getMat_khau();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableLoaiPhi1(List<LoaiPhi> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        LoaiPhi loaiPhi = null;
        for (int i = 0; i < num; i++) {
            loaiPhi = listItem.get(i);
            obj = new Object[columns];
            obj[0] = loaiPhi.getMa_phi();
            obj[1] = loaiPhi.getTen_phi();
            obj[2] = loaiPhi.getTien_m2();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableLoaiPhi2(List<LoaiPhi> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        LoaiPhi loaiPhi = null;
        for (int i = 0; i < num; i++) {
            loaiPhi = listItem.get(i);
            obj = new Object[columns];
            obj[0] = loaiPhi.getMa_phi();
            obj[1] = loaiPhi.getTen_phi();
            obj[2] = loaiPhi.getTien_xe();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableLoaiPhi3(List<LoaiPhi> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        LoaiPhi loaiPhi = null;
        for (int i = 0; i < num; i++) {
            loaiPhi = listItem.get(i);
            obj = new Object[columns];
            obj[0] = loaiPhi.getMa_phi();
            obj[1] = loaiPhi.getTen_phi();
            obj[2] = loaiPhi.getTien_so();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    
    
    public DefaultTableModel setTableDichVu(List<DichVu> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 3: 
                        return Integer.class;
                    case 4: 
                        return Integer.class;
                    case 5: 
                        return Integer.class;
                    case 6: 
                        return Integer.class;
                    case 7:
                        return Date.class;
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        DichVu dichVu = null;
        for (int i = 0; i < num; i++) {
            dichVu = listItem.get(i);
            obj = new Object[columns];
            obj[0] = dichVu.getMa_dv();
           // obj[1] = (i + 1);
            obj[1] = dichVu.getMa_hogd();
            obj[2] = dichVu.getThang_nam();
            obj[3] = dichVu.getXe_may();
            obj[4] = dichVu.getO_to();
            obj[5] = dichVu.getSo_dien();
            obj[6] = dichVu.getSo_nuoc();
            obj[7] = dichVu.getThoi_gian();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
