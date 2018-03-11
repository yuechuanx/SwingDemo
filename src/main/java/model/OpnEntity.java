package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "opn", schema = "jsql", catalog = "")
@IdClass(OpnEntityPK.class)
public class OpnEntity {
    private String xq;
    private String kh;
    private String gh;
    private String sksj;

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
    @Column(name = "sksj", nullable = true, length = 11)
    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpnEntity opnEntity = (OpnEntity) o;
        return Objects.equals(xq, opnEntity.xq) &&
                Objects.equals(kh, opnEntity.kh) &&
                Objects.equals(gh, opnEntity.gh) &&
                Objects.equals(sksj, opnEntity.sksj);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xq, kh, gh, sksj);
    }
}
