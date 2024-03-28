package com.example.buoi1.repository;

import com.example.buoi1.connect.HibernateUtils;
import com.example.buoi1.model.DanhMuc;
import com.example.buoi1.model.MauSac;
import com.example.buoi1.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamRepository {

    Session session;
    public ArrayList<SanPham> getList(){
        session = HibernateUtils.getFACTORY().openSession();
        //Truy van lay ra toan bo danh muc
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("FROM SanPham order by ngayTao asc ").list();
        session.close();
        return list;
    }

    public void add(SanPham sanPham){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public SanPham getDetail(Integer idSanPham){
        session = HibernateUtils.getFACTORY().openSession();
        //Truy van lay ra toan bo danh muc
        SanPham sanPham = (SanPham)  session.createQuery("FROM SanPham where id = :id_1")
                .setParameter("id_1", idSanPham).getSingleResult();
        session.close();
        return sanPham;
    }

    public void delete(SanPham sanPham){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sanPham);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
