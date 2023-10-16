package responsitory;

import Util.HibernateUtil;
import entity.DongSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class DongSPResponsitory {
    Transaction transaction=null;
    public ArrayList<DongSP> getAllDongSP(){
        ArrayList<DongSP> listDongSP= new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("from DongSP ");
            listDongSP= (ArrayList<DongSP>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listDongSP;
    }

    public DongSP getByID(String id){
        DongSP dongSP= new DongSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            dongSP=session.get(DongSP.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dongSP;
    }
    public void delete(DongSP dsp){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.delete(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(DongSP dsp){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(DongSP dsp){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.merge(dsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
