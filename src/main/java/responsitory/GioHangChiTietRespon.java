package responsitory;

import Util.HibernateUtil;
import entity.GioHangChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.math.BigDecimal;
import java.util.ArrayList;

public class GioHangChiTietRespon {
    public ArrayList<GioHangChiTiet> getGHCTbyID(String idgh){
        ArrayList<GioHangChiTiet> listSP=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from GioHangChiTiet where gioHang.id=:id");
            query.setParameter("id",idgh);
            listSP= (ArrayList<GioHangChiTiet>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }

    public void add(GioHangChiTiet gh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.save(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(int sl, Double gia, String idgh, String idSP){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            GioHangChiTiet gioHangChiTiet = new GioHangChiTietRespon().capNhatSLSPtrung(idgh,idSP);
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong()+sl);
            Double giaTang = gioHangChiTiet.getDonGia().doubleValue()+gia;
            gioHangChiTiet.setDonGia(BigDecimal.valueOf(giaTang));
            session.merge(gioHangChiTiet);
            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateGH(GioHangChiTiet gh){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            session.merge(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

        public GioHangChiTiet capNhatSLSPtrung(String idGH,String idSP){
        GioHangChiTiet ghct= null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from GioHangChiTiet G WHERE G.gioHang.id=:idGH AND G.chiTietSP.id=:idSP" );
            query.setParameter("idGH",idGH);
            query.setParameter("idSP",idSP);
            ghct= (GioHangChiTiet) query.getSingleResult();
            return ghct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void delete(GioHangChiTiet gh){
        Transaction transaction= null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(gh);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new GioHangChiTietRespon().getGHCTbyID("837C64CD-47C9-487A-812B-ACADC656CD42").size());
    }

}
