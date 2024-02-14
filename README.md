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
    
    