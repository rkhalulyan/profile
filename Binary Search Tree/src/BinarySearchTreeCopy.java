/*
Robert Khalulyan
10/28/22
Project 2
 */
//package Trees;
import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;
import com.sun.source.util.Trees;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//import Algorithms.TreeNode;


public class BinarySearchTreeCopy<T> extends BinaryTreeCopy<T> {
   //returns the number of elements in a tree
    public int size(TreeNode<T> current){
      if(current == null) return 0;
      // every node we visit, we increment our return value
      return 1 + size(current.getLeftChild()) + size(current.getRightChild());
    }

    public int height(TreeNode<T> current){
        if(current == null) return -1;
        int leftHeight = height(current.getLeftChild());
        int rightHeight = height(current.getRightChild());
        //checking to see which path is longer
        if(leftHeight > rightHeight)
            return leftHeight+1;
        else
            return rightHeight+1;
    }

    public int balanceFactor(TreeNode<T> current){
        int leftSubTree = 0;
        int rightSubTree = 0;

        if (current == null)
            return 0;
        //using our heighgt method to get the size of both sub-trees and combine their values
        else {
            leftSubTree = height(current.getLeftChild()) + 1;
            rightSubTree = height(current.getRightChild())+1;
        }

        return leftSubTree-rightSubTree;
    }


    private final Comparator<T> cmp;

    public BinarySearchTreeCopy (Comparator<T> cmp) {
        this.cmp = cmp;
    }
    public boolean contains (T needle) {
        TreeNode<T> current = this.root;
        while(current != null) {
            if(this.cmp.compare(needle, current.getValue())== 0) {
                return true;
            } else if(this.cmp.compare(needle, current.getValue()) < 0) {
                //go to the left child
                current = current.getLeftChild();
            } else if(this.cmp.compare(needle, current.getValue()) > 0) {
                //go to the right child
                current = current.getRightChild();
            }

        }
        return false;

    }


    public TreeNode<T> getParentOf (T needle) {
        TreeNode<T> pre = null;
        TreeNode<T> current = this.root;
        while(current != null) {
            if(this.cmp.compare(needle, current.getValue())== 0) {
                return null;
            } else if(this.cmp.compare(needle, current.getValue()) < 0) {
                //go to the left child
                pre = current;
                current = current.getLeftChild();
            } else if(this.cmp.compare(needle, current.getValue()) > 0) {
                //go to the right child
                pre = current;
                current = current.getRightChild();
            }

        }

        return pre;

    }

    public boolean insert (T element) {
        //First we need a new node to put element in
        TreeNode<T> newNode = new TreeNode<T>(element);
        //Corner case: if the tree is null, which means that you are adding to an empty tree
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        //If not in the tree, I have to search for the parent of the new node
        TreeNode<T> parent = getParentOf(element);
        if (element == null) {
            //If already there, no need to insert
            return false;
        }
        newNode.setParent(parent);
        if (this.cmp.compare(parent.getValue(),newNode.getValue()) < 0) {
            parent.setRightChild(newNode);
        }
        else {
            parent.setLeftChild(newNode);
        }
        //we return true. Inserting a node had an effect on the tree
        return true;

    }
    //wrapper class
    TreeNode<T> findNodeOf(T element){
        TreeNode<T> result = null;
        TreeNode<T> curr = this.root;
        result = findNodeOf(element, result, curr);
        return result;
    }
    TreeNode<T> findNodeOf(T element, TreeNode<T> result, TreeNode<T> curr){
        //using recursion to transverse the BST
        if(this.cmp.compare(element, curr.getValue()) < 0 && curr.hasLeftChild()) {
            result = findNodeOf(element, result, curr.getLeftChild());
        }
        if(this.cmp.compare(element, curr.getValue()) > 0 && curr.hasRightChild()) {
           result = findNodeOf(element, result, curr.getRightChild());
        }
        if(this.cmp.compare(element, curr.getValue()) == 0 ) {
            result = curr;
            return result;
        }
        return result;
    }

