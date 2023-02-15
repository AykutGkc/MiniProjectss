package RestaurantBillGenerator;

public class Order {
    public static int count=999;
    public int orderCode;
    public int numOfDish;
    public double orderPrice;
    public Dish dish;

    //8_yemek ve adat parametreleri ile obje olusturma
    public Order(Dish dish, int numOfDish){
        count++;
        this.orderCode=count;
        this.dish=dish;
        this.numOfDish=numOfDish;

    }
    //9-Sipraisin fiyatini hesaplama
    public void setPrice(){
        this.orderPrice=this.dish.getPrice()*this.numOfDish;
    }
}
