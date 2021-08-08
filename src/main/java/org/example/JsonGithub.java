package org.example;

import com.google.gson.annotations.SerializedName;

public class JsonGithub {
  protected int id;
  protected String node_id;
  protected String name;
  protected String full_name;
  // SerializedName make you able to use Keywords
  @SerializedName("private")
  private boolean isPrivate;

  public void set_id(int id) {
    this.id = id;
  }

  public int get_id() {
    return id;
  }

  public void set_full_name(String full_name) {
    this.full_name = full_name;
  }

  public String get_full_name() {
    return this.full_name;
  }
}
