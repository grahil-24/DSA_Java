package AdvancedGraphs;

import java.util.*;

public class DFS_Recursive {

    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for (List<String> ticket : tickets) {
            graph
                    .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                    .add(ticket.get(1));
        }

        stack.push("JFK");
        while (!stack.isEmpty()) {
            String nextDestination = stack.peek();

            if (
                    !graph
                            .getOrDefault(nextDestination, new PriorityQueue<>())
                            .isEmpty()
            ) {
                stack.push(graph.get(nextDestination).poll());
            } else {
                itinerary.addFirst(stack.pop());
            }
        }
        return itinerary;
    }


    public static void main(String[] args) {
        List<List<String>> airportPairs = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("JFK", "SFO")),
                new ArrayList<>(Arrays.asList("JFK", "ATL")),
                new ArrayList<>(Arrays.asList("SFO", "ATL")),
                new ArrayList<>(Arrays.asList("ATL", "JFK")),
                new ArrayList<>(Arrays.asList("ATL", "SFO"))
        ));

        DFS_Recursive ag = new DFS_Recursive();
        System.out.println(ag.findItinerary(airportPairs));

    }
}
