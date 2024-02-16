<h1>Definitions </h1>

<h3>@Entity</h3> <br>
    By annotating a class with @Entity, you're specifying that instances of this class should be mapped to a table in the database. The name of the table is typically derived from the name of the entity class unless explicitly specified.

<h3>@Id</h3> <br>
    Define the Primary key of a table when it create database using entity

<h3>@OneToMany (mapped by=?)</h3> <br>
    Define the Relationship between the tables and tell how to map it in the database

<h3>@JoinColumn</h3> <br>
    When you have a bidirectional association between two entities, one entity will own the relationship (the owning side) and the other entity will be the inverse side. The owning side typically has the @JoinColumn annotation to define the foreign key column.

<h3>@GeneratedValue</h3> <br>
    This used to generate primary key values for the entity.


        //01
        /*Query query = session.createQuery("select title from Book where publicationYear >= 2010");
        List resultList = query.getResultList();

        System.out.println(resultList.toString());;*/


        //02
        /*Query query = session.createQuery("update Book b set b.price = b.price * 1.1 where b.author.id = :authorId");
        query.setParameter("authorId", 1);

        int result = query.executeUpdate();
        System.out.println("Result: " + result);*/


        //03 
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