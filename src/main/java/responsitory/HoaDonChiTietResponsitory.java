package responsitory;

import Util.HibernateUtil;
import entity.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class HoaDonChiTietResponsitory {
    public void add(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<HoaDonChiTiet> getHDCTbyID(String id){
        ArrayList<HoaDonChiTiet> listSP=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from HoaDonChiTiet where hoaDon.id=:id");
            query.setParameter("id",id);
            listSP= (ArrayList<HoaDonChiTiet>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }

    public static void main(String[] args) {
        System.out.println(new HoaDonChiTietResponsitory().getHDCTbyID("587984FD-8724-40CE-951E-C6D8258133CB"));
    }
}
