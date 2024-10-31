/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import Utils.DateTimeUtils;
import java.io.Serializable;
import java.util.List;

public class Phieu implements Serializable{

    private String maPhieu;
    private String thoiGianTao;
    private ArrayList<ChiTietPhieu> CTPhieu;
    private double tongThanhToan;

    public Phieu() {
    }

    public Phieu(String maPhieu, String thoiGianTao, ArrayList<ChiTietPhieu> CTPhieu, double tongThanhToan) {
        this.maPhieu = maPhieu;
        this.thoiGianTao = thoiGianTao;
        this.CTPhieu = CTPhieu;
        this.tongThanhToan = tongThanhToan;
    }
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(String thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public ArrayList<ChiTietPhieu> getCTPhieu() {
        return CTPhieu;
    }

    public void setCTPhieu(ArrayList<ChiTietPhieu> CTPhieu) {
        this.CTPhieu = CTPhieu;
    }

    public double getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(double tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }
   
}
