package droptable.baskaid;

/**
 * Created by Yean on 21/02/2018.
 */

public class BasketItem {
    private int id;
    private String title;
    private double price;
    private int imageid;

    public BasketItem(int id, String title, double price, int imageid) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageid = imageid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getImageid() {
        return imageid;
    }
}
