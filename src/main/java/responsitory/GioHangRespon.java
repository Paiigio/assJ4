package responsitory;

import Util.HibernateUtil;
import entity.GioHang;
import entity.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class GioHangRespon {
    public ArrayList<GioHang> getALlGH() {
        ArrayList<GioHang> listSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang ");
            listSP = (ArrayList<GioHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public void add(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Update(GioHang gh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(gh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public GioHang getGHbyID(String id) {
        GioHang gioHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang g where g.khachHang.id=: id and g.tinhTrang=0");
            query.setParameter("id", id);
            gioHang = (GioHang) query.getSingleResult();
            return gioHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GioHang getGHbyIDbykh(String id, String idKH) {
        GioHang gioHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang g where g.id=:id and g.khachHang.id=:idKH");
            query.setParameter("id", id);
            query.setParameter("idKH", idKH);
            gioHang = (GioHang) query.getSingleResult();
            return gioHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new GioHangRespon().getGHbyID("3E3FE381-7C58-4782-AD64-A3CAD10B05FF"));
    }


}
