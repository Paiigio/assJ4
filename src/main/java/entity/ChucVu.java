package entity;


import jakarta.persistence.*;

@Table(name = "ChucVu")
@Entity
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private String id;

    @Column(name = "Ma")
    private String maCV;

    @Column(name = "Ten")

    private String tenCV;

    public ChucVu() {
    }



    public ChucVu(String id, String maCV, String tenCV) {
        this.id = id;
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }


}
