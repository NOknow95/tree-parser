package com.jw.parser;

import com.jw.parser.bean.TreeNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author NOknow
 * @version 1.0
 * @reateDate 2020/01/14
 * @description
 */
public class TreeParser<T extends TreeNode> {

  private List<T> srcTreeNodes;
  private Predicate<T> predicate;

  public TreeParser(List<T> srcTreeNodes, Predicate<T> predicate) {
    this.srcTreeNodes = srcTreeNodes;
    this.predicate = predicate;
  }

  public List<T> parseToTree() {
    if (isEmpty(this.srcTreeNodes)) {
      return Collections.emptyList();
    }
    for (T t : this.srcTreeNodes) {
      t.initChildrenNode();
    }
    List<T> resultTree = new ArrayList<>();
    // find the root nodes
    List<T> rootNodes = this.srcTreeNodes.stream()
        .filter(this.predicate)
        .collect(Collectors.toList());
    //remove root nodes
    srcTreeNodes.removeAll(rootNodes);

    for (T rootNode : rootNodes) {
      T node = packageNode(rootNode);
      resultTree.add(node);
    }
    return resultTree;
  }

  private T packageNode(T rootNode) {
    List<T> childNodes = findChildNodes(rootNode);
    if (!isEmpty(childNodes)) {
      this.srcTreeNodes.removeAll(childNodes);
      for (T childNode : childNodes) {
        T node = packageNode(childNode);
        rootNode.addChild(node);
      }
    }
    return rootNode;
  }

  private List<T> findChildNodes(T rootNode) {
    return this.srcTreeNodes.stream()
        .filter(item -> Objects.equals(item.getParentId(), rootNode.getId()))
        .collect(Collectors.toList());
  }

  private boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }
}
