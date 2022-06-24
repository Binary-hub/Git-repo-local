package com.modelMapDemo.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {

    @JsonProperty("requestId") 
    public String getRequestId() { 
		 return this.requestId; } 

    public void setRequestId(String requestId) { 
		 this.requestId = requestId; } 

    private String requestId;

    @JsonProperty("clientCode") 
    public String getClientCode() { 
		 return this.clientCode; } 

    public void setClientCode(String clientCode) { 
		 this.clientCode = clientCode; } 

    private String clientCode;

    @JsonProperty("warehouseCode") 
    public String getWarehouseCode() { 
		 return this.warehouseCode; } 

    public void setWarehouseCode(String warehouseCode) { 
		 this.warehouseCode = warehouseCode; } 

    private String warehouseCode;

    @JsonProperty("userId") 
    public String getUserId() { 
		 return this.userId; } 

    public void setUserId(String userId) { 
		 this.userId = userId; } 

    private String userId;

    @JsonProperty("userKey") 
    public String getUserKey() { 
		 return this.userKey; } 

    public void setUserKey(String userKey) { 
		 this.userKey = userKey; } 

    private String userKey;

    @JsonProperty("language") 
    public String getLanguage() { 
		 return this.language; } 

    public void setLanguage(String language) { 
		 this.language = language; } 

    private String language;

    @JsonProperty("version") 
    public String getVersion() { 
		 return this.version; } 

    public void setVersion(String version) { 
		 this.version = version; } 

    private String version;
    
}
