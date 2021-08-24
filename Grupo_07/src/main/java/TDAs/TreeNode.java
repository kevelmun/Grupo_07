
package TDAs;

import java.util.LinkedList;
import java.util.List;


public class TreeNode<T> {
    
    private T content;
    private TreeNode<T> parent;
    private List<Tree<T>> children;
    
    public TreeNode() {
        content=null;
        this.parent = null;
        children = new LinkedList<>();
    }

    public TreeNode(T content) {
        this.content = content;
        this.parent = null;
        children = new LinkedList<>();
    }
    public TreeNode(T content, TreeNode<T> parent) {
        this.content = content;
        this.parent = parent;
        children = new LinkedList<>();
    }
    
    public TreeNode(T content,TreeNode<T> parent, List<Tree<T>> children) {
        this.content = content;
        this.children = children;
        this.parent = parent;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }
    
    public void addChild(T data) {
        Tree<T> child = new Tree(data);
        child.getRoot().setParent(this);
        this.children.add(child);
    }

    public void addChild(Tree<T> child) {
        child.getRoot().setParent(this);
        this.children.add(child);
    }
    
    public boolean isRoot() {
        return (this.parent == null);
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }
    
}
