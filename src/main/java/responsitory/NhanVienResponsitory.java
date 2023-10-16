package responsitory;

import Util.HibernateUtil;
import entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;

public class NhanVienResponsitory {
//    CuaHang cuaHang=new CuaHang();
    public ArrayList<NhanVien> getALlNV(){
        ArrayList<NhanVien> listNV=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery(" from NhanVien");
            listNV= (ArrayList<NhanVien>) query.getResultList();
            Collections.sort(listNV, (NhanVien o1, NhanVien o2) -> catMa(o2.getMa()) < catMa(o1.getMa()) ? 1 : -1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return listNV;
    }
    private int catMa(String ma) {
        String chuSo = ma.substring(2);
        int so = Integer.valueOf(chuSo);
        return so;
    }
    public NhanVien getByID(String id){
        NhanVien nhanVien=new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nhanVien=session.get(NhanVien.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nhanVien;
    }
    public void delete(NhanVien nv){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void add(NhanVien nv){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(NhanVien nv){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(nv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
