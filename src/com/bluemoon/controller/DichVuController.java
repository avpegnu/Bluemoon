
package com.bluemoon.controller;

import com.bluemoon.model.DichVu;
import com.bluemoon.service.DichVuService;
import com.bluemoon.service.DichVuServiceImpl;
import com.bluemoon.utility.ClassTableModel;
import com.bluemoon.view.DichVuJFrame;
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

public class DichVuController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã dịch vụ", "Mã hộ gia đình", "Thời gian", "Số xe máy", "Số ô tô", "Số điện", "Số nước", "Thời gian cập nhật"};
    
    private DichVuService dichVuService = null;
    
    private TableRowSorter<TableModel> rowSorter = null;

    public DichVuController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.classTableModel = new ClassTableModel();
        this.dichVuService = new DichVuServiceImpl();
    }
     public void setDataToTable() {
        List<DichVu> listItem = dichVuService.getList();
        DefaultTableModel model = classTableModel.setTableDichVu(listItem, COLUMNS);
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
                    
                    DichVu dichVu = new DichVu();
                    dichVu.setMa_dv(model.getValueAt(selectedRowIndex, 0).toString());
                    dichVu.setMa_hogd(model.getValueAt(selectedRowIndex, 1).toString());
                    dichVu.setXe_may((int)model.getValueAt(selectedRowIndex, 3));
                    dichVu.setThoi_gian((Date) model.getValueAt(selectedRowIndex, 7));
                            //classFormat.covertDateToDateSql(
                            //classFormat.covertStringToDate(model.getValueAt(selectedRowIndex, 3).toString(), "dd/MM/yyyy")));
                    dichVu.setO_to((int)model.getValueAt(selectedRowIndex, 4));
                    dichVu.setSo_dien((int)model.getValueAt(selectedRowIndex, 5));
                    dichVu.setSo_nuoc((float)model.getValueAt(selectedRowIndex, 6));
                    
             
                    DichVuJFrame frame = new DichVuJFrame(dichVu);
                    frame.setTitle("Thông tin dịch vụ");
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
                DichVuJFrame frame = new DichVuJFrame(new DichVu());
                frame.setTitle("Thông tin dịch vụ");
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
