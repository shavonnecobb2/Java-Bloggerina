package com.shavonne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="blogentry")
public class BlogEntry {
    @Id
    @Column(name="Entry_Id")
    private Integer entryId;

    @Column(name="Entry_Title")
    private String entryTitle;

    @Column(name="Entry_Author")
    private String entryAuthor;

    @Column(name = "Entry_Date")
    private String entryDate;

    @Column(name="Entry_Post")
    private String entryPost;

    public Integer getEntryId() {
        return entryId;
    }

//    public void setEntryId(Integer entryId) {
//        this.entryId = entryId;
//    }

    public String getEntryTitle() {
        return entryTitle;
    }

//    public void setEntryTitle(String entryTitle) {
//        this.entryTitle = entryTitle;
//    }

    public String getEntryAuthor() {
        return entryAuthor;
    }

//    public void setEntryAuthor(String entryAuthor) {
//        this.entryAuthor = entryAuthor;
//    }

    public String getEntryDate() {
        return entryDate;
    }

//    public void setEntryDate(String entryDate) {
//        this.entryDate = entryDate;
//    }

    public String getEntryPost() {
        return entryPost;
    }

//    public void setEntryPost(String entryPost) {
//        this.entryPost = entryPost;
//    }

    @Override
    public String toString() {
        return entryTitle + ": by " + entryAuthor;
    }
}
