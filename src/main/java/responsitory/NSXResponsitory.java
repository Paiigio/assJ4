package responsitory;

import Util.HibernateUtil;
import entity.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NSXResponsitory {
    public ArrayList<NSX> getAllNSX(){
        ArrayList<NSX> listNSX= new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query=session.createQuery("from NSX ");
            listNSX= (ArrayList<NSX>) query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return listNSX;
    }
    public  NSX getbyID(String id){
        NSX nsx= new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nsx=session.get(NSX.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }
    public void delete(NSX n){
        Transaction transaction =null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(NSX n){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void update(NSX n){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
