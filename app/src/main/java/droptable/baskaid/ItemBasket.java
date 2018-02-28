package droptable.baskaid;

/**
 * Created by Yean on 21/02/2018.
 */

public class ItemBasket {
    private int id;
    private String title;
    private double price;
    private int imageid;

    public ItemBasket(int id, String title, double price, int imageid) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageid = imageid;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemBasket that = (ItemBasket) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (imageid != that.imageid) return false;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + title.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + imageid;
        return result;
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
