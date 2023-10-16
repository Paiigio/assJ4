package responsitory;

import Util.HibernateUtil;
import entity.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class CuaHangResponsitory {
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public ArrayList<CuaHang>getAll(){
        ArrayList<CuaHang> listCH=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from CuaHang ");
            listCH= (ArrayList<CuaHang>) query.getResultList();
            Collections.sort(listCH, (CuaHang o1, CuaHang o2) -> catMa(o2.getMa()) < catMa(o1.getMa()) ? 1 : -1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return listCH;
    }
    public CuaHang getbyID(String id){
        CuaHang cuaHang= new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
                cuaHang=session.get(CuaHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cuaHang;
    }
    public void delete(CuaHang c){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.delete(c);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(CuaHang c){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(c);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(CuaHang c){
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