    //wrapper class
    T findMax(TreeNode<T> curr){
        T max_value = curr.getValue();
        max_value = findMax(curr, max_value);
        return max_value;
    }
    T findMax(TreeNode<T> curr, T max_value){
        if(curr.hasRightChild()) {
            max_value = findMax(curr.getRightChild(), max_value);
        }
        if(this.cmp.compare(curr.getValue(), max_value) > 0)
            max_value = curr.getValue();
        return max_value;
    }

    public void delete (T element) {
        //First we need to find the node
        TreeNode<T> node = findNodeOf(element);
        //If the node is leaf
        if (!node.hasLeftChild() && !node.hasRightChild()) {
            if (node.getParent().getLeftChild() == node) {
                //if the node is left child
                node.getParent().setLeftChild(null);
            } else {
                //if the node is right child
                node.getParent().setRightChild(null);
            }
        } else if ((node.hasLeftChild() && !node.hasRightChild())){
            //t only has a left child, promote it:
            //set t's parent's child (left or right) to t's left child
            TreeNode<T> parent = node.getParent();
            TreeNode<T> left = node.getLeftChild();
            left.setParent(parent);
            //if t is the left child of the parent
            if(node == parent.getLeftChild()) {
                //set the parent's left child to left:
                parent.setLeftChild(left);
            } else {
                parent.setRightChild(left);
            }
        } else if ((!node.hasLeftChild() && node.hasRightChild())){
            //t only has a right child, promote it:
            //set t's parent's child (left or right) to t's right child
            TreeNode<T> parent = node.getParent();
            TreeNode<T> right = node.getRightChild();
            right.setParent(parent);
            //if t is the left child of the parent
            if(node == parent.getLeftChild()) {
                //set the parent's left child to right:
                parent.setLeftChild(right);
            } else {
                parent.setRightChild(right);
            }
        } else {
            //two children
            //1. find the max of left tree(or the min of the right tree)
            //TODO: finish by using one of the previous cases

            T maxOfLeft = findMax(node.getLeftChild());
            TreeNode<T> predecessor = findNodeOf(maxOfLeft);
            
            TreeNode<T> n = node;
            TreeNode<T> predecessorParent = predecessor.getParent();
            TreeNode<T> predecessorLeftChild = predecessor.getLeftChild();
            n.setValue(predecessor.getValue());

            if(predecessor.hasLeftChild() && !predecessor.hasRightChild()){
                predecessorLeftChild.setParent(predecessorParent);
                predecessorParent.setRightChild(predecessorLeftChild);
            }
            if(!predecessor.hasLeftChild() && !predecessor.hasRightChild()){
                predecessorParent.setRightChild(null);
            }

        }

    }
    public TreeNode<T> rotateRight (TreeNode<T> n){
        TreeNode<T> leftChild =  n.getLeftChild();
        TreeNode<T> leftChildRightChild = leftChild.getRightChild();

        leftChild.setRightChild(n);
        n.setLeftChild(leftChildRightChild);

        return leftChild;
    }
    public TreeNode<T> rotateLeft (TreeNode<T> n){
        TreeNode<T> rightChild = n.getRightChild();
        TreeNode<T> rightChildLeftChild = rightChild.getLeftChild();

        rightChild.setLeftChild(n);
        n.setRightChild(rightChildLeftChild);

        return rightChild;
    }

    public TreeNode<T> AVLTreeRebalance(TreeNode<T> n){
        if (n == null)
            return n;

        TreeNode<T> leftChild = n.getLeftChild();
        TreeNode<T> rightChild = n.getRightChild();
        TreeNode<T> parent = n.getParent();
        int bf = balanceFactor(n);
        if(bf > 1){
            if(balanceFactor(n.getLeftChild()) >= 0) // case 1
               n = rotateRight(n);
            else if(balanceFactor(n.getLeftChild()) < 0){ //case 2
                leftChild = rotateLeft(n.getLeftChild());
                n = rotateRight(n);
            }
        }
        else if(bf < -1){
            if(balanceFactor(rightChild) < 1)   //case 3
                n = rotateLeft(n);
            else if(balanceFactor(rightChild) > 0){ //case 4
                rightChild = rotateRight(rightChild);
                n = rotateLeft(n);
            }
        }
        return n;
    }

