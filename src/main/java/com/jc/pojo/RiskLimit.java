/*
*
* Copyright(C) 2017-2020 恒生电子股份有限公司
* @date 2020-04-09
*/
package com.jc.pojo;

/**
 * 
 * 
 * @author jincheng19253
 * @date 2020-04-09
 */
public class RiskLimit {
    /**
     * 序号
     */
    private Integer riskNo;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 投资人风险承受能力
     */
    private String custRiskType;

    /**
     * 产品风险等级
     */
    private String productRiskLevel;

    /**
     * 0-可交易;1-提示;2-主管授权;3-交易限制             
     */
    private String riskLimitType;

    /**
     * 0:风险类型交易限制;1:晨星匹配结果交易限制
     */
    private String riskLimitMode;

    /**
     * 客户类别
     */
    private String custType;

    /**
     * 问卷大类
     */
    private String questionKind;

    /**
     * 序号
     * @return L_RISK_NO 序号
     */
    public Integer getRiskNo() {
        return riskNo;
    }

    /**
     * 序号
     * @param riskNo 序号
     */
    public void setRiskNo(Integer riskNo) {
        this.riskNo = riskNo;
    }

    /**
     * 租户ID
     * @return VC_TENANT_ID 租户ID
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * 租户ID
     * @param tenantId 租户ID
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    /**
     * 投资人风险承受能力
     * @return C_CUST_RISK_TYPE 投资人风险承受能力
     */
    public String getCustRiskType() {
        return custRiskType;
    }

    /**
     * 投资人风险承受能力
     * @param custRiskType 投资人风险承受能力
     */
    public void setCustRiskType(String custRiskType) {
        this.custRiskType = custRiskType == null ? null : custRiskType.trim();
    }

    /**
     * 产品风险等级
     * @return C_PRODUCT_RISK_LEVEL 产品风险等级
     */
    public String getProductRiskLevel() {
        return productRiskLevel;
    }

    /**
     * 产品风险等级
     * @param productRiskLevel 产品风险等级
     */
    public void setProductRiskLevel(String productRiskLevel) {
        this.productRiskLevel = productRiskLevel == null ? null : productRiskLevel.trim();
    }

    /**
     * 0-可交易;1-提示;2-主管授权;3-交易限制             
     * @return C_RISK_LIMIT_TYPE 0-可交易;1-提示;2-主管授权;3-交易限制             
     */
    public String getRiskLimitType() {
        return riskLimitType;
    }

    /**
     * 0-可交易;1-提示;2-主管授权;3-交易限制             
     * @param riskLimitType 0-可交易;1-提示;2-主管授权;3-交易限制             
     */
    public void setRiskLimitType(String riskLimitType) {
        this.riskLimitType = riskLimitType == null ? null : riskLimitType.trim();
    }

    /**
     * 0:风险类型交易限制;1:晨星匹配结果交易限制
     * @return C_RISK_LIMIT_MODE 0:风险类型交易限制;1:晨星匹配结果交易限制
     */
    public String getRiskLimitMode() {
        return riskLimitMode;
    }

    /**
     * 0:风险类型交易限制;1:晨星匹配结果交易限制
     * @param riskLimitMode 0:风险类型交易限制;1:晨星匹配结果交易限制
     */
    public void setRiskLimitMode(String riskLimitMode) {
        this.riskLimitMode = riskLimitMode == null ? null : riskLimitMode.trim();
    }

    /**
     * 客户类别
     * @return C_CUST_TYPE 客户类别
     */
    public String getCustType() {
        return custType;
    }

    /**
     * 客户类别
     * @param custType 客户类别
     */
    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    /**
     * 问卷大类
     * @return C_QUESTION_KIND 问卷大类
     */
    public String getQuestionKind() {
        return questionKind;
    }

    /**
     * 问卷大类
     * @param questionKind 问卷大类
     */
    public void setQuestionKind(String questionKind) {
        this.questionKind = questionKind == null ? null : questionKind.trim();
    }
}