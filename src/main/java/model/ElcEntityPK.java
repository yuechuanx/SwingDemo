package main.java.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ElcEntityPK implements Serializable {
    private String xh;
    private String xq;
    private String kh;
    private String gh;

    @Column(name = "xh", nullable = false, length = 8)
    @Id
    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Column(name = "xq", nullable = false, length = 14)
    @Id
    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    @Column(name = "kh", nullable = false, length = 8)
    @Id
    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    @Column(name = "gh", nullable = false, length = 8)
    @Id
    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElcEntityPK that = (ElcEntityPK) o;
        return Objects.equals(xh, that.xh) &&
                Objects.equals(xq, that.xq) &&
                Objects.equals(kh, that.kh) &&
                Objects.equals(gh, that.gh);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xh, xq, kh, gh);
    }
}
