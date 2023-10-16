package responsitory;

import Util.HibernateUtil;
import entity.CTSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CTSanPhamResponsitory {
    ArrayList<CTSanPham> list = new ArrayList<>();

    public ArrayList<CTSanPham> getAllCTSP() {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CTSanPham ");
            list = (ArrayList<CTSanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public CTSanPham getByID(String id) {
        CTSanPham ctSanPham = new CTSanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            ctSanPham = session.get(CTSanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctSanPham;
    }

    public ArrayList<CTSanPham> getByMau(String mau){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CTSanPham  where mauSac.ten =: tenM");
            query.setParameter("tenM",mau);
            list= (ArrayList<CTSanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return list;
    }
    public ArrayList<CTSanPham> getByNSX(String NSX){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CTSanPham  where nsx.ten =: tenNSX");
            query.setParameter("tenNSX",NSX);
            list= (ArrayList<CTSanPham>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<CTSanPham> getByPrice(String bd , String kt){
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CTSanPham  where giaBan  between :bd and :kt order by giaBan asc ");
            query.setParameter("bd",BigDecimal.valueOf(Double.parseDouble(bd)));
            query.setParameter("kt",BigDecimal.valueOf(Double.parseDouble(kt)));
            list= (ArrayList<CTSanPham>) query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getByName(String name) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            if (name == null) {
                name = "%";
            } else {
                name = "%" + name.replaceAll(" ","") + "%";;
            }
            String hql = " FROM CTSanPham E WHERE REPLACE(concat(E.sanPham.ten,E.mauSac.ten,E.nsx.ten),' ','')like : name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            List reults = query.list();
            return reults;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void add(CTSanPham ct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(CTSanPham ct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(CTSanPham ct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public  List<CTSanPham> pagingSP(int pageNumber){
    try (Session session = HibernateUtil.getFACTORY().openSession()) {
        Query query= session.createNativeQuery("SELECT * FROM ChiTietSP order by id OFFSET :index  ROWS FETCH NEXT 6 ROWS ONLY");
        query.setParameter("index",(pageNumber-1)*6);
//        query.setParameter("pageSize",pageSize);
        List<CTSanPham>listct= query.getResultList();
        return listct;
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
}
public List<CTSanPham> pagingCTSP(int pageNumber, int pageSize){
    try (Session session = HibernateUtil.getFACTORY().openSession()) {
        Query<CTSanPham> query = session.createQuery("from CTSanPham order by id desc ");

        int firstNumber = (pageNumber -1)*pageSize;
        query.setFirstResult(firstNumber);
        query.setMaxResults(pageSize);
        List<CTSanPham>listct=  query.list();
        return listct;
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("FAILED");
        return null;
    }
}
    public List<CTSanPham> getPage(int pageNumber, int pageSize) {
        Session session = HibernateUtil.getFACTORY().openSession();
        session.beginTransaction();

        int startPosition = (pageNumber - 1) * pageSize;

        Query<CTSanPham> query = session.createQuery("FROM CTSanPham ");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);

        List<CTSanPham> page = query.getResultList();

        session.getTransaction().commit();
        return page;
    }

    public static void main(String[] args) {
        System.out.println(new CTSanPhamResponsitory().getPage(2,6));
//        System.out.println(new CTSanPhamResponsitory().pagingCTSP(1,6));
//        System.out.println("Hashcode :       "+new CTSanPhamResponsitory().pagingSP(2).hashCode());
//        System.out.println("Hashcode (HEX) : "+Integer.toHexString(new CTSanPhamResponsitory().pagingSP(2).hashCode()));


    }

}
