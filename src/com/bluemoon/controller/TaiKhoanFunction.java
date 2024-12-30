package com.bluemoon.controller;

import com.bluemoon.model.TaiKhoan;
import com.bluemoon.service.TaiKhoanService;
import com.bluemoon.service.TaiKhoanServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TaiKhoanFunction {
    private JButton btnSubmit;
    private JButton btnRemove;
    private JTextField jtfMaTaiKhoan;
    private JTextField jtfHoTen;
    private JTextField jtfTenTaiKhoan;
    private JTextField jtfMatKhau;
    private JTextField jtfMatKhauMoi;
    private JRadioButton jrbMo;
    private JRadioButton jrbKhoa;
    private JLabel jlbMsg;

    private TaiKhoan taiKhoan = null;

    private TaiKhoanService taiKhoanService = null;
    
    public TaiKhoanFunction(JButton btnSubmit, JTextField jtfMaTaiKhoan, JTextField jtfHoTen, JTextField jtfTenTaiKhoan, JTextField jtfMatKhau, JTextField jtfMatKhauMoi,
            JRadioButton jrbMo, JRadioButton jrbKhoa,
            JLabel jlbMsg, JButton btnRemove) {
        this.btnSubmit = btnSubmit;
        this.btnRemove = btnRemove;
        this.jtfMaTaiKhoan = jtfMaTaiKhoan;
        this.jtfHoTen = jtfHoTen;
        this.jtfTenTaiKhoan = jtfTenTaiKhoan;
        this.jtfMatKhau = jtfMatKhau;
        this.jtfMatKhauMoi = jtfMatKhauMoi;
        this.jrbMo = jrbMo;
        this.jrbKhoa = jrbKhoa;
        this.jlbMsg = jlbMsg;
        this.taiKhoanService = new TaiKhoanServiceImpl();
    }

    public void setView(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
        // set data
        jtfMaTaiKhoan.setText(String.valueOf(taiKhoan.getMa_tai_khoan()));
        jtfHoTen.setText(taiKhoan.getHo_ten());
        jtfTenTaiKhoan.setText(taiKhoan.getTen_tai_khoan());
        //jtfMatKhau.setText(taiKhoan.getMat_khau());
        if (taiKhoan.isTinh_trang()) {
            jrbMo.setSelected(true);
        } else {
            jrbKhoa.setSelected(true);
        }
        // set event
        setEvent();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    }else if(!jtfMatKhau.getText().trim().equals(taiKhoan.getMat_khau().trim())){
                        showDialog();
                        jlbMsg.setText("Mật khẩu cũ không đúng!");    
                    } else {
                        taiKhoan.setMa_tai_khoan(Integer.parseInt(jtfMaTaiKhoan.getText()));
                        taiKhoan.setHo_ten(jtfHoTen.getText());
                        taiKhoan.setTen_tai_khoan(jtfTenTaiKhoan.getText());
                        taiKhoan.setMat_khau(jtfMatKhauMoi.getText());
                        taiKhoan.setTinh_trang(jrbMo.isSelected());
                       
                        if (showDialog()) {
                            int lastId = taiKhoanService.CreateOrUpdate(taiKhoan);
                            if (lastId == 0) {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            } else {
                                taiKhoan.setMa_tai_khoan(lastId);
                                jtfMaTaiKhoan.setText(String.valueOf(taiKhoan.getMa_tai_khoan()));
                                jlbMsg.setText("Đổi thông tin thành công!");
            
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
        
        btnRemove.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                        if (showDialogtoRemove()) {
                            int lastId = taiKhoanService.Remove(taiKhoan);
                            if (!checkNotNulltoRemove()) {
                                jlbMsg.setText("Không có dữ liệu để xóa!");                    
                            } else {
                                jlbMsg.setText("Xóa dữ liệu thành công!");
                            }
                        }
            }
        });  
    }

    private boolean checkNotNull() {
        return jtfTenTaiKhoan.getText() != null && !jtfTenTaiKhoan.getText().equalsIgnoreCase("")
               && jtfHoTen.getText() != null && !jtfHoTen.getText().equalsIgnoreCase("");
    }
    
    private boolean checkNotNulltoRemove() {
        return jtfTenTaiKhoan.getText() != null && !jtfTenTaiKhoan.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    private boolean showDialogtoRemove() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn xóa dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
