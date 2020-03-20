package com.bookhouse.bookHouse.books;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="books")
@Data


public class Book {
    public Book(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column(columnDefinition = "text")
    private String subtitle;

    @Column
    private String author;

    @Column
    private Date published;

    @Column
    private String publisher;

    @Column
    private int pages;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private String website;

    @Column
    private String in_cart;

    @Column
    private String price;

    @Column
    private String cover_img;

}
