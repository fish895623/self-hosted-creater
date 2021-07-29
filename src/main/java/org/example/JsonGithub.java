package org.example;

import com.google.gson.annotations.SerializedName;

public class JsonGithub {
  private int id;
  private String node_id;
  private String name;
  private String full_name;
  // SerializedName make you able to use Keywords
  @SerializedName("private")
  private boolean isPrivate;

  private void set_id(int id) {
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
