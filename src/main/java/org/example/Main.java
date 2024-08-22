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

        FullName fullName = new FullName("Nipun", "Prabushitha");
        Student student = new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Gampaha");

        //Open the Transaction
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
}