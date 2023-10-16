package responsitory;

import Util.HibernateUtil;
import entity.CuaHang;
import entity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class MauSacResponsitory {
    public ArrayList<MauSac> getAllMS(){
        ArrayList<MauSac> listMS=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("from MauSac ");
            listMS= (ArrayList<MauSac>) query.getResultList();
            Collections.sort(listMS,(MauSac o1,MauSac o2) ->catMa(o2.getMa())<catMa(o1.getMa())?1:-1) ;
        }catch (Exception e){
            e.printStackTrace();

        }
        return listMS;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }

    public MauSac getByID(String id){
        MauSac mauSac= new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            mauSac=session.get(MauSac.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }
    public void delete(MauSac ms){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(MauSac ms){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(MauSac ms){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
