public class QinShiHuang {
    private static QinShiHuang qinShiHuang;

    private QinShiHuang() {
        System.out.println("秦始皇驾到");
    };

    public static QinShiHuang getQinShiHuang() {
        if (qinShiHuang==null) {
            qinShiHuang = new QinShiHuang();
        }

        return qinShiHuang;
    };
}
