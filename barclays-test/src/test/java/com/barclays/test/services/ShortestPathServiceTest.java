package com.barclays.test.services;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sjain203 on 1/21/18.
 */

public class ShortestPathServiceTest {

    @Test
    public void ensureAllPairShortestPathMatrixIsComputed() {

        int[][] inputMatrix = {
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

        int result[][] = ShortestPathService.getAllPairShortestDistanceMatrix(inputMatrix);
        assertNotNull(result);
    }

    @Test
    public void ensureShortestDistanceAndPathAreObtainedWithCorrectValues() {
        try {
            List result = ShortestPathService.getShortestPath(5, 4);
            assertEquals(9, result.get(0));
            assertEquals("A5 A1 A2 A3 A4", result.get(1).toString().trim());

            result = ShortestPathService.getShortestPath(2, 1);
            assertEquals(1, result.get(0));
            assertEquals("A2 A1", result.get(1).toString().trim());
        } catch (Exception ex) {

        }
    }
}