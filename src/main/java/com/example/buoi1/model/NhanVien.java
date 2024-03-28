package com.example.buoi1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {

    private String maNV;
    private String tenNV;
    private String chucVu;
    private Integer tuoi;
    private String gioiTinh;
}
