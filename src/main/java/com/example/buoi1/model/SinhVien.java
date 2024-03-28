package com.example.buoi1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    private String maSV;
    private String tenSV;
    private String diaChi;
    private Integer tuoi;
    private String gioiTinh;
    private String tenLop;

}
