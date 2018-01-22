package com.barclays.test.services;

import com.barclays.test.utility.GateNameToNodeConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sjain203 on 1/21/18.
 */
public class ShortestPathService {

    static int[][] pathMatrix;
    static final int numberOfVertices = 12;

    //100000 represents no path or infinity
    static int[][] inputMatrix = {
            { 0, 100000, 100000, 100000, 100000, 5, 100000, 100000, 100000, 100000, 100000, 100000 },
            { 100000, 0, 1, 100000, 100000, 6, 100000, 100000, 100000, 100000, 100000, 100000 },
            { 100000, 1, 0, 1, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
            { 100000, 100000, 1, 0, 1, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
            { 100000, 100000, 100000, 1, 0, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
            { 5, 6, 100000, 100000, 100000, 0, 100000, 100000, 100000, 100000, 4, 5 },
            { 100000, 100000, 100000, 100000, 100000, 100000, 0, 1, 100000, 100000, 100000, 100000 },
            { 100000, 100000, 100000, 100000, 100000, 100000, 1, 0, 1, 100000, 100000, 100000 },
            { 100000, 100000, 100000, 100000, 100000, 100000, 100000, 1, 0, 1, 100000, 100000 },
            { 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 1, 0, 1, 100000 },
            { 100000, 100000, 100000, 100000, 100000, 4, 100000, 100000, 100000, 1, 0, 100000 },
            { 100000, 100000, 100000, 100000, 100000, 5, 100000, 100000, 100000, 100000, 100000, 0 }
    };

    static int[][] shortestDistanceMatrix = getAllPairShortestDistanceMatrix(inputMatrix);

    /**
     * This is implementation of Floyd-Warshall shortest path algorithm
     *
     * @param inputMatrix
     * @return
     */
    public static int[][] getAllPairShortestDistanceMatrix(int[][] inputMatrix) {
        pathMatrix = new int[numberOfVertices][numberOfVertices];
        for (int k = 0; k < numberOfVertices; k++) {
            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfVertices; j++) {
                    if (inputMatrix[i][k] + inputMatrix[k][j] < inputMatrix[i][j]) {
                        inputMatrix[i][j] = inputMatrix[i][k] + inputMatrix[k][j];

                        //Keeping track of predecessors.
                        pathMatrix[i][j] = k;
                    }
                }
            }
        }
        return inputMatrix;
    }

    /**
     * This method takes source and destination as input and returns shortest distance in the first element in the List,
     * and second element will have optimal path, comma seperated.
     *
     * @param source
     * @param destination
     * @return
     */
    public static List<String> getShortestPath(int source, int destination) throws Exception {
        int originalSource = source;
        int originalDestination = destination;
        Stack path = new Stack();
        path.add(destination);
        if(pathMatrix[source][destination] != 0) {
            //Via node to destination
            int viaNode = pathMatrix[source][destination];
            source = viaNode;
            while (pathMatrix[source][destination] != 0) {
                path.add(pathMatrix[source][destination]);
                destination = pathMatrix[source][destination];
            }
            path.add(viaNode);

            while (pathMatrix[originalSource][viaNode] != 0) {
                path.add(pathMatrix[originalSource][viaNode]);
                viaNode = pathMatrix[originalSource][viaNode];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(GateNameToNodeConversion.getgateByNodeName(originalSource)).append(" ");
        while (path.iterator().hasNext()) {
            sb.append(GateNameToNodeConversion.getgateByNodeName((Integer) path.pop())).append(" ");
        }

        List result = new ArrayList();
        result.add(shortestDistanceMatrix[originalSource][originalDestination]);
        result.add(sb.toString());
        return result;
    }

    /**
     * This method will print the matrix
     * @param Matrix
     */
    public static void printMatrix(int[][] Matrix) {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(Matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

}
