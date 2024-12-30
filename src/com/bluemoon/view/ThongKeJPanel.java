package com.bluemoon.view;

import com.bluemoon.bean.DanhMucBean;
import com.bluemoon.controller.ChuyenManHinhController;
import com.bluemoon.controller.ThongKeController;
import java.util.ArrayList;
import java.util.List;

public class ThongKeJPanel extends javax.swing.JPanel {
    public ThongKeJPanel() {
        initComponents();
        
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnRoot);

        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("ThongKePhiChungCu", jpnPhiChungCu, jlbPhiChungCu));
        listItem.add(new DanhMucBean("ThongKePhiXe", jpnPhiXe, jlbPhiXe));
        listItem.add(new DanhMucBean("ThongKePhiTienIch", jpnPhiTienIch, jlbPhiTienIch));
        
        controller.setEvent1(listItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnPhiXe = new javax.swing.JPanel();
        jlbPhiXe = new javax.swing.JLabel();
        jpnPhiTienIch = new javax.swing.JPanel();
        jlbPhiTienIch = new javax.swing.JLabel();
        jpnPhiChungCu = new javax.swing.JPanel();
        jlbPhiChungCu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jpnRoot.setDoubleBuffered(false);

        jpnPhiXe.setBackground(new java.awt.Color(255, 255, 204));

        jlbPhiXe.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbPhiXe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPhiXe.setText("Phí gửi xe");

        javax.swing.GroupLayout jpnPhiXeLayout = new javax.swing.GroupLayout(jpnPhiXe);
        jpnPhiXe.setLayout(jpnPhiXeLayout);
        jpnPhiXeLayout.setHorizontalGroup(
            jpnPhiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhiXeLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jlbPhiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPhiXeLayout.setVerticalGroup(
            jpnPhiXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhiXeLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jlbPhiXe)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jpnPhiTienIch.setBackground(new java.awt.Color(255, 255, 204));

        jlbPhiTienIch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbPhiTienIch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPhiTienIch.setText("Phí tiện ích");

        javax.swing.GroupLayout jpnPhiTienIchLayout = new javax.swing.GroupLayout(jpnPhiTienIch);
        jpnPhiTienIch.setLayout(jpnPhiTienIchLayout);
        jpnPhiTienIchLayout.setHorizontalGroup(
            jpnPhiTienIchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhiTienIchLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jlbPhiTienIch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPhiTienIchLayout.setVerticalGroup(
            jpnPhiTienIchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhiTienIchLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlbPhiTienIch)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jpnPhiChungCu.setBackground(new java.awt.Color(255, 255, 204));

        jlbPhiChungCu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbPhiChungCu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPhiChungCu.setText("Phí chung cư");

        javax.swing.GroupLayout jpnPhiChungCuLayout = new javax.swing.GroupLayout(jpnPhiChungCu);
        jpnPhiChungCu.setLayout(jpnPhiChungCuLayout);
        jpnPhiChungCuLayout.setHorizontalGroup(
            jpnPhiChungCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhiChungCuLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jlbPhiChungCu)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jpnPhiChungCuLayout.setVerticalGroup(
            jpnPhiChungCuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhiChungCuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jlbPhiChungCu)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ");

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGap(563, 563, 563)
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnPhiTienIch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnPhiXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnPhiChungCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(585, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(139, 139, 139)
                .addComponent(jpnPhiChungCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jpnPhiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jpnPhiTienIch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(899, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlbPhiChungCu;
    private javax.swing.JLabel jlbPhiTienIch;
    private javax.swing.JLabel jlbPhiXe;
    private javax.swing.JPanel jpnPhiChungCu;
    private javax.swing.JPanel jpnPhiTienIch;
    private javax.swing.JPanel jpnPhiXe;
    private javax.swing.JPanel jpnRoot;
    // End of variables declaration//GEN-END:variables
}
