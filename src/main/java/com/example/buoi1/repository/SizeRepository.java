package com.example.buoi1.repository;

import com.example.buoi1.connect.HibernateUtils;
import com.example.buoi1.model.Size;
import org.hibernate.Session;

import java.util.ArrayList;

public class SizeRepository {

    Session session;

    public ArrayList<Size> getList(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<Size> list = (ArrayList<Size>) session.createQuery("FROM Size ").list();
        session.close();
        return list;
    }
}
