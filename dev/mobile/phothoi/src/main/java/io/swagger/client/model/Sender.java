package io.swagger.client.model;


import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Sender  {
  
  @SerializedName("name")
  private String name = null;
  @SerializedName("email")
  private String email = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sender sender = (Sender) o;
    return (name == null ? sender.name == null : name.equals(sender.name)) &&
        (email == null ? sender.email == null : email.equals(sender.email));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (name == null ? 0: name.hashCode());
    result = 31 * result + (email == null ? 0: email.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sender {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
