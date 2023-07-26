package dev.ctrlspace.bootcamp2306twitterrestapi.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class comments {
    @Id
    @GeneratedValue
    private Long comment_id;

    public void setComment_id(Long commentId) {
        this.comment_id = commentId;
    }

    public Long getComment_id() {
        return comment_id;
    }
}
