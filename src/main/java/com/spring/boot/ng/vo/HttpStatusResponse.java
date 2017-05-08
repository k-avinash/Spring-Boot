package com.spring.boot.ng.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HttpStatusResponse {

  private int statusCode;
  private String description;
  private Object data;

  /**
   * Default constructor
   */
  public HttpStatusResponse() {
    super();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int i) {
    this.statusCode = i;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

}
