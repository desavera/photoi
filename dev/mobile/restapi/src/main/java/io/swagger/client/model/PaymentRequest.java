package io.swagger.client.model;

import io.swagger.client.model.Sender;
import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class PaymentRequest  {
  
  @SerializedName("id")
  private Long id = null;
  @SerializedName("sender")
  private Sender sender = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("reference")
  private String reference = null;
  @SerializedName("date")
  private Date date = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Sender getSender() {
    return sender;
  }
  public void setSender(Sender sender) {
    this.sender = sender;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequest paymentRequest = (PaymentRequest) o;
    return (id == null ? paymentRequest.id == null : id.equals(paymentRequest.id)) &&
        (sender == null ? paymentRequest.sender == null : sender.equals(paymentRequest.sender)) &&
        (name == null ? paymentRequest.name == null : name.equals(paymentRequest.name)) &&
        (description == null ? paymentRequest.description == null : description.equals(paymentRequest.description)) &&
        (reference == null ? paymentRequest.reference == null : reference.equals(paymentRequest.reference)) &&
        (date == null ? paymentRequest.date == null : date.equals(paymentRequest.date));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (id == null ? 0: id.hashCode());
    result = 31 * result + (sender == null ? 0: sender.hashCode());
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (description == null ? 0: description.hashCode());
    result = 31 * result + (reference == null ? 0: reference.hashCode());
    result = 31 * result + (date == null ? 0: date.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  sender: ").append(sender).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  reference: ").append(reference).append("\n");
    sb.append("  date: ").append(date).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
