package mapreduce.serial;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FLowBean implements Writable {
    // 上行流量
    private Long up;
    // 下行流量
    private Long down;
    // 总流量
    private Long sum;

    // 空参构造，为了后续反射用
    public FLowBean() { super();}

    public FLowBean(Long up, Long down) {
        this.up = up;
        this.down = down;
        sum = up + down;
    }

    // 序列化
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(up);
        dataOutput.writeLong(down);
        dataOutput.writeLong(sum);
    }

    // 反序列化
    public void readFields(DataInput dataInput) throws IOException {
        // 必须和序列化的顺序一致
        up = dataInput.readLong();
        down = dataInput.readLong();
        sum = dataInput.readLong();
    }



    @Override
    public String toString() {
        return up + " " + down + " " + sum;
    }

    public Long getUp() {
        return up;
    }

    public void setUp(Long up) {
        this.up = up;
    }

    public Long getDown() {
        return down;
    }

    public void setDown(Long down) {
        this.down = down;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public void set(Long up, Long down) {
        this.up = up;
        this.down = down;
        sum = up + down;
    }

    public int compareTo(FLowBean o) {
        return this.sum > o.getSum() ? -1: 1;
    }
}
