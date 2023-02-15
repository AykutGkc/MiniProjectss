package RestaurantBillGenerator;

public class Dish {
    //yiyeceklerin fiytlari okunsun fakat degistirilemez olsun.

    private int code;
    private String name;
    private double price;

    //yiyecek olustururken özellikleri set edilsin
    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //dish objesini yazdirmak icin


    @Override
    public String toString() {
        return "Dish{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
