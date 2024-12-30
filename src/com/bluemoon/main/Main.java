package com.bluemoon.main;

import com.bluemoon.dao.DBConnect;
import com.bluemoon.view.DangNhapJDialog;
import com.bluemoon.view.MainJFrame;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
    //    new MainJFrame().setVisible(true);
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
