package com.example.buoi1.repository;

import com.example.buoi1.connect.HibernateUtils;
import com.example.buoi1.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepository {

    Session session;

    public ArrayList<DanhMuc> getList(){
        session = HibernateUtils .getFACTORY().openSession();
        //Truy van lay ra toan bo danh muc
        ArrayList<DanhMuc> list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc").list();
        session.close();
        return list;
    }

    public static void main(String[] args) {
        ArrayList<DanhMuc> list = new DanhMucRepository().getList();
        for (DanhMuc danhMuc : list){
            System.out.println(danhMuc.toString());
        }
    }

    public void add(DanhMuc danhMuc){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(danhMuc);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public DanhMuc getDetail(String ma){
        session = HibernateUtils .getFACTORY().openSession();
        //Truy van lay ra toan bo danh muc
        DanhMuc danhMuc = (DanhMuc) session.createQuery("FROM DanhMuc where ma = :ma").setParameter("ma", ma).getSingleResult();
        session.close();
        return danhMuc;
    }

    public void delete(DanhMuc danhMuc){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(danhMuc);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public void update(DanhMuc dm){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(dm);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
