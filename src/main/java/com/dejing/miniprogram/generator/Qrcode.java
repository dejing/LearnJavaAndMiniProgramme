package com.dejing.miniprogram.generator;

import java.io.Serializable;

/**
 * qrcode
 * @author 
 */
public class Qrcode implements Serializable {
    private Long id;

    private String firstunknown;

    /**
     * 发票种类代码
     */
    private String invoicetype;

    /**
     * 发票代码
     */
    private String invoicecode;

    /**
     * 发票号码
     */
    private String invoicenumber;

    /**
     * 开票金额
     */
    private Float amount;

    /**
     * 开票日期
     */
    private String dateissued;

    /**
     * 发票校验码
     */
    private String invoiceverifycode;

    /**
     * 另外增值税专用发票和增值税普通发票的二维码中还多了一项属性值
     */
    private String lastunknown;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstunknown() {
        return firstunknown;
    }

    public void setFirstunknown(String firstunknown) {
        this.firstunknown = firstunknown;
    }

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDateissued() {
        return dateissued;
    }

    public void setDateissued(String dateissued) {
        this.dateissued = dateissued;
    }

    public String getInvoiceverifycode() {
        return invoiceverifycode;
    }

    public void setInvoiceverifycode(String invoiceverifycode) {
        this.invoiceverifycode = invoiceverifycode;
    }

    public String getLastunknown() {
        return lastunknown;
    }

    public void setLastunknown(String lastunknown) {
        this.lastunknown = lastunknown;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Qrcode other = (Qrcode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFirstunknown() == null ? other.getFirstunknown() == null : this.getFirstunknown().equals(other.getFirstunknown()))
            && (this.getInvoicetype() == null ? other.getInvoicetype() == null : this.getInvoicetype().equals(other.getInvoicetype()))
            && (this.getInvoicecode() == null ? other.getInvoicecode() == null : this.getInvoicecode().equals(other.getInvoicecode()))
            && (this.getInvoicenumber() == null ? other.getInvoicenumber() == null : this.getInvoicenumber().equals(other.getInvoicenumber()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getDateissued() == null ? other.getDateissued() == null : this.getDateissued().equals(other.getDateissued()))
            && (this.getInvoiceverifycode() == null ? other.getInvoiceverifycode() == null : this.getInvoiceverifycode().equals(other.getInvoiceverifycode()))
            && (this.getLastunknown() == null ? other.getLastunknown() == null : this.getLastunknown().equals(other.getLastunknown()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFirstunknown() == null) ? 0 : getFirstunknown().hashCode());
        result = prime * result + ((getInvoicetype() == null) ? 0 : getInvoicetype().hashCode());
        result = prime * result + ((getInvoicecode() == null) ? 0 : getInvoicecode().hashCode());
        result = prime * result + ((getInvoicenumber() == null) ? 0 : getInvoicenumber().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getDateissued() == null) ? 0 : getDateissued().hashCode());
        result = prime * result + ((getInvoiceverifycode() == null) ? 0 : getInvoiceverifycode().hashCode());
        result = prime * result + ((getLastunknown() == null) ? 0 : getLastunknown().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", firstunknown=").append(firstunknown);
        sb.append(", invoicetype=").append(invoicetype);
        sb.append(", invoicecode=").append(invoicecode);
        sb.append(", invoicenumber=").append(invoicenumber);
        sb.append(", amount=").append(amount);
        sb.append(", dateissued=").append(dateissued);
        sb.append(", invoiceverifycode=").append(invoiceverifycode);
        sb.append(", lastunknown=").append(lastunknown);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}