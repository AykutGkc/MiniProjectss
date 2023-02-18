package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService implements ProductService {
    Scanner inp = new Scanner(System.in);
    //3-Kitaplari saklamak icin list olustur

    List<Book> books = new ArrayList<>();

    //4:baslangicat sistemde mevcut kitaplar olsun.Test etmek icin.
    public BookService (){
        Book book1=new Book("Fareler ve insanar"," Lira",15,"J.Steinback","Penguen","A111");
        Book book2=new Book("Sefiller","150 Lira",5,"V.Hugo","Penguen","A222");
        Book book3=new Book("Suc ve Ceza","120 Lira",15,"Dostoyevski","Dream","A333");
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);
    }

//5:Islem menüsü
    @Override
    public void processMenü() {
        int choice;
        do {

            System.out.println("-------------------------------");
            System.out.println("1-Kitaplari listele");
            System.out.println("2-Kitap ekleme");
            System.out.println("3-Kitap silme");
            System.out.println("4-Kitap filtreleme");
            System.out.println("0-Geri dön");
            System.out.println("Seciminiz:");
            choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Yayinevi:");
                    String publisher=inp.nextLine();
                    filterProducts(publisher);
                    break;
                case 0:
                    System.out.println("Ana Menüye yönlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Hatali giris!!!");
                    break;
            }
        } while (choice != 0);

    }

    //6:kitaplati formatla yazdiralim
    @Override
    public void listProduct() {
        System.out.println("-------------------------------------------------");
        System.out.printf("%-2 | &-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n","ID","Kitap Adi","Yazar Adi",
                "Yayinevi","ISNB","Birim fiyati","Stok");
        System.out.println("-------------------------------------------------");
        this.books.forEach(book->System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock()));
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    @Override
    public void addProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void filterProducts(String filter) {

    }
    //2-a: bookla ilgili islemler


}
