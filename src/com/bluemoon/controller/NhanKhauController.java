package com.bluemoon.controller;

import com.bluemoon.model.NhanKhau;
import com.bluemoon.service.NhanKhauService;
import com.bluemoon.service.NhanKhauServiceImpl;
import com.bluemoon.utility.ClassTableModel;
import com.bluemoon.view.NhanKhauJFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhanKhauController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã nhân khẩu", "Số CCCD", "Mã hộ gia đình", "Họ tên", "Ngày sinh", "Giới tính", "Quan hệ chủ hộ", "Tình trạng"};
    
    private NhanKhauService nhanKhauService = null;
    
    private TableRowSorter<TableModel> rowSorter = null;

    public NhanKhauController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.classTableModel = new ClassTableModel();
        this.nhanKhauService = new NhanKhauServiceImpl();
    }
     public void setDataToTable() {
        List<NhanKhau> listItem = nhanKhauService.getList();
        DefaultTableModel model = classTableModel.setTableNhanKhau(listItem, COLUMNS);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel (selectedRowIndex);
                    
                    NhanKhau nhanKhau = new NhanKhau();
                    
                    nhanKhau.setMa_nhan_khau(model.getValueAt(selectedRowIndex, 0).toString());
                    nhanKhau.setHo_ten(model.getValueAt(selectedRowIndex, 3).toString());
                    nhanKhau.setSo_cccd((String) model.getValueAt(selectedRowIndex, 1));
                    nhanKhau.setMa_hogd(model.getValueAt(selectedRowIndex, 2).toString());
                    nhanKhau.setNgay_sinh((Date) model.getValueAt(selectedRowIndex, 4));
                    System.out.println("ChooserDate:" +nhanKhau.getNgay_sinh());
                            //classFormat.covertDateToDateSql(
                            //classFormat.covertStringToDate(model.getValueAt(selectedRowIndex, 3).toString(), "dd/MM/yyyy")));
                    nhanKhau.setGioi_tinh(model.getValueAt(selectedRowIndex, 5).toString().equalsIgnoreCase("Nam"));
                    nhanKhau.setTam_tru(model.getValueAt(selectedRowIndex, 7).toString().equalsIgnoreCase("Tạm trú"));
                    nhanKhau.setQuan_he_chu_ho(model.getValueAt(selectedRowIndex, 6) != null
                            ? model.getValueAt(selectedRowIndex, 6).toString() : null);
                    
                    NhanKhauJFrame frame = new NhanKhauJFrame(nhanKhau);
                    frame.setTitle("Thông tin nhân khẩu");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
         
        });

        // design
//        table.getColumnModel().getColumn(1).setMaxWidth(150);
//        table.getColumnModel().getColumn(1).setMinWidth(150);
//        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        
     
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        classTableModel.centerAlignTable(table);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 850));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
     
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                NhanKhauJFrame frame = new NhanKhauJFrame(new NhanKhau());
                frame.setTitle("Thông tin nhân khẩu");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }

}
    
    

