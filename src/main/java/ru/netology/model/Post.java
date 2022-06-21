package ru.netology.model;

public class Post {
    private long id;
    private String content;
    private boolean remove;

    public Post() {
    }

    public Post(long id, String content, boolean remove) {
        this.id = id;
        this.content = content;
        this.remove = remove;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getRemoved() {
        return remove;
    }

    public void setRemoved(boolean remove) {
        this.remove = remove;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
