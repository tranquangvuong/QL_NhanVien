package com.codelean.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "phongbans")
public class Phongban {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;

    private String tenphongban;

    @OneToMany(mappedBy = "phongban")
    private Set<Nhanvien> nhanviens;

    public Phongban() {
    }

    public Phongban(String tenphongban){
        this.tenphongban=tenphongban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenphongban() {
        return tenphongban;
    }

    public void setTenphongban(String tenphongban){
        this.tenphongban=tenphongban;
    }

    public Set<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public void setNhanviens(Set<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }
}
