package com.example.dig.dig_t1;

/**
 * Created by rodrigo on 11/09/16.
 */
public class Comment {

    private String authorName;
    private String comment;
    private String timeComment;
    private int photoAuthor;

    public Comment(String authorName, String comment, String timeComment, int photoAuthor) {
        this.authorName = authorName;
        this.comment = comment;
        this.photoAuthor = photoAuthor;
        this.timeComment = timeComment;
    }

    public String getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(String timeComment) {
        this.timeComment = timeComment;
    }

    public int getPhotoAuthor() {
        return photoAuthor;
    }

    public void setPhotoAuthor(int photoAuthor) {
        this.photoAuthor = photoAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
