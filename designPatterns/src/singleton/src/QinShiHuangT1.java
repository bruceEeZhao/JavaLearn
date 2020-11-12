public class QinShiHuangT1 {
    private static QinShiHuangT1 qinShiHuang;

    private QinShiHuangT1() {
        System.out.println("秦始皇驾到");
    };

    public static QinShiHuangT1 getQinShiHuang() {
        if (qinShiHuang==null) {
            synchronized (QinShiHuangT1.class) {
                qinShiHuang = new QinShiHuangT1();
            }
        }

        return qinShiHuang;
    };
}
