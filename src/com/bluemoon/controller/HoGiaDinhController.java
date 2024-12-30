package com.bluemoon.controller;

import com.bluemoon.model.HoGiaDinh;
import com.bluemoon.service.HoGiaDinhService;
import com.bluemoon.service.HoGiaDinhServiceImpl;
import com.bluemoon.utility.ClassTableModel;
import com.bluemoon.view.HoGiaDinhJFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
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

public class HoGiaDinhController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã hộ gia đình", "Tên hộ gia đình", "Địa chỉ", "Số lượng nhân khẩu", "Diện tích", "Ngày thuê"};
    
    private HoGiaDinhService hoGiaDinhService = null;
    
    private TableRowSorter<TableModel> rowSorter = null;

    public HoGiaDinhController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.classTableModel = new ClassTableModel();
        this.hoGiaDinhService = new HoGiaDinhServiceImpl();
    }
     public void setDataToTable() {
        List<HoGiaDinh> listItem = hoGiaDinhService.getList();
        DefaultTableModel model = classTableModel.setTableHoGiaDinh(listItem, COLUMNS);
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
                    
                    HoGiaDinh hoGiaDinh = new HoGiaDinh();
                    hoGiaDinh.setMa_hogd(model.getValueAt(selectedRowIndex, 0).toString());
                    hoGiaDinh.setTen_hogd(model.getValueAt(selectedRowIndex, 1).toString());
                    hoGiaDinh.setDia_chi(model.getValueAt(selectedRowIndex, 2).toString());
                    hoGiaDinh.setSo_luong_nhan_khau((int)model.getValueAt(selectedRowIndex, 3));
                    hoGiaDinh.setNgay_thue((Date) model.getValueAt(selectedRowIndex, 5));
                            //classFormat.covertDateToDateSql(
                            //classFormat.covertStringToDate(model.getValueAt(selectedRowIndex, 3).toString(), "dd/MM/yyyy")));
                    hoGiaDinh.setDien_tich((int)model.getValueAt(selectedRowIndex, 4));
                    
             
                    HoGiaDinhJFrame frame = new HoGiaDinhJFrame(hoGiaDinh);
                    frame.setTitle("Thông tin hộ gia đình");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
         
        });
        
       
        
        // design
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
                HoGiaDinhJFrame frame = new HoGiaDinhJFrame(new HoGiaDinh());
                frame.setTitle("Thông tin hộ gia đình");
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
    
    