    public static void main(String args[]) {

        BinarySearchTreeCopy<Integer> t;

        t = new BinarySearchTreeCopy<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });


        TreeNode<Integer> n50 = new TreeNode<>(50);
        TreeNode<Integer> n40 = new TreeNode<>(40);
        TreeNode<Integer> n60 = new TreeNode<>(60);
        TreeNode<Integer> n20 = new TreeNode<>(20);
        TreeNode<Integer> n45 = new TreeNode<>(45);
        TreeNode<Integer> n90 = new TreeNode<>(90);
        TreeNode<Integer> n10 = new TreeNode<>(10);
        TreeNode<Integer> n24 = new TreeNode<>(24);
        TreeNode<Integer> n49 = new TreeNode<>(49);
        TreeNode<Integer> n80 = new TreeNode<>(80);
        TreeNode<Integer> n95 = new TreeNode<>(95);
        TreeNode<Integer> n02 = new TreeNode<>(02);
        TreeNode<Integer> n15 = new TreeNode<>(15);
        TreeNode<Integer> n28 = new TreeNode<>(28);
        TreeNode<Integer> n48 = new TreeNode<>(48);
        TreeNode<Integer> n75 = new TreeNode<>(75);
        TreeNode<Integer> n85 = new TreeNode<>(85);
        TreeNode<Integer> n12 = new TreeNode<>(12);


        n50.setParent(null).setLeftChild(n40).setRightChild(n60);
        n40.setParent(n50).setLeftChild(n20).setRightChild(n45);
        n60.setParent(n50).setLeftChild(null).setRightChild(n90);
        n20.setParent(n40).setLeftChild(n10).setRightChild(n24);
        n45.setParent(n40).setLeftChild(null).setRightChild(n49);
        n90.setParent(n60).setLeftChild(n80).setRightChild(n95);
        n10.setParent(n20).setLeftChild(n02).setRightChild(n15);
        n24.setParent(n20).setLeftChild(null).setRightChild(n28);
        n49.setParent(n45).setLeftChild(n48).setRightChild(null);
        n80.setParent(n90).setLeftChild(n75).setRightChild(n85);
        n95.setParent(n90).setLeftChild(null).setRightChild(null);
        n02.setParent(n10).setLeftChild(null).setRightChild(null);
        n15.setParent(n10).setLeftChild(n12).setRightChild(null);
        n28.setParent(n24).setLeftChild(null).setRightChild(null);
        n48.setParent(n49).setLeftChild(null).setRightChild(null);
        n75.setParent(n80).setLeftChild(null).setRightChild(null);
        n85.setParent(n80).setLeftChild(null).setRightChild(null);
        n12.setParent(n15).setLeftChild(null).setRightChild(null);

        /* Simple Rotation Tree: */
        /*
        n50.setParent(null).setRightChild(n80).setLeftChild(null);
        n80.setParent(n50).setRightChild(n90).setLeftChild(null);
        n90.setParent(n80).setRightChild(null).setLeftChild(null);
        */

        t.setRoot(n50);
//        System.out.println("Before rotation: \n" + t);
//        t.setRoot(t.AVLTreeRebalance(t.root));
//        System.out.println("After rotation: \n" + t);
        System.out.println(t);
        System.out.println("Size: " + t.size(t.root));
        System.out.println("Height: " + t.height(t.root));
        System.out.println("Balance factor: " + t.balanceFactor(t.root));

        t.delete(50);
        System.out.println("After deleting root node: \n" + t);

        System.out.println("Size: " + t.size(t.root));
        System.out.println("Height: " + t.height(t.root));
        System.out.println("Balance factor: " + t.balanceFactor(t.root));


    }
}