package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "crs", schema = "jsql", catalog = "")
public class CrsEntity {
    private String kh;
    private String km;
    private String xf;

    @Id
    @Column(name = "kh", nullable = false, length = 8)
    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    @Basic
    @Column(name = "km", nullable = true, length = 16)
    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    @Basic
    @Column(name = "xf", nullable = true)
    public String getXf() {
        return xf;
    }

    public void setXf(String xf) {
        this.xf = xf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrsEntity crsEntity = (CrsEntity) o;
        return Objects.equals(kh, crsEntity.kh) &&
                Objects.equals(km, crsEntity.km) &&
                Objects.equals(xf, crsEntity.xf);
    }

    @Override
    public int hashCode() {

        return Objects.hash(kh, km, xf);
    }
}
