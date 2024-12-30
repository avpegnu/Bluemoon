
package com.bluemoon.controller;


import com.bluemoon.model.ThuPhi;
import com.bluemoon.service.ThuPhiService;
import com.bluemoon.service.ThuPhiServiceImpl;
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

public class ThuPhiFunction {
    private JButton btnSubmit;
    private JButton btnRemove;
    private JTextField jtfMaThu;
    private JTextField jtfMaNhanKhau;
    private JTextField jtfMaPhi;
    private JDateChooser jdcNgayThu;
    private JTextField jtfMaHoGD;
    private JTextField jtfSoTien;
    private JLabel jlbMsg;

    private ThuPhi thuPhi = null;

    private ThuPhiService thuPhiService = null;
    
    public ThuPhiFunction(JButton btnSubmit, JTextField jtfMaThu, JTextField jtfMaPhi, JTextField jtfSoTien,
            JDateChooser jdcNgayThu, JTextField jtfMaNhanKhau, JTextField jtfMaHoGD, JLabel jlbMsg, JButton btnRemove) {
        this.btnSubmit = btnSubmit;
        this.btnRemove = btnRemove;

        this.jtfMaNhanKhau = jtfMaNhanKhau;
        this.jtfMaThu = jtfMaThu;
        this.jdcNgayThu = jdcNgayThu;
        this.jtfMaPhi = jtfMaPhi;
        this.jtfMaHoGD = jtfMaHoGD;
        this.jtfSoTien = jtfSoTien;
        this.jlbMsg = jlbMsg;
        this.thuPhiService = new ThuPhiServiceImpl();
    }

    public void setView(ThuPhi thuPhi) {
        this.thuPhi = thuPhi;
        // set data
        jtfMaThu.setText(thuPhi.getMa_thu());
        jtfMaPhi.setText(thuPhi.getMa_phi());
        jdcNgayThu.setDate(thuPhi.getNgay_thu());
        jtfMaNhanKhau.setText(thuPhi.getMa_nhan_khau());
        jtfMaHoGD.setText(thuPhi.getMa_hogd());
        jtfSoTien.setText(String.valueOf(thuPhi.getSo_tien()));
        
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
                        thuPhi.setMa_thu(jtfMaThu.getText());
                        thuPhi.setMa_phi(jtfMaPhi.getText());
                        thuPhi.setNgay_thu(covertDateToDateSql(jdcNgayThu.getDate()));
                        thuPhi.setMa_nhan_khau(jtfMaNhanKhau.getText());
                        thuPhi.setMa_hogd(jtfMaHoGD.getText());
                        thuPhi.setSo_tien(Integer.parseInt(jtfSoTien.getText()));
                       
                        if (showDialog()) {
                            String lastId = thuPhiService.CreateOrUpdate(thuPhi);
                            if (lastId == "NULL") {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            } else {
                                thuPhi.setMa_thu(lastId);
                                jtfMaThu.setText(thuPhi.getMa_thu());
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
                            String lastId = thuPhiService.Remove(thuPhi);
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
        return jtfMaPhi.getText() != null && !jtfMaPhi.getText().equalsIgnoreCase("");
    }
    
    private boolean checkNotNulltoRemove() {
        return jtfMaThu.getText() != null && !jtfMaThu.getText().equalsIgnoreCase("");
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

