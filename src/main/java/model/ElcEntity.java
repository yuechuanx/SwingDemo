package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "elc", schema = "jsql", catalog = "")
@IdClass(ElcEntityPK.class)
public class ElcEntity {
    private String xh;
    private String xq;
    private String kh;
    private String gh;
    private Integer cj;

    @Id
    @Column(name = "xh", nullable = false, length = 8)
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Id
    @Column(name = "xq", nullable = false, length = 14)
    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    @Id
    @Column(name = "kh", nullable = false, length = 8)
    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    @Id
    @Column(name = "gh", nullable = false, length = 8)
    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    @Basic
    @Column(name = "cj", nullable = true)
    public Integer getCj() {
        return cj;
    }

    public void setCj(Integer cj) {
        this.cj = cj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElcEntity elcEntity = (ElcEntity) o;
        return Objects.equals(xh, elcEntity.xh) &&
                Objects.equals(xq, elcEntity.xq) &&
                Objects.equals(kh, elcEntity.kh) &&
                Objects.equals(gh, elcEntity.gh) &&
                Objects.equals(cj, elcEntity.cj);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xh, xq, kh, gh, cj);
    }
}
