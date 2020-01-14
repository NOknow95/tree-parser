package com.jw.parser;

import com.jw.parser.bean.CategoryNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class TreeParserTest {

  @Test
  public void parseTree() {
    List<CategoryNode> srcTreeNodes = new ArrayList<>(Arrays.asList(
        new CategoryNode(1, 0, "Category 1"),
        new CategoryNode(2, 0, "Category 2"),
        new CategoryNode(3, 2, "Category 2.1"),
        new CategoryNode(4, 3, "Category 2.1.1"),
        new CategoryNode(5, 4, "Category 2.1.1.1"),
        new CategoryNode(6, 4, "Category 2.1.1.2"),
        new CategoryNode(7, 2, "Category 2.2"),
        new CategoryNode(8, 0, "Category 3"),
        new CategoryNode(9, 8, "Category 3.1"),
        new CategoryNode(10, 8, "Category 3.2")
    ));
    TreeParser<CategoryNode> parser = new TreeParser<>(srcTreeNodes,
        node -> "0".equals(node.getParentId()));
    List<CategoryNode> tree = parser.parseToTree();
    printTree(tree, 0);
  }

  private static void printTree(List<CategoryNode> tree, int level) {
    for (CategoryNode node : tree) {
      for (int i = 0; i < level; i++) {
        System.out.print("--");
      }
      System.out.println(node.toString());
      printTree(node.getCategoryNodes(), level + 1);
    }
  }
}