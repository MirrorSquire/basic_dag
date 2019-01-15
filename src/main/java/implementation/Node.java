package implementation;

import java.util.ArrayList;
import java.util.List;

public class Node {

    final String name;
    private List<Node> children;

    public Node(String name) {

        this.name = name;
        children = new ArrayList<Node>();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }


    public List<Node> getChildren() { return children; }

    public List<Node> getParents(Node node) {
        return getParents(node, new ArrayList<Node>());
    }

    private List<Node> getParents(Node node, List<Node> parents) {

        for(Node node1:children) {
            if(node1.getChildren().contains(node) && !parents.contains(node1))
                parents.add(node1);
            else
                node1.getParents(node, parents);
        }

        return parents;

    }

    public List<Node> getAllDescendants() {
        return getAllDescendants(new ArrayList<Node>());
    }

    private List<Node> getAllDescendants(List<Node> currentDescendants) {

        for(Node node : children) {
            if(!currentDescendants.contains(node)) {
                currentDescendants.add(node);
                node.getAllDescendants(currentDescendants);
            }
            else {
                node.getAllDescendants(currentDescendants);
            }
        }

        return currentDescendants;

    }

    public Node findNode(String name) {

        return findNode(name, null);
    }

    private Node findNode(String name, Node node) {

        for(Node child : children) {
            if(child.name.equals(name))
                node = child;
            else
                node = child.findNode(name, node);
        }

        return node;

    }
}
