package com.trainibit.labs.spring_boot_hibernate.util;

import com.trainibit.labs.spring_boot_hibernate.model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory=new
            Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown (){
        getSessionFactory().close();
    }
}
