package MiniBookStore;

import java.util.Scanner;

public class MiniBookStore {

    /*
    Proge:
    online bir kitap market icin ürün yönetim uygulamasi
    Kitap markette kitap ve defter satisi olacak, ancak ürün cesidi eklenebilir

    Kitap özellikleri: id,isim,birim fiyat,stok,yazar adi,yayin evi,isbn no.
    Defter özellikleri:id,isim,birim fiyat,stok,marka,yaprak sayisi,ürün kodu

    Kullanici ilgili katogorideki ürünleri listeleyebilmeli
    Kullanici katogorilere göre ürün ekleyebilmeli,ürün mevcutsa uyari verilmeli
    Kullanici ürünleri benzersit numaralara göre silenbilmeli
    Kullanici ürünleri marka(defter) veya yayinvine(kitap) göre filtreleyip listelebilmeli
     */

    public static void main(String[] args) {

        enter();


    }

    //1-product,book,notebook
    private static void enter() {
        System.out.println("---------MiniBook Store-------");
        Scanner inp = new Scanner(System.in);
        int select;
        do {
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1-Defterler");
            System.out.println("2-Kitaplar");
            System.out.println("0-Cikis");
            select = inp.nextInt();
            inp.nextLine();
            ProductService service;
            switch (select) {
                case 1:
                    service=new BookService();
                    service.processMenü();
                    break;
                case 2:
                    service=new NotebookService();
                    service.processMenü();
                    break;
                case 0:
                    System.out.println("Iyi Günler.");
                    break;
                default:
                    System.out.println("Hatali Giris!!!");
            }
        } while (select != 0);

    }


}

