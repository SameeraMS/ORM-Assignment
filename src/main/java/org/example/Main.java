package org.example;

import jakarta.persistence.Query;
import org.example.config.FactoryConfiguration;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*Author jhon = new Author("1", "Jhon","USA", null);
        Author tom = new Author("2", "Tom","UK", null);
        Author mark = new Author("3", "Mark","India", null);
        Author peter = new Author("4", "Peter", "japan", null);

        Book book1 = new Book("1", "Book 1", 2005, 1000.0, jhon);
        Book book2 = new Book("2", "Book 2", 2010, 2000.0, jhon);
        Book book3 = new Book("3", "Book 3", 2015, 3000.0, tom);
        Book book4 = new Book("4", "Book 4", 2020, 4000.0, mark);
        Book book5 = new Book("5", "Book 5", 2025, 5000.0, peter);

        List<Book> list = List.of(book1, book2);

        jhon.setBooks(list);
        tom.setBooks(List.of(book3));
        mark.setBooks(List.of(book4));
        peter.setBooks(List.of(book5));

        session.save(jhon);
        session.save(tom);
        session.save(mark);
        session.save(peter);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);*/


        //01
        /*Query query = session.createQuery("select title from Book where publicationYear >= 2010");
        List resultList = query.getResultList();

        System.out.println(resultList.toString());;*/


        //02
        /*Query query = session.createQuery("update Book b set b.price = b.price * 1.1 where b.author.id = :authorId");
        query.setParameter("authorId", 1);

        int result = query.executeUpdate();
        System.out.println("Result: " + result);*/


        //03 මෙක වැඩ නැ
        /*deleteAuthor(session,"3");*/


        //04
        /*Query query = session.createQuery("SELECT AVG(b.price) FROM Book b");
        Double averagePrice = (Double) query.getSingleResult();;
        System.out.println(averagePrice);*/


        //05
        /*Query query = session.createQuery("SELECT a.id, COUNT(b.id) FROM Author a JOIN Book b on a.id = b.author.id GROUP BY a.id");
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            System.out.println(objects[0] + " : " + objects[1]);
        }*/


        //06
        /*Query query = session.createQuery("SELECT b.title FROM Book b JOIN Author a on b.author.id = a.id WHERE a.country = :countryName");
        query.setParameter("countryName", "japan");
        List resultList = query.getResultList();

        for (Object o : resultList) {
            System.out.println(o);
        }*/


        //07
        //definitions in Readme.md File


        //10
       /* Query query = session.createQuery("SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Book b WHERE a.id = b.author.id ) > ( SELECT AVG(authorBookCount) FROM ( SELECT COUNT(b.id) AS authorBookCount FROM Book b GROUP BY b.author.id ))");
        List<String> resultList = query.getResultList();

        for (String s : resultList) {
            System.out.println(s);
        }*/



        transaction.commit();
        session.close();

    }

    private static void deleteAuthor(Session session, String id) {

        Author author = session.get(Author.class, id);

        Query query = session.createQuery("delete from Author a where a.id = :authorId");
        query.setParameter("authorId", author.getId());

        int result = query.executeUpdate();
        System.out.println(result);

    }
}