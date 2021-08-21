/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Tree<T> {
    
    private TreeNode<T> root;
    
    public Tree() {
        this.root = new TreeNode<>();
    }
     public Tree(T content) {
        root = new TreeNode<>(content);
    }


    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public boolean isLeaf() {
        return root.getChildren().isEmpty();
    }
    
}
