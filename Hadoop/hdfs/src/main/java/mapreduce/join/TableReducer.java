package mapreduce.join;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class TableReducer extends Reducer<Text, TableBean, TableBean, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Context context) throws IOException, InterruptedException {
        // 存储产品数量结合
        ArrayList<TableBean> beans = new ArrayList<TableBean>();
        // 存放公司集合
        TableBean company = new TableBean();

        for (TableBean bean:values
             ) {
            if (bean.getFlag().equals("amount")) {
                TableBean dst = new TableBean();
                try {
                    BeanUtils.copyProperties(dst, bean);
                    beans.add(dst);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    BeanUtils.copyProperties(company, bean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }

        for (TableBean bean: beans
             ) {
            bean.setPname(company.getPname());
            context.write(bean, NullWritable.get());
        }
    }
}
