package MiniBookStore;

public class Notebook extends Product {
    //1-c:product özeliklleri,brand,ürün kodu,sayfa sayisi(sheet)

    private String marka;
    private int sheet;
    private int kod;

    public Notebook(int id, String name, String price, int stok, String marka, int sheet, int kod) {
        super(id, name, price, stok);
        this.marka = marka;
        this.sheet = sheet;
        this.kod = kod;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getSheet() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet = sheet;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }
}
