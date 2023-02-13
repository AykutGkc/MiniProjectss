package BiletReservasyon;

import java.util.Scanner;

public class BiletRezervasyon {

    /*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.
         Mesafe başına ücret 1 Lira / km olarak alın.(Gidiş-Dönüş için *2)
         Tekli Koltuk ücreti:Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 daha fazladır(1.2 Lira).
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;
        Koltuk numaralri 1-32 arasi olsun.
        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
       2-Yaş indirimi:
        Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 13-24 yaşları arasında ise son bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */
    public static void main(String[] args) {

        //1- Bilet rezervasyonu icin otobüs objesi olusturalim.
        Bus bus = new Bus("34 ASD 74"); // "1", "2", "3", "4", "5", "6", "7"... "32"

        //4-bilet objesi olusturalim
        Bilet bilet = new Bilet();

    }

    public static void start(Bus bus){
        Scanner scan=new Scanner(System.in);
        do {
            //Kullanicidan bilgileri alalim
            System.out.println("Bilet Rezervasyonu Sistemine Hosgeldiniz...");
            System.out.println("Lütfen gidilecek mesafe bilgisini KM olarak giriniz:");
            double distance=scan.nextDouble();

            System.out.println("Lütfen yolculuk tipini seciniz. ");
            System.out.println("1.Tek Yön");
            System.out.println("2.Gidis-Dönüs");
            int type=scan.nextInt();

            System.out.println("Lütfen yssinizi giriniz:");
            int age=scan.nextInt();

            System.out.println("Lütfen Koltuk No Seciniz:");
            System.out.println("(Tekli koltuk ücreti %20 daha fazladir.)");
            System.out.println(bus.seats);
            int seat=scan.nextInt();

            //7-Secilen koltuk numaarasini listeden kaldiralim.
            bus.seats.remove(String.valueOf(seat));
            //8-Kullanicidan alinan degerler gecerli mi
            boolean check=type==1 || type==2;
            if (distance>0 && age>0 && check){
                //9.Blet fiyatini hesaplayalim

            }else{
                System.out.println("Hatali giris yaptiniz!!!");
            }

        }while (true);
    }

}
