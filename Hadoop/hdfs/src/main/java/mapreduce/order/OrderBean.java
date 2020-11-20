package mapreduce.order;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements WritableComparable<OrderBean> {
    private int order_id;
    private double price;

    public OrderBean() {}

    public int compareTo(OrderBean o) {
        int res = 0;

        // 先按照id升序，如果相同，按价格降序
        if (order_id > o.getOrder_id()) {
            res = 1;
        } else if (order_id < o.getOrder_id()) {
            res = -1;
        } else {
            if (price > o.getPrice()) {
                res = -1;
            } else if(price < o.getPrice()) {
                res = 1;
            }
        }
        return res;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(order_id);
        dataOutput.writeDouble(price);
    }

    public void readFields(DataInput dataInput) throws IOException {
        order_id = dataInput.readInt();
        price = dataInput.readDouble();
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void set(int order_id, double price) {
        this.order_id = order_id;
        this.price = price;
    }

    @Override
    public String toString() {
        return order_id +" " + price ;
    }
}
