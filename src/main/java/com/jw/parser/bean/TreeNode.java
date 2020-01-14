package com.jw.parser.bean;

/**
 * @author NOknow
 * @version 1.0
 * @CreateDate 2020/01/14
 * @Desc
 */
public interface TreeNode<T> {

  String getId();

  String getParentId();

  void initChildrenNode();

  void addChild(T node);
}
