package responsitory;

import Util.HibernateUtil;
import entity.CuaHang;
import entity.MauSac;
import entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class SanPhamResponsitory {

    public ArrayList<SanPham> getALlSP(){
        ArrayList<SanPham> listSP=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from SanPham ");
            listSP= (ArrayList<SanPham>) query.getResultList();
            Collections.sort(listSP, (SanPham o1, SanPham o2) -> catMa(o2.getMa()) < catMa(o1.getMa()) ? 1 : -1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public SanPham getByID(String id){
        SanPham sanPham= new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            sanPham=session.get(SanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sanPham;
    }
    public void delete(SanPham c){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.delete(c);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(SanPham c){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(c);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(SanPham c){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(c);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
