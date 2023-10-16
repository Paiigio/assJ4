package responsitory;

import Util.HibernateUtil;
import entity.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class KhachHangResponsitory {

    private int catMa(String ma) {
        String chuSo = ma.substring(3);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public ArrayList<KhachHang> getAllKH(){
        ArrayList<KhachHang>list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from  KhachHang ");
            list= (ArrayList<KhachHang>) query.getResultList();
            Collections.sort(list, (KhachHang o1, KhachHang o2) -> catMa(o2.getMa()) < catMa(o1.getMa()) ? 1 : -1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang findID(String id){
        KhachHang khachHang= new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            khachHang=session.get(KhachHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }
    public void delete(KhachHang kh){
        Transaction transaction= null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(KhachHang kh){
        Transaction transaction= null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(KhachHang kh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(kh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public KhachHang login(String user, String pass){
        KhachHang khachHang= new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql="from  KhachHang where ma =: tk and matKhau =: mk";
            Query query =session.createQuery(hql);
            query.setParameter("tk",user);
            query.setParameter("mk",pass);
            khachHang= (KhachHang) query.getSingleResult();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return khachHang;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangResponsitory().findID("18152946-2A0B-4BE3-A997-2E347082AEE3"));

    }

}
