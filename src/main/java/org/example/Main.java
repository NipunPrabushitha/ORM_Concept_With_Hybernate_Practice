package org.example;

import org.example.cofig.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("Ishani", "Ekanayake");

        Student student = new Student();
        student.setId(4);
        student.setName(fullName);
        student.setAddress("Mathara");

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Udara San");
        teacher.setAddress("Panadura");


        //Open the Transaction
        Transaction transaction = session.beginTransaction();
        session.save(student);  // save done
       /* session.update(student);*/ //update done
        /*session.delete("1",student);*/ //delete done
        //Student student1 = session.get(Student.class, 2);//get done
        session.save(teacher); // add another class and save data
        transaction.commit();
        //System.out.println(student1);
        session.close();
    }
}