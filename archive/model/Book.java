package model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String brief;
    private String publisher;
    private String content;
    private String category;

    public Book(int id, String title, String author, String brief, String publisher, String content, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "<tr>\n"
                + "                            <td></td>\n"
                + "                            <td>" + id + "</td>\n"
                + "                            <td>" + title + "</td>\n"
                + "                            <td>" + author + "</td>\n"
                + "                            <td>" + brief + "</td>\n"
                + "                            <td>" + publisher + "</td>\n"
                + "                            <td>" + content + "</td>\n"
                + "                            <td>" + category + "</td>\n"
                + "                        </tr>";
    }

}
