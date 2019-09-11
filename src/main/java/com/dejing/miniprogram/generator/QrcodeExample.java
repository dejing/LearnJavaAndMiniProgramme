package com.dejing.miniprogram.generator;

import java.util.ArrayList;
import java.util.List;

public class QrcodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public QrcodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFirstunknownIsNull() {
            addCriterion("firstUnknown is null");
            return (Criteria) this;
        }

        public Criteria andFirstunknownIsNotNull() {
            addCriterion("firstUnknown is not null");
            return (Criteria) this;
        }

        public Criteria andFirstunknownEqualTo(String value) {
            addCriterion("firstUnknown =", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownNotEqualTo(String value) {
            addCriterion("firstUnknown <>", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownGreaterThan(String value) {
            addCriterion("firstUnknown >", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownGreaterThanOrEqualTo(String value) {
            addCriterion("firstUnknown >=", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownLessThan(String value) {
            addCriterion("firstUnknown <", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownLessThanOrEqualTo(String value) {
            addCriterion("firstUnknown <=", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownLike(String value) {
            addCriterion("firstUnknown like", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownNotLike(String value) {
            addCriterion("firstUnknown not like", value, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownIn(List<String> values) {
            addCriterion("firstUnknown in", values, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownNotIn(List<String> values) {
            addCriterion("firstUnknown not in", values, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownBetween(String value1, String value2) {
            addCriterion("firstUnknown between", value1, value2, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andFirstunknownNotBetween(String value1, String value2) {
            addCriterion("firstUnknown not between", value1, value2, "firstunknown");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIsNull() {
            addCriterion("Invoicetype is null");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIsNotNull() {
            addCriterion("Invoicetype is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeEqualTo(String value) {
            addCriterion("Invoicetype =", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotEqualTo(String value) {
            addCriterion("Invoicetype <>", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeGreaterThan(String value) {
            addCriterion("Invoicetype >", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("Invoicetype >=", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLessThan(String value) {
            addCriterion("Invoicetype <", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLessThanOrEqualTo(String value) {
            addCriterion("Invoicetype <=", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLike(String value) {
            addCriterion("Invoicetype like", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotLike(String value) {
            addCriterion("Invoicetype not like", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIn(List<String> values) {
            addCriterion("Invoicetype in", values, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotIn(List<String> values) {
            addCriterion("Invoicetype not in", values, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeBetween(String value1, String value2) {
            addCriterion("Invoicetype between", value1, value2, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotBetween(String value1, String value2) {
            addCriterion("Invoicetype not between", value1, value2, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeIsNull() {
            addCriterion("InvoiceCode is null");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeIsNotNull() {
            addCriterion("InvoiceCode is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeEqualTo(String value) {
            addCriterion("InvoiceCode =", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotEqualTo(String value) {
            addCriterion("InvoiceCode <>", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeGreaterThan(String value) {
            addCriterion("InvoiceCode >", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeGreaterThanOrEqualTo(String value) {
            addCriterion("InvoiceCode >=", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeLessThan(String value) {
            addCriterion("InvoiceCode <", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeLessThanOrEqualTo(String value) {
            addCriterion("InvoiceCode <=", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeLike(String value) {
            addCriterion("InvoiceCode like", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotLike(String value) {
            addCriterion("InvoiceCode not like", value, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeIn(List<String> values) {
            addCriterion("InvoiceCode in", values, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotIn(List<String> values) {
            addCriterion("InvoiceCode not in", values, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeBetween(String value1, String value2) {
            addCriterion("InvoiceCode between", value1, value2, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicecodeNotBetween(String value1, String value2) {
            addCriterion("InvoiceCode not between", value1, value2, "invoicecode");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberIsNull() {
            addCriterion("InvoiceNumber is null");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberIsNotNull() {
            addCriterion("InvoiceNumber is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberEqualTo(String value) {
            addCriterion("InvoiceNumber =", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotEqualTo(String value) {
            addCriterion("InvoiceNumber <>", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberGreaterThan(String value) {
            addCriterion("InvoiceNumber >", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberGreaterThanOrEqualTo(String value) {
            addCriterion("InvoiceNumber >=", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberLessThan(String value) {
            addCriterion("InvoiceNumber <", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberLessThanOrEqualTo(String value) {
            addCriterion("InvoiceNumber <=", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberLike(String value) {
            addCriterion("InvoiceNumber like", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotLike(String value) {
            addCriterion("InvoiceNumber not like", value, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberIn(List<String> values) {
            addCriterion("InvoiceNumber in", values, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotIn(List<String> values) {
            addCriterion("InvoiceNumber not in", values, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberBetween(String value1, String value2) {
            addCriterion("InvoiceNumber between", value1, value2, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andInvoicenumberNotBetween(String value1, String value2) {
            addCriterion("InvoiceNumber not between", value1, value2, "invoicenumber");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("Amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("Amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Float value) {
            addCriterion("Amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Float value) {
            addCriterion("Amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Float value) {
            addCriterion("Amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("Amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Float value) {
            addCriterion("Amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Float value) {
            addCriterion("Amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Float> values) {
            addCriterion("Amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Float> values) {
            addCriterion("Amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Float value1, Float value2) {
            addCriterion("Amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Float value1, Float value2) {
            addCriterion("Amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andDateissuedIsNull() {
            addCriterion("DateIssued is null");
            return (Criteria) this;
        }

        public Criteria andDateissuedIsNotNull() {
            addCriterion("DateIssued is not null");
            return (Criteria) this;
        }

        public Criteria andDateissuedEqualTo(String value) {
            addCriterion("DateIssued =", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedNotEqualTo(String value) {
            addCriterion("DateIssued <>", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedGreaterThan(String value) {
            addCriterion("DateIssued >", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedGreaterThanOrEqualTo(String value) {
            addCriterion("DateIssued >=", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedLessThan(String value) {
            addCriterion("DateIssued <", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedLessThanOrEqualTo(String value) {
            addCriterion("DateIssued <=", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedLike(String value) {
            addCriterion("DateIssued like", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedNotLike(String value) {
            addCriterion("DateIssued not like", value, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedIn(List<String> values) {
            addCriterion("DateIssued in", values, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedNotIn(List<String> values) {
            addCriterion("DateIssued not in", values, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedBetween(String value1, String value2) {
            addCriterion("DateIssued between", value1, value2, "dateissued");
            return (Criteria) this;
        }

        public Criteria andDateissuedNotBetween(String value1, String value2) {
            addCriterion("DateIssued not between", value1, value2, "dateissued");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeIsNull() {
            addCriterion("InvoiceVerifyCode is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeIsNotNull() {
            addCriterion("InvoiceVerifyCode is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeEqualTo(String value) {
            addCriterion("InvoiceVerifyCode =", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeNotEqualTo(String value) {
            addCriterion("InvoiceVerifyCode <>", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeGreaterThan(String value) {
            addCriterion("InvoiceVerifyCode >", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeGreaterThanOrEqualTo(String value) {
            addCriterion("InvoiceVerifyCode >=", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeLessThan(String value) {
            addCriterion("InvoiceVerifyCode <", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeLessThanOrEqualTo(String value) {
            addCriterion("InvoiceVerifyCode <=", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeLike(String value) {
            addCriterion("InvoiceVerifyCode like", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeNotLike(String value) {
            addCriterion("InvoiceVerifyCode not like", value, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeIn(List<String> values) {
            addCriterion("InvoiceVerifyCode in", values, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeNotIn(List<String> values) {
            addCriterion("InvoiceVerifyCode not in", values, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeBetween(String value1, String value2) {
            addCriterion("InvoiceVerifyCode between", value1, value2, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andInvoiceverifycodeNotBetween(String value1, String value2) {
            addCriterion("InvoiceVerifyCode not between", value1, value2, "invoiceverifycode");
            return (Criteria) this;
        }

        public Criteria andLastunknownIsNull() {
            addCriterion("LastUnknown is null");
            return (Criteria) this;
        }

        public Criteria andLastunknownIsNotNull() {
            addCriterion("LastUnknown is not null");
            return (Criteria) this;
        }

        public Criteria andLastunknownEqualTo(String value) {
            addCriterion("LastUnknown =", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownNotEqualTo(String value) {
            addCriterion("LastUnknown <>", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownGreaterThan(String value) {
            addCriterion("LastUnknown >", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownGreaterThanOrEqualTo(String value) {
            addCriterion("LastUnknown >=", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownLessThan(String value) {
            addCriterion("LastUnknown <", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownLessThanOrEqualTo(String value) {
            addCriterion("LastUnknown <=", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownLike(String value) {
            addCriterion("LastUnknown like", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownNotLike(String value) {
            addCriterion("LastUnknown not like", value, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownIn(List<String> values) {
            addCriterion("LastUnknown in", values, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownNotIn(List<String> values) {
            addCriterion("LastUnknown not in", values, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownBetween(String value1, String value2) {
            addCriterion("LastUnknown between", value1, value2, "lastunknown");
            return (Criteria) this;
        }

        public Criteria andLastunknownNotBetween(String value1, String value2) {
            addCriterion("LastUnknown not between", value1, value2, "lastunknown");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}