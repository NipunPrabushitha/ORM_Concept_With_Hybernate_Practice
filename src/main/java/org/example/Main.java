package org.example;

import org.example.cofig.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("Tashini", "Madubhani");
        Student student = new Student();
        student.setId(3);
        student.setName(fullName);
        student.setAddress("Mathugama");

        //Open the Transaction
        Transaction transaction = session.beginTransaction();
        /*session.save(student);*/  // save done
       /* session.update(student);*/ //update done
        /*session.delete("1",student);*/ //delete done
        Student student1 = session.get(Student.class, 3);//get done
        transaction.commit();
        System.out.println(student1);
        session.close();
    }
}