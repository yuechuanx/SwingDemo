package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stu", schema = "jsql", catalog = "")
public class StuEntity {
    private String xh;
    private String xm;
    private String xb;
    private String csrq;
    private String jg;
    private String mima;

    @Id
    @Column(name = "xh", nullable = false, length = 8)
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Basic
    @Column(name = "xm", nullable = false, length = 10)
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
    @Column(name = "jg", nullable = true, length = 6)
    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
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
        StuEntity stuEntity = (StuEntity) o;
        return Objects.equals(xh, stuEntity.xh) &&
                Objects.equals(xm, stuEntity.xm) &&
                Objects.equals(xb, stuEntity.xb) &&
                Objects.equals(csrq, stuEntity.csrq) &&
                Objects.equals(jg, stuEntity.jg) &&
                Objects.equals(mima, stuEntity.mima);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xh, xm, xb, csrq, jg, mima);
    }
}
