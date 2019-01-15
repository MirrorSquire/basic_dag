package implementation;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DagTest {

    private Node buildNodeAndGetRoot() {
        Node root = new Node("Football");
        Node competition = new Node("competition");
        Node player = new Node("player");
        root.addChild(competition);
        root.addChild(player);

        Node premiership = new Node("premiership");
        Node champsLeague = new Node("champions league");

        competition.addChild(premiership);
        competition.addChild(champsLeague);

        Node manCity = new Node("man city");
        Node manUtd = new Node("man utd");

        premiership.addChild(manUtd);
        premiership.addChild(manCity);

        champsLeague.addChild(manUtd);

        return root;
    }

    private Node findNode(Node root, String name) {
        return root.findNode(name);
    }

    @Test
    public void test_getParents() {
        Node root = buildNodeAndGetRoot();

        Node node = findNode(root, "man utd");

        List<Node> parents = root.getParents(node);

        Assert.assertEquals(2, parents.size());
    }

    @Test
    public void test_getChildren() {
        Node root = buildNodeAndGetRoot();

        List<Node> parents = root.getChildren();

        Assert.assertEquals(2, parents.size());
    }

    @Test
    public void test_getAllDescendants() {
        Node root = buildNodeAndGetRoot();

        List<Node> allDescendants = root.getAllDescendants();

        Assert.assertEquals(6, allDescendants.size());
    }
}
