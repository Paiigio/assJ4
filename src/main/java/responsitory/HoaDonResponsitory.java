package responsitory;

import Util.HibernateUtil;
import entity.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;

public class HoaDonResponsitory {

    public ArrayList<HoaDon> getALlHD() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from HoaDon ");
            listHD = (ArrayList<HoaDon>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    public ArrayList<HoaDon> getHDbyKhachHang(String idKH){
        ArrayList<HoaDon> listSP=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from HoaDon where khachHang.id=:id");
            query.setParameter("id",idKH);
            listSP= (ArrayList<HoaDon>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    public ArrayList<HoaDon> getHDbyKhachHangByTime(String idKH, String bd, String kt){
        ArrayList<HoaDon> listSP=new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query= session.createQuery("from HoaDon where khachHang.id=:id and  ngayThanhToan between :bd and :kt");
            query.setParameter("id",idKH);
            query.setParameter("bd",Date.valueOf(bd));
            query.setParameter("kt",Date.valueOf(kt));
            listSP= (ArrayList<HoaDon>) query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listSP;
    }
    public HoaDon getbyID(String id){
        HoaDon hoaDon= null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            hoaDon=session.get(HoaDon.class,id);
            return hoaDon;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String add(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return (String) session.save(hoaDon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(new HoaDonResponsitory().getHDbyKhachHangByTime("3E3FE381-7C58-4782-AD64-A3CAD10B05FF","2023-07-22" ,"2023-07-28"));
    }
}


