package responsitory;

import Util.HibernateUtil;
import entity.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class ChucVuResponsitory {
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public ArrayList<ChucVu> getAll() {
        ArrayList<ChucVu> listCV = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("from ChucVu  ");

            listCV = (ArrayList<ChucVu>) query.getResultList();
            Collections.sort(listCV, (ChucVu o1, ChucVu o2) -> catMa(o2.getMaCV()) < catMa(o1.getMaCV()) ? 1 : -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCV;
    }

    public ChucVu getById(String id) {
        ChucVu chucVu = new ChucVu();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //c1
            chucVu = session.get(ChucVu.class, id);
            //c2
//            Query query=session.createQuery("from SanPham  where  id =:id");
//            query.setParameter("id",id);
//            sanPham= (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return chucVu;
    }

    public void delete(ChucVu sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(ChucVu sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(ChucVu sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sp);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//    public static void main(String[] args) {
//        ChucVu spChucVu = new ChucVuResponsitory().getById("AED7AD67-71CC-4A46-8BFE-3D053CE58372");
//        System.out.println(spChucVu.toString());
//    }



}
