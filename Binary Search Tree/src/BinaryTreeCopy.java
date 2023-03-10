/*
Robert Khalulyan
10/28/22
Project 2
 */
// package Trees;

import com.sun.source.tree.Tree;
import java.util.ArrayList;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeCopy<T> {

    protected TreeNode<T> root;


    public List<T> traverse() {
        List<T> result = new ArrayList<>();
        return result;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public String toString() {

        List<T> result1 = recursivePreorderTraversal();
        return result1.toString();

    }

    public List<T> recursivePreorderTraversal() {
        List<T> result  = new ArrayList<>();
        recursivePreorderTraversal (this.root,result);
        return result;

    }
    public void recursivePreorderTraversal(TreeNode<T> current,List<T> list) {
        //1. process the current node
        list.add(current.getValue());
        //2. recursively call method on the current's left
        if (current.hasLeftChild()) {
            recursivePreorderTraversal(current.getLeftChild(),list);
        }
        //3. recursively call method on the current's right
        if(current.hasRightChild()) {
            recursivePreorderTraversal(current.getRightChild(),list);
        }
    }

    public List<T> recursiveInOrderTraversal(){
        List<T> result = new ArrayList<>();
        recursiveInOrderTraversal(this.root, result);
        return result;
    }
    public void recursiveInOrderTraversal(TreeNode<T> current, List<T> list) {
        //1. recursively call method on currents left child
        if (current.hasLeftChild())
            recursiveInOrderTraversal(current.getLeftChild(), list);
        //2. proccess current node
        list.add(current.getValue());
        //3. recursively call method on the current's right
        if (current.hasRightChild()) {
            recursiveInOrderTraversal(current.getRightChild(), list);
        }
    }

        public List<T> recursivePostOrderTraversal(){
            List<T> result = new ArrayList<>();
            recursivePostOrderTraversal(this.root, result);
            return result;
        }
        public void recursivePostOrderTraversal(TreeNode<T> current, List<T> list){
            //1. recursively call method on currents left child
            if(current.hasLeftChild())
                recursivePostOrderTraversal(current.getLeftChild(), list);
            //2. recursively call method on the current's right
            if(current.hasRightChild())
                recursivePostOrderTraversal(current.getRightChild(),list);
            //3. proccess current node
            list.add(current.getValue());
    }

    public List<T> bfs(){
        List<T> result = new ArrayList<>();
        int h = height(root);
        for(int i = 0; i < h; i++)
            processCurrentLevel(root, i, result);
        return result;
    }
    int height(TreeNode<T> root){
        if (root == null) return 0;
        else{
            int left_height = height((root.getLeftChild()));
            int right_height = height((root.getRightChild()));

            if(left_height > right_height)
                return right_height+1;
            else
                return right_height+1;
        }
    }
    void processCurrentLevel(TreeNode<T> current, int level, List<T> result){
        if (current == null)
            return;
        if (level == 0)
            result.add(current.getValue());
        else if(level > 0){
            processCurrentLevel(current.getLeftChild(), level-1, result);
            processCurrentLevel(current.getRightChild(), level-1, result);
        }

    }

    public static void main(String args[]) {
        BinaryTreeCopy<String> t = new BinaryTreeCopy<>();
        Map<String, TreeNode<String>> m = new HashMap<>();
        for (Character c = 'a'; c <= 'r'; c++) {
            m.put(c.toString(), new TreeNode<>(c.toString()));
        }
        t.root = m.get("a");
        m.get("a").setParent(null).setLeftChild(m.get("b")).setRightChild(m.get("c"));
        m.get("b").setParent(m.get("a")).setLeftChild(m.get("d")).setRightChild(m.get("e"));
        m.get("c").setParent(m.get("a")).setLeftChild(null).setRightChild(m.get("f"));
        m.get("d").setParent(m.get("b")).setLeftChild(m.get("g")).setRightChild(m.get("h"));
        m.get("e").setParent(m.get("b")).setLeftChild(null).setRightChild(m.get("i"));
        m.get("f").setParent(m.get("c")).setLeftChild(m.get("j")).setRightChild(m.get("k"));
        m.get("g").setParent(m.get("d")).setLeftChild(m.get("l")).setRightChild(m.get("m"));
        m.get("h").setParent(m.get("d")).setLeftChild(null).setRightChild(m.get("n"));
        m.get("i").setParent(m.get("e")).setLeftChild(m.get("o")).setRightChild(null);
        m.get("j").setParent(m.get("f")).setLeftChild(m.get("p")).setRightChild(m.get("q"));
        m.get("k").setParent(m.get("f")).setLeftChild(null).setRightChild(null);
        m.get("l").setParent(m.get("g")).setLeftChild(null).setRightChild(null);
        m.get("m").setParent(m.get("g")).setLeftChild(m.get("r")).setRightChild(null);
        m.get("n").setParent(m.get("h")).setLeftChild(null).setRightChild(null);
        m.get("o").setParent(m.get("i")).setLeftChild(null).setRightChild(null);
        m.get("p").setParent(m.get("j")).setLeftChild(null).setRightChild(null);
        m.get("q").setParent(m.get("j")).setLeftChild(null).setRightChild(null);
        m.get("r").setParent(m.get("m")).setLeftChild(null).setRightChild(null);

        //preorder: [a, b, d, g, l, m, r, h, n, e, i, o, c, f, j, p, q, k]
        System.out.println("Pre-order: \n" + t.recursivePreorderTraversal());
        //inorder: [l, g, r, m, d, h, n, b, e, o, i, a, c, p, j, q, f, k]
        System.out.println("In-order: \n" + t.recursiveInOrderTraversal());
        //post order: [l, r, m, g, n, h, d, o, i, e, b, p, q, j, k, f, c, a]
        System.out.println("Post-order: \n" + t.recursivePostOrderTraversal());
        //BFS: alphabetic!
        System.out.println("BFS: \n" + t.bfs());

    }
}
