package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    private App m;

    @BeforeEach
    public void init() {
        m = new App();
    }

    @AfterEach
    public void tearDown() {
        m = null;
    }

    @Test
    public void readMatrix() throws Exception {
        double[][] matrix = {{1,2},{3,4}};
        assertArrayEquals(matrix, m.readmatrix());
    }

    @Test
    public void sum() {
        double[][] matrix1 = {{1,1},{1,1}};
        double[][] matrix2 = {{1,1},{1,1}};
        double[][] result = {{2,2},{2,2}};
        assertArrayEquals(result, m.sum(matrix1, matrix2));
    }

    @Test
    public void subtraction() {
        double[][] matrix1 = {{1,1},{1,1}};
        double[][] matrix2 = {{2,3},{2,3}};
        double[][] result = {{-1,-2},{-1,-2}};
        assertArrayEquals(result, m.subtraction(matrix1, matrix2));
    }

    @Test
    public void multiply() {
        double[][] matrix1 = {{1,2},{3,4}};
        double[][] matrix2 = {{4,3},{2,1}};
        double[][] result = {{8, 5},{20, 13}};
        assertArrayEquals(result,m.multiply(matrix1, matrix2));
    }

    @Test
    public void multiplyByNumber() {
        double[][] matrix = {{1,1},{1,1}};
        double[][] result = {{3,3},{3,3}};
        assertArrayEquals(result, m.multiplyByNumber(matrix, 3));
    }

    @Test
    public void division() {
        double[][] matrix1 = {{1,1},{1,1}};
        double[][] matrix2 = {{2,2},{2,2}};
        double[][] result = {{1,1},{1,1}};
        assertArrayEquals(result, m.division(matrix1, matrix2));
    }

    @Test
    public void comparison() {
        double[][] matrix1 = {{1,1},{1,1}};
        double[][] matrix2 = {{2,2},{2,2}};
        assertFalse(m.comparison(matrix1, matrix2));
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "nenez zenen" })
    void palindromes(String candidate) {
        assertTrue(App.palindrome(candidate));
    }

    @Test
    public void transpose() {
        double[][] matrix = {{1,2},{3,4}};
        double[][] result = {{1,3},{2,4}};
        assertArrayEquals(result, m.transpose(matrix));
    }

    @Test
    public void determinant() throws FileNotFoundException {
        double[][] matrix= {{2,5},{6,2}};
           assertEquals(-26, m.determinant(matrix));
    }

    @Test
    public void minor() {
        double[][] matrix1 = {{2,5},{6,2}};
        double[][] matrix2 = {{2}};
        assertArrayEquals(matrix2, m.minor(matrix1,1,1));
    }

}
