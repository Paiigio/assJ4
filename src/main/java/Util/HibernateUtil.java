package Util;
import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123a");
        properties.put(Environment.SHOW_SQL, "true");

//        properties.put(Environment.HBM2DDL_AUTO, "create");
        conf.setProperties(properties);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(CTSanPham.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
