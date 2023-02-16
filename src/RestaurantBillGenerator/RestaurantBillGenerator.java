package RestaurantBillGenerator;

/*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/


import java.util.Scanner;

public class RestaurantBillGenerator {
    public static void main(String[] args) {
        getSelectionMenü();


    }
    //1-islem secimi icin menü gösterelim

    public static void getSelectionMenü() {
        Scanner inp = new Scanner(System.in);
        DishService dishService=new DishService();//Listede 10 tane dish var.
        OrderService orderService=new OrderService();
        //2-Menü tekrar tekrar gösterilsin
        //3-Yiyecek icin class olustur
        //7-Siprais icin class olustur
        int select = -1;

        while (select != 0) {
            System.out.println("----------------------------------------------");
            System.out.println("  ***Lezzet Restaurant Siparis Uygulamasi***  ");
            System.out.println("1-Menü");
            System.out.println("2-Siparis Gir ");
            System.out.println("3-Siparis Iptal et");
            System.out.println("4-Hesap Olustur");
            System.out.println("0-Cikis");
            System.out.println("Seciminiz: ");
            select = inp.nextInt();
            System.out.println("----------------------------------------------");
            switch (select) {
                case 1:
                    //Menü göster
                   dishService.showMenü();
                    break;
                case 2:
                    //Soparis olustur
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    //siparis iptal
                    orderService.deleteOrder();
                    break;
                case 4:
                    //Hesap
                    orderService.printBill();
                    break;
                case 0:
                    System.out.println("Iyi Günler Dileriz.");
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz");
            }
        }

    }
}
