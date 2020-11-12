public class QinShiHuangT2 {
    private /*volatile*/ static QinShiHuangT2 qinShiHuang;

    private QinShiHuangT2() {
        System.out.println("秦始皇驾到");
    };

    public static QinShiHuangT2 getQinShiHuang() {
        if (qinShiHuang==null) {
            synchronized (QinShiHuangT2.class) {
                if (qinShiHuang==null) {
                    qinShiHuang = new QinShiHuangT2();
                }
            }
        }

        return qinShiHuang;
    };
}
