package com.codelean.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nhanviens")
public class Nhanvien {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String manhanvien;
    private String hoten;
    private Date ngaysinh;
    private int capdo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Phongban phongban;

    public Nhanvien(){}

    public Nhanvien(String manhanvien,String hoten,Date ngaysinh,int capdo){
        this.id=id;
        this.manhanvien=manhanvien;
        this.hoten=hoten;
        this.ngaysinh=ngaysinh;
        this.capdo=capdo;
    }

    @Override
    public String toString() {
        return String.format("Nhanvien[id=%d, manhanvien='%s',tenphongban='%s',hoten='%s',ngaysinh='%s',capdo='%s']",id,manhanvien,hoten,ngaysinh,capdo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManhanvien(){
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getCapdo() {
        return capdo;
    }

    public void setCapdo(int capdo) {
        this.capdo = capdo;
    }

    public Phongban getPhongban(){
        return phongban;
    }

    public void setPhongban(Phongban phongban) {
        this.phongban = phongban;
    }
}
