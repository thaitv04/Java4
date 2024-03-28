package com.example.buoi1.repository;

import com.example.buoi1.connect.HibernateUtils;
import com.example.buoi1.model.MauSac;
import org.hibernate.Session;

import java.util.ArrayList;

public class MauSacRepository {

    Session session;
    public ArrayList<MauSac> getList(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<MauSac> list = (ArrayList<MauSac>) session.createQuery("FROM MauSac ").list();
        session.close();
        return list;
    }
}
