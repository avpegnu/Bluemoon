package com.bluemoon.controller;

import com.bluemoon.model.DichVu;
import com.bluemoon.service.DichVuService;
import com.bluemoon.service.DichVuServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DichVuFunction {
    private JButton btnSubmit;
    private JButton btnRemove;
    private JTextField jtfMaDichVu;
    private JTextField jtfMaHoGD;
    private JTextField jtfXeMay;
    private JDateChooser jdcThoiGian;
    private JTextField jtfOTo;
    private JTextField jtfSoDien;
    private JTextField jtfSoNuoc;
    private JLabel jlbMsg;

    private DichVu dichVu = null;
    private DichVuService dichVuService = null;
    
    public DichVuFunction(JButton btnSubmit, JTextField jtfMaDichVu, JTextField jtfMaHoGD, JDateChooser jdcThoiGian
            , JTextField jtfXeMay, JTextField jtfOTo, JTextField jtfSoDien, JTextField jtfSoNuoc, JLabel jlbMsg, JButton btnRemove) {
        this.btnSubmit = btnSubmit;
        this.btnRemove = btnRemove;
        this.jtfMaDichVu = jtfMaDichVu;
        this.jtfMaHoGD = jtfMaHoGD;
        this.jtfXeMay = jtfXeMay;
        this.jtfOTo = jtfOTo;
        this.jtfSoDien = jtfSoDien;
        this.jtfSoNuoc = jtfSoNuoc;
        this.jdcThoiGian = jdcThoiGian;
        this.jlbMsg = jlbMsg;
        this.dichVuService = new DichVuServiceImpl();
    }

    public void setView(DichVu dichVu) {
        this.dichVu = dichVu;
        // set data
        jtfMaDichVu.setText(dichVu.getMa_dv());
        jtfMaHoGD.setText(dichVu.getMa_hogd());
        jdcThoiGian.setDate(dichVu.getThoi_gian());
        jtfXeMay.setText(String.valueOf(dichVu.getXe_may()));
        jtfOTo.setText(String.valueOf(dichVu.getO_to()));
        jtfSoDien.setText(String.valueOf(dichVu.getSo_dien()));
        jtfSoNuoc.setText(String.valueOf(dichVu.getSo_nuoc()));
        
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
                        dichVu.setMa_dv(jtfMaDichVu.getText());
                        dichVu.setMa_hogd(jtfMaHoGD.getText());
                        dichVu.setThoi_gian(covertDateToDateSql(jdcThoiGian.getDate()));
                        dichVu.setXe_may(Integer.parseInt(jtfXeMay.getText()));
                        dichVu.setO_to(Integer.parseInt(jtfOTo.getText()));
                        dichVu.setSo_dien(Integer.parseInt(jtfSoDien.getText()));
                        dichVu.setSo_nuoc(Float.parseFloat(jtfSoNuoc.getText()));
                        
                        if (showDialog()) {
                            String lastId = dichVuService.CreateOrUpdate(dichVu);
                            if (lastId == "NULL") {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            } else {
                                dichVu.setMa_dv(lastId);
                                jtfMaDichVu.setText(dichVu.getMa_dv());
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
                            String lastId = dichVuService.Remove(dichVu);
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
        return jtfMaHoGD.getText() != null && !jtfMaHoGD.getText().equalsIgnoreCase("");
    }
    
    private boolean checkNotNulltoRemove() {
        return jtfMaDichVu.getText() != null && !jtfMaDichVu.getText().equalsIgnoreCase("");
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
