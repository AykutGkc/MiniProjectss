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
   //7) yeni kitap ekle
    @Override
    public void addProduct() {
        System.out.println("ISBN: ");
        String isbn=inp.nextLine();
        boolean isExists=false;
        for(Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Bu kitap Sistemde zaten kayitli.Lütfen ürün güncelleme yapiniz.");
                isExists=true;
                break;
            }
            if (!isExists){
                System.out.println("Kitap adi:");
                String name=inp.nextLine();
                System.out.println("Yazar adi:");
                String author=inp.nextLine();
                System.out.println("Yayinevi:");
                String publisher=inp.nextLine();
                System.out.println("Birim fiyatri");
                String price=inp.nextLine();
                System.out.println("Stok:");
                int stock= inp.nextInt();
                inp.nextLine();
                Book newBook=new Book(name,price,stock,author,publisher,isbn);
                this.books.add(newBook);
            }
            listProduct();
        }

    }

    //UpdateProduct():Stok artirma/azaltma,birim fiyat==>ödev

    //8:kullanicidan alinan id ile ürünü bulalim ve listeden kaldiralim
    @Override
    public void deleteProduct() {
        boolean isExists=true;
        System.out.println("Kitap id: ");
        int id= inp.nextInt();
        for(Book book : this.books){
            if (book.getId()==id){
                isExists=true;
                this.books.remove(book);
                System.out.println("Ürün silindi");
            }else{
             isExists=false;
            }
        }
        if (!isExists){
            System.out.println("Ürün bulunamadi.");
        }

    }

    //9:kitaplari yayinevlerine göre siralama

    @Override
    public void filterProducts(String filter) {
      /*  this.books.stream().
                filter(book -> book.getPublisher().equalsIgnoreCase(filter)).
                forEach(book->System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock()));
                        */
        int counter=0;
        for(Book book:this.books){
            if(book.getPublisher().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),book.getIsbn(),book.getPrice(),book.getStock());
                counter++;
            }
        }
        if(counter==0){
            System.out.println("Ürün bulunamadi");
        }
    }
    //2-a: bookla ilgili islemler


}
