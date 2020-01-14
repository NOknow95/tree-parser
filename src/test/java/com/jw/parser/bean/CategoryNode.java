package com.jw.parser.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NOknow
 * @version 1.0
 * @reateDate 2020/01/14
 * @description
 */
public class CategoryNode implements TreeNode<CategoryNode> {

  private Integer categoryId;
  private Integer parentCategoryId;
  private String name;
  private List<CategoryNode> categoryNodes;

  public CategoryNode() {
  }

  public CategoryNode(Integer categoryId, Integer parentCategoryId, String name) {
    this.categoryId = categoryId;
    this.parentCategoryId = parentCategoryId;
    this.name = name;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getParentCategoryId() {
    return parentCategoryId;
  }

  public void setParentCategoryId(Integer parentCategoryId) {
    this.parentCategoryId = parentCategoryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<CategoryNode> getCategoryNodes() {
    return categoryNodes;
  }

  public void setCategoryNodes(List<CategoryNode> categoryNodes) {
    this.categoryNodes = categoryNodes;
  }

  @Override
  public String toString() {
    return "CategoryNode{" +
        "categoryId=" + categoryId +
        ", parentCategoryId=" + parentCategoryId +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public String getId() {
    return String.valueOf(this.categoryId);
  }

  @Override
  public String getParentId() {
    return String.valueOf(this.parentCategoryId);
  }

  @Override
  public void initChildrenNode() {
    this.categoryNodes = new ArrayList<>();
  }

  @Override
  public void addChild(CategoryNode node) {
    this.categoryNodes.add(node);
  }
}
