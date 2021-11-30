package main;

import main.ListGraph.*;
import main.MatrixGraph.*;

import java.util.Scanner;

import main.List.*;

/**
 * Main function for user input to test graphs in both array and linkedlists with BreadthFirst traversal and DepthFirst traversal.
 */
public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        String stringInput;

        while (!quit) {
            System.out.println("Choose\n" +
                    "1 to enter a start\n" +
                    "0 to exit: \n");
            boolean hasNextInt = scanner.hasNextInt(); //returns true if the scanner's input is an integer
            if (hasNextInt) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("You have left the program.");
                        quit = true;
                        break;
                    case 1:
                        System.out.print("Choose an option below:\n" +
                                "\n1. Adjacency List" +
                                "\n2. Adjacency Matrix\n");
                        hasNextInt = scanner.hasNextInt();
                        if (hasNextInt) {
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if (choice == 1) {
                                ListGraph<Character> graph = GraphCreation.createGivenListGraph();
                                QueueInterface<Character> result = LTraversal.depthFirst(graph);
                                QueueInterface<Character> result1 = LTraversal.breadthFirst(graph);
                                System.out.println("The graph you have created is shown below: \n" + graph.toString());
                                System.out.print("Enter 1 to see BreadthFirstSearch (BFS)\nEnter 2 to see DepthFirstSearch\nEnter 3 to see both\n");
                                hasNextInt = scanner.hasNextInt();
                                if(hasNextInt)
                                {
                                    choice = scanner.nextInt();
                                    if(choice == 1)
                                    {
                                        System.out.println("BreadthFirstSearch: " + displayQueue(result1));
                                    }
                                    else if(choice == 2)
                                    {
                                        result = LTraversal.depthFirst(graph);
                                        System.out.println("DepthFirstSearch: " + displayQueue(result));
                                    }
                                    else if(choice == 3)
                                    {
                                        System.out.println("BreadthFirstSearch: " + displayQueue(result1) + "\nDepthFirstSearch: " + displayQueue(result));
                                    }
                                }
                                else
                                {
                                    throw new IllegalArgumentException("Please choose an option by entering an integer: 1, 2 or 3");
                                }
                                break;
                            } else if (choice == 2) {
                                MatrixGraph<Character> graph = GraphCreation.createGivenMatrixGraph();
                                QueueInterface<Character> result = MTraversal.depthFirst(graph);
                                QueueInterface<Character> result1 = MTraversal.breadthFirst(graph);
                                System.out.println("The graph you have created is shown below: \n" + graph.toString());
                                System.out.print("Enter 1 to see BreadthFirstSearch (BFS)\nEnter 2 to see DepthFirstSearch\nEnter 3 to see both\n");
                                hasNextInt = scanner.hasNextInt();
                                if(hasNextInt)
                                {
                                    choice = scanner.nextInt();
                                    if(choice == 1)
                                    {
                                        System.out.println("BreadthFirstSearch: " + displayQueue(result));
                                    }
                                    else if(choice == 2)
                                    { 
                                        System.out.println("DepthFirstSearch: " + displayQueue(result));
                                    }
                                    else if(choice == 3)
                                    {
                                        System.out.println("BreadthFirstSearch: " + displayQueue(result1) + "\nDepthFirstSearch: " + displayQueue(result));
                                    }
                                }
                                else
                                {
                                    throw new IllegalArgumentException("Please choose an option by entering an integer: 1, 2 or 3");
                                }
                                break;
                            }
                            else {
                                throw new IllegalArgumentException("Please choose an option by entering an integer: 1 or 2");
                            }
                        } else {
                            throw new IllegalArgumentException("Please choose an option by entering an integer: 1 or 2");
                        }

                }
            } else {
                System.out.println("Unable to parse choice: Please enter an integer of choice");
                throw new IllegalArgumentException("Please enter an integer of choice");
            }
        }
    }
    

    private static String displayQueue(QueueInterface<Character> result) throws EmptyQueueException
    {
        String output = "";
        while(!result.isEmpty())
        {
            output += "," + result.dequeue();
        }

        return output.substring(1);
    }

}
