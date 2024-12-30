package com.bluemoon.controller;


import com.bluemoon.model.NhanKhau;
import com.bluemoon.service.NhanKhauService;
import com.bluemoon.service.NhanKhauServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class NhanKhauFunction {
    private JButton btnSubmit;
    private JButton btnRemove;
    private JTextField jtfSTT;
    private JTextField jtfMaNhanKhau;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JTextField jtfSoCCCD;
    private JRadioButton jrbNam;
    private JRadioButton jrbNu;
    private JTextField jtfMaHoGD;
    private JTextField jtfQuanHeChuHo;
    private JLabel jlbMsg;
    private JRadioButton jrbTamTru;
    private JRadioButton jrbTamVang;

    private NhanKhau nhanKhau = null;

    private NhanKhauService nhanKhauService = null;
    
    public NhanKhauFunction(JButton btnSubmit, JTextField jtfMaNhanKhau, JTextField jtfHoTen,
            JDateChooser jdcNgaySinh, JTextField jtfSoCCCD, JRadioButton jrbNam, JRadioButton jrbNu, JRadioButton jrbTamTru, JRadioButton jrbTamVang,
            JTextField jtfMaHoGD, JTextField jtfQuanHeChuHo, JLabel jlbMsg, JButton btnRemove) {
        this.btnSubmit = btnSubmit;
        this.btnRemove = btnRemove;
        this.jtfMaNhanKhau = jtfMaNhanKhau;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jtfSoCCCD = jtfSoCCCD;
        this.jrbNam = jrbNam;
        this.jrbNu = jrbNu;
        this.jtfMaHoGD = jtfMaHoGD;
        this.jtfQuanHeChuHo = jtfQuanHeChuHo;
        this.jrbTamTru = jrbTamTru;
        this.jrbTamVang = jrbTamVang;
        this.jlbMsg = jlbMsg;
        this.nhanKhauService = new NhanKhauServiceImpl();
        
    }

    public void setView(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
        // set data
        jtfMaNhanKhau.setText(nhanKhau.getMa_nhan_khau());
        jtfHoTen.setText(nhanKhau.getHo_ten());
        jdcNgaySinh.setDate(nhanKhau.getNgay_sinh());
        if (nhanKhau.isGioi_tinh()) {
            jrbNam.setSelected(true);
            jrbNu.setSelected(false);
        } else if(!nhanKhau.isGioi_tinh()) {
            jrbNu.setSelected(true);
            jrbNam.setSelected(false);
        }
        if (nhanKhau.isTam_tru()) {
            jrbTamTru.setSelected(true);
            jrbTamVang.setSelected(false);
        } else if(!nhanKhau.isGioi_tinh()) {
            jrbTamVang.setSelected(true);
            jrbTamTru.setSelected(false);
        }
        jtfSoCCCD.setText(nhanKhau.getSo_cccd());
        jtfMaHoGD.setText(nhanKhau.getMa_hogd());
        jtfQuanHeChuHo.setText(nhanKhau.getQuan_he_chu_ho());
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
                    } else {
                        nhanKhau.setMa_nhan_khau(jtfMaNhanKhau.getText());
                        nhanKhau.setHo_ten(jtfHoTen.getText());
                        nhanKhau.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                        nhanKhau.setSo_cccd(jtfSoCCCD.getText());
                        nhanKhau.setMa_hogd(jtfMaHoGD.getText());
                        nhanKhau.setQuan_he_chu_ho(jtfQuanHeChuHo.getText());
                        nhanKhau.setGioi_tinh(jrbNam.isSelected());
                        nhanKhau.setTam_tru(jrbTamTru.isSelected());
                       
                        if (showDialog()) {
                            String lastId = nhanKhauService.CreateOrUpdate(nhanKhau);
                            if (lastId == "NULL") {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            } else {
                                nhanKhau.setMa_nhan_khau(lastId);
                                jtfMaNhanKhau.setText(nhanKhau.getMa_nhan_khau());
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
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
                            String lastId = nhanKhauService.Remove(nhanKhau);
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
        return jtfHoTen.getText() != null && !jtfHoTen.getText().equalsIgnoreCase("")
                && jtfMaHoGD.getText() != null && !jtfMaHoGD.getText().equalsIgnoreCase("");
    }
    
    private boolean checkNotNulltoRemove() {
        return jtfMaNhanKhau.getText() != null && !jtfMaNhanKhau.getText().equalsIgnoreCase("");
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

