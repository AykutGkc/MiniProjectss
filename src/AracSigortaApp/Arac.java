package AracSigortaApp;

import java.util.Scanner;

public class Arac {
    //tipi,prim
    public String type;//field/feature/özellik
    public int prim;

    public void countPrim(int term){
        if ("otomobil".equals(this.type)) {
            this.prim = term == 1 ? 2000 : 2500;
        } else if ("kamyon".equals(this.type)) {
            this.prim = term == 1 ? 3000 : 3500;
        } else if ("motosiklet".equals(this.type)) {
            this.prim = term == 1 ? 1500 : 1750;
        } else if ("otobüs".equals(this.type)) {
            countPrimBus(term);
        } else {
            System.out.println("Hatalı giriş!!!");
            this.prim = 0;
        }
    }

    private void countPrimBus(int term){
        Scanner inp=new Scanner(System.in);
        System.out.println("Otobüs tipini giriniz:");
        System.out.println("1.18-30 koltuk");
        System.out.println("2.30 koltuk veya üstü");
        int busType=inp.nextInt();
        switch (busType){
            case 1:
                this.prim=term==1 ? 4000 : 4500;
                break;
            case 2:
                this.prim=term==1 ? 5000 : 5500;
                break;
            default:
                System.out.println("Hatalı giriş!!!");
                this.prim=0;
                break;
        }
    }
}

