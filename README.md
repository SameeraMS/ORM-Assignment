//01
Query query = session.createQuery("select title from Book where publicationYear >= 2010");
List resultList = query.getResultList();

System.out.println(resultList.toString());;

//02
Query query = session.createQuery("update Book b set b.price = b.price * 1.1 where b.author.id = :authorId");
query.setParameter("authorId", 1);

int result = query.executeUpdate();
System.out.println("Result: " + result);

//03 මෙක වැරදියි
deleteAuthor(session,"3");

//04
Query query = session.createQuery("SELECT AVG(b.price) FROM Book b");
Double averagePrice = (Double) query.getSingleResult();;
System.out.println(averagePrice);

//05
Query query = session.createQuery("SELECT a.id, COUNT(b.id) FROM Author a JOIN Book b on a.id = b.author.id GROUP BY a.id");
List<Object[]> resultList = query.getResultList();

for (Object[] objects : resultList) {
System.out.println(objects[0] + " : " + objects[1]);
}

//06
Query query = session.createQuery("SELECT b.title FROM Book b JOIN Author a on b.author.id = a.id WHERE a.country = :countryName");
query.setParameter("countryName", "japan");
List resultList = query.getResultList();

for (Object o : resultList) {
System.out.println(o);
}


//10
Query query = session.createQuery("SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Book b WHERE a.id = b.author.id ) > ( SELECT AVG(authorBookCount) FROM ( SELECT COUNT(b.id) AS authorBookCount FROM Book b GROUP BY b.author.id ))");
List<String> resultList = query.getResultList();

for (String s : resultList) {
System.out.println(s);
}