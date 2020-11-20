package mapreduce.order;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class OrderGroupingComparator extends WritableComparator {

    public OrderGroupingComparator() {
        super(OrderBean.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        // 只要id相同，就认为是相同的key
        OrderBean beana = (OrderBean) a;
        OrderBean beanb = (OrderBean) b;

        int res = 0;
        if (beana.getOrder_id() > beanb.getOrder_id()) {
            res = 1;
        } else if (beana.getOrder_id() < beanb.getOrder_id()) {
            res = -1;
        }

        return res;
    }
}
