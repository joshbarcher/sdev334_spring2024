package test;

import graphs.MyGraph;

import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        MyGraph<String> network = new MyGraph<>();

        network.addVertex("Billie");
        network.addVertex("Tam");
        network.addVertex("Silvia");
        network.addVertex("Tam");
        network.addVertex("Sally");
        network.addVertex("Todd");
        network.addVertex("Jose");

        //directed edges!
        network.addEdge("Billie", "Tam");
        network.addEdge("Silvia", "Tam");
        network.addEdge("Sally", "Billie");
        network.addEdge("Sally", "Todd");
        network.addEdge("Sally", "Jose");
        network.addEdge("Sally", "Silvia");
        network.addEdge("Sally", "Tam");
        network.addEdge("Billie", "Silvia");

        System.out.println(network);
//        System.out.println(network.containsEdge(
//            "Billie", "Tam"
//        ));
//        System.out.println(network.containsEdge(
//            "Tam", "Billie"
//        ));

        List<String> dfsResults = network.dfs("Sally");
        System.out.println(dfsResults);
    }
}
