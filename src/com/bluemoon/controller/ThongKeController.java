package com.bluemoon.controller;

import com.bluemoon.bean.ThuPhiChungCuTK;
import com.bluemoon.bean.ThuPhiTienIchTK;
import com.bluemoon.bean.ThuPhiXeTK;
import com.bluemoon.service.ThongKeService;
import com.bluemoon.service.ThongKeServiceImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongKeController {
    private ThongKeService thongKeService = null;

    public ThongKeController() {
        this.thongKeService = new ThongKeServiceImpl();
    }

    public void setDataToChart1(JPanel jpnItem) {
        List<ThuPhiChungCuTK> listItem = thongKeService.getListByThuPhiChungCu();
        System.out.println(listItem.size());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThuPhiChungCuTK item : listItem) {
                dataset.addValue(item.getSoTienQLCC(), "Số tiền QLCC", item.getThang_nam());
                dataset.addValue(item.getSoTienDVCC(), "Số tiền DVCC", item.getThang_nam());
                dataset.addValue(item.getSoTienTT(), "Số tiền từ thiện", item.getThang_nam());
                
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê phí chung cư".toUpperCase(),
                "Thời gian", "Số tiền",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.01); 
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.2);
        
        chartPanel.setPreferredSize(new Dimension(1450, 600));
        
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
        if(jpnItem.getComponentCount() > 0) System.out.println("Thành công");
    }
    
    public void setDataToChart2(JPanel jpnItem) {
        List<ThuPhiXeTK> listItem = thongKeService.getListByThuPhiXe();
        System.out.println(listItem.size());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThuPhiXeTK item : listItem) {
                dataset.addValue(item.getSoTienOTo(), "Số tiền gửi ô tô", item.getThang_nam());
                dataset.addValue(item.getSoTienXeMay(), "Số tiền gửi xe máy", item.getThang_nam()); 
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê phí gửi xe".toUpperCase(),
                "Thời gian", "Số tiền",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.01); 
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.2);
        chartPanel.setPreferredSize(new Dimension(1450, 600));
        
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
        if(jpnItem.getComponentCount() > 0) System.out.println("Thành công");
    }
    
    public void setDataToChart3(JPanel jpnItem) {
        List<ThuPhiTienIchTK> listItem = thongKeService.getListByThuPhiTienIch();
        System.out.println(listItem.size());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThuPhiTienIchTK item : listItem) {
                dataset.addValue(item.getSoTienDien(), "Số tiền điện", item.getThang_nam());
                dataset.addValue(item.getSoTienNuoc(), "Số tiền nước", item.getThang_nam());
                dataset.addValue(item.getSoTienMang(), "Số tiền mạng", item.getThang_nam());
                
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê phí tiện ích".toUpperCase(),
                "Thời gian", "Số tiền",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.01); 
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.2);
        
        chartPanel.setPreferredSize(new Dimension(1450, 600));
        
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
        if(jpnItem.getComponentCount() > 0) System.out.println("Thành công");
    }
}
