package BiletReservasyon;

public class Bilet {
    //mesafe,yolculuk tipi, fiyat, koltuk no

    public double distance;
    public int typeNo;
    public double price;
    public int seatNo;

    //5-bileti yazdiralim

    public void printBilet(Bus bus){
        System.out.println("Toplam tutar: " + this.price);
        System.out.println("-----Bilet detayi----------");
        System.out.println("Otobüs plaka : "+ bus.numberPlate);
        System.out.println("Mesafe       : "+this.distance);
        System.out.println("Yolculuk Tipi: "+ (this.typeNo==1 ? "Tek Yön" : "Gidis-Dönüs"));
        System.out.println("Koltuk numarasi: "+ this.seatNo);
        System.out.println("Keyifli Yolculukar dileriz...");
    }


}
