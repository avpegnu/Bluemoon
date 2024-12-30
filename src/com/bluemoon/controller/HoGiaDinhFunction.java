package com.bluemoon.controller;

import com.bluemoon.model.HoGiaDinh;
import com.bluemoon.service.HoGiaDinhService;
import com.bluemoon.service.HoGiaDinhServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HoGiaDinhFunction {
    private JButton btnSubmit;
    private JButton btnRemove;
    private JTextField jtfMaHoGD;
    private JTextField jtfTenHoGD;
    private JTextField jtfDiaChi;
    private JDateChooser jdcNgayThue;
    private JTextField jtfDienTich;
    private JLabel jlbMsg;

    private HoGiaDinh hoGiaDinh = null;

    private HoGiaDinhService hoGiaDinhService = null;
    
    public HoGiaDinhFunction(JButton btnSubmit, JTextField jtfMaHoGD, JTextField jtfTenHoGD, JTextField jtfDiaChi,
            JDateChooser jdcNgayThue, JTextField jtfDienTich, JLabel jlbMsg, JButton btnRemove) {
        this.btnSubmit = btnSubmit;
        this.btnRemove = btnRemove;
        this.jtfMaHoGD = jtfMaHoGD;
        this.jtfTenHoGD = jtfTenHoGD;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfDienTich = jtfDienTich;
        this.jdcNgayThue = jdcNgayThue;
        this.jlbMsg = jlbMsg;
        this.hoGiaDinhService = new HoGiaDinhServiceImpl();
    }

    public void setView(HoGiaDinh hoGiaDinh) {
        this.hoGiaDinh = hoGiaDinh;
        // set data
        jtfMaHoGD.setText(hoGiaDinh.getMa_hogd());
        jtfTenHoGD.setText(hoGiaDinh.getTen_hogd());
        jdcNgayThue.setDate(hoGiaDinh.getNgay_thue());
        jtfDiaChi.setText(hoGiaDinh.getDia_chi());
        jtfDienTich.setText(String.valueOf(hoGiaDinh.getDien_tich()));
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
                        hoGiaDinh.setMa_hogd(jtfMaHoGD.getText());
                        hoGiaDinh.setTen_hogd(jtfTenHoGD.getText());
                        hoGiaDinh.setNgay_thue(covertDateToDateSql(jdcNgayThue.getDate()));
                        hoGiaDinh.setDia_chi(jtfDiaChi.getText());
                        hoGiaDinh.setDien_tich(Integer.parseInt(jtfDienTich.getText()));
                        //hoGiaDinh.setTrang_thai(jrbNam.isSelected());
                       
                        if (showDialog()) {
                            String lastId = hoGiaDinhService.CreateOrUpdate(hoGiaDinh);
                            if (lastId == "NULL") {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            } else {
                                hoGiaDinh.setMa_hogd(lastId);
                                jtfMaHoGD.setText(hoGiaDinh.getMa_hogd());
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
                            String lastId = hoGiaDinhService.Remove(hoGiaDinh);
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
        return jtfTenHoGD.getText() != null && !jtfTenHoGD.getText().equalsIgnoreCase("")
        && jtfDiaChi.getText() != null && !jtfDiaChi.getText().equalsIgnoreCase("") 
        && jdcNgayThue.getDate() != null 
        && jtfDienTich.getText() != null && !jtfDienTich.getText().equalsIgnoreCase("");
        
    }
    
    private boolean checkNotNulltoRemove() {
        return jtfMaHoGD.getText() != null && !jtfMaHoGD.getText().equalsIgnoreCase("");
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

