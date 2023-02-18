package MiniBookStore;

public class Book extends Product{
 //1-b: kitaplarin özellikleir product özellikleri author name,publisher,isbn

 private String authorName;
 private String publisher;
 private String isbn;


    public Book(String name, String price, int stock, String authorName, String publisher, String isbn) {
        super(name, price, stock);//->new Product(name,price,stock)
        this.authorName = authorName;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
