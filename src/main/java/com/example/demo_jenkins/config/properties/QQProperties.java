package com.example.demo_jenkins.config.properties;

/**
 * QQ登录配置项
 */
public class QQProperties {

    private String appId;
    private String appSecret;

    /**
     * 第三方id,用来决定发起第三方登录的url,默认是qq
     */
    private String providerId = "qq";

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
