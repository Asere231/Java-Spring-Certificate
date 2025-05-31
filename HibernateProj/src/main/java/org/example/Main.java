package org.example;

import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

//      ========= Learning HQL to fetch data =========
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

//        SQL -> select * from laptop where ram=32
//        HQL -> from Laptop where ram=32

        String brand = "Asus";

//      Here it returns a list of Laptop objects
        TypedQuery<Laptop> query = session.createQuery("from Laptop where brand like ?1", Laptop.class);
        query.setParameter(1, brand);
        List<Laptop> laptops = query.getResultList();

        System.out.println(laptops);

//      Here it returns the laptops model as a String therefore we need to change the object type
        TypedQuery<String> query2 = session.createQuery("select model from Laptop where brand like ?1", String.class);
        query2.setParameter(1, brand);
        List<String> models = query2.getResultList();

        System.out.println(models);

//      Fetches brand and model from Laptop entities matching the brand pattern.
//      Uses JPA Tuple to avoid creating a custom class for partial selection.
//      Aliases ("as b", "as m") allow named access to tuple fields.
//
//      JPA (Java Persistence API) is a standard for mapping Java objects to relational database tables.
//      It lets you query and manipulate data using objects instead of raw SQL.

        TypedQuery<Tuple> query3 = session.createQuery("select brand as b, model as m from Laptop where brand like ?1", Tuple.class);
        query3.setParameter(1, brand);
        List<Tuple> brandAndModel = query3.getResultList();

        for (Tuple tuple : brandAndModel) {
            String m = tuple.get("m", String.class);
            String b = tuple.get("b", String.class);
            System.out.println(b + " " + m);
        }


        session.close();
        sf.close();


//      ======= DB Relationship with Hibernate ========

//        ++++ One-to-One Relationship ++++
//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setBrand("Asus");
//        l1.setModel("ROG");
//        l1.setRam(16);
//
//        Alien a1 = new Alien();
//        a1.setAid(101);
//        a1.setAname("Navin");
//        a1.setTech("Java");
//        a1.setLaptop(l1);
//        +++++++++++++++++++++++++++++++++++++


//        +++++ One-to-Many Relationship ++++
//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setBrand("Asus");
//        l1.setModel("ROG");
//        l1.setRam(16);
//
//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(32);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(2);
//        l3.setBrand("Apple");
//        l3.setModel("Macbook");
//        l3.setRam(64);
//
//        Alien a1 = new Alien();
//        a1.setAid(101);
//        a1.setAname("Navin");
//        a1.setTech("Java");
//        a1.setLaptops(Arrays.asList(l1, l2));
//
//        l1.setAlien(a1);
//        l2.setAlien(a1);
//        +++++++++++++++++++++++++++++++++++++


//        ++++++ Many-to-Many Relationship
//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setBrand("Asus");
//        l1.setModel("ROG");
//        l1.setRam(16);
//
//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(32);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(3);
//        l3.setBrand("Apple");
//        l3.setModel("Macbook");
//        l3.setRam(64);
//
//        Alien a1 = new Alien();
//        a1.setAid(101);
//        a1.setAname("Navin");
//        a1.setTech("Java");
//
//        Alien a2 = new Alien();
//        a2.setAid(102);
//        a2.setAname("Joshua");
//        a2.setTech("C++");
//
//        Alien a3 = new Alien();
//        a3.setAid(103);
//        a3.setAname("Malone");
//        a3.setTech("Rust");
//
//        a1.setLaptops(Arrays.asList(l1, l2));
//        a2.setLaptops(Arrays.asList(l2, l3));
//        a3.setLaptops(Arrays.asList(l1));
//
//        l1.setAliens(Arrays.asList(a1, a3));
//        l2.setAliens(Arrays.asList(a1, a2));
//        l3.setAliens(Arrays.asList(a2));
//
//        SessionFactory sf = new Configuration()
//                .addAnnotatedClass(org.example.Laptop.class)
//                .addAnnotatedClass(org.example.Alien.class)
//                .configure()
//                .buildSessionFactory();
//
//        Session session = sf.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.persist(a1);
//        session.persist(a2);
//        session.persist(a3);
//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);
//
//        transaction.commit();
//
//        System.out.println(a1);
//
//        session.close();
//        sf.close();
//        +++++++++++++++++++++++++++++++++++++


        /*

        ========== Basic Hibernate ===========

        Student s1 = new Student();

        s1.setsName("Victor");
        s1.setRollNo(106);
        s1.setsAge(26);

        Student s2 = null;

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration().addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

//        ========= This is to Store in DB =========
//        session.persist(s1);
//        transaction.commit();

//        ========= This is to Fetch from DB ========
//        s2 = session.find(Student.class, 102);

//        ====== This is to Update or Store in DB (depending on if it exists or not) ======
//        session.merge(s1);
//        transaction.commit();

//        ======= This is to Delete from DB =====
//        session.remove(s1);
//        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);

         */

    }
}