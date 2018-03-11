package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adm", schema = "jsql", catalog = "")
public class AdmEntity {
    private String gh;
    private String xm;
    private String xb;
    private String csrq;
    private String mima;

    @Id
    @Column(name = "gh", nullable = false, length = 8)
    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    @Basic
    @Column(name = "xm", nullable = true, length = 10)
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Basic
    @Column(name = "xb", nullable = true, length = 2)
    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    @Basic
    @Column(name = "csrq", nullable = true, length = 10)
    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    @Basic
    @Column(name = "mima", nullable = true, length = 12)
    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdmEntity admEntity = (AdmEntity) o;
        return Objects.equals(gh, admEntity.gh) &&
                Objects.equals(xm, admEntity.xm) &&
                Objects.equals(xb, admEntity.xb) &&
                Objects.equals(csrq, admEntity.csrq) &&
                Objects.equals(mima, admEntity.mima);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gh, xm, xb, csrq, mima);
    }
}
