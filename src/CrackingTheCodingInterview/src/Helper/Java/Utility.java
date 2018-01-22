package CrackingTheCodingInterview.src.Helper.Java;

import java.util.*;
import java.awt.*;

public class Utility {
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static boolean randomBoolean() {
        return randomIntInRange(0, 1) == 0;
    }

    public static boolean randomBoolean(int percentTrue) {
        return randomIntInRange(1, 100) <= percentTrue;
    }

    public static boolean[][] randomBooleanMatrix(int M, int N, int percentTrue) {
        boolean[][] matrix = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomBoolean(percentTrue);
            }
        }
        return matrix;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }


    public static int[] randomArray(int N, int min, int max) {
        int[] array = new int[N];
        for (int j = 0; j < N; j++) {
            array[j] = randomIntInRange(min, max);
        }
        return array;
    }

    public static LinkedListNode randomLinkedList(int N, int min, int max) {
        LinkedListNode root = new LinkedListNode(randomIntInRange(min, max),
                null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            int data = randomIntInRange(min, max);
            LinkedListNode next = new LinkedListNode(data, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    public static LinkedListNode linkedListWithValue(int N, int value) {
        LinkedListNode root = new LinkedListNode(value, null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            LinkedListNode next = new LinkedListNode(value, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    public static LinkedListNode createLinkedListFromArray(int[] vals) {
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        return head;
    }

    public static String arrayToString(int[] array) {
        if (array == null) return "";
        return arrayToString(array, 0, array.length - 1);
    }

    public static String arrayToString(int[] array, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            int v = array[i];
            sb.append(v + ", ");
        }
        return sb.toString();
    }

    public static String stringArrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (String v : array) {
            sb.append(v + ", ");
        }
        return sb.toString();
    }

    public static String toFullBinaryString(int a) {
        String s = "";
        for (int i = 0; i < 32; i++) {
            Integer lsb = Integer.valueOf(a & 1);// new Integer(a & 1);
            s = lsb.toString() + s;
            a = a >> 1;
        }
        return s;
    }

    public static String toBaseNString(int a, int base) {

        String s = "";
        while (true) {
            int lastdigit = a % base;
            s = lastdigit + s;
            a = a / base;
            if (a == 0)
                break;
        }

        return s;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static String charArrayToString(char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0) {
                break;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }

    public static String listOfPointsToString(ArrayList<Point> list) {
        StringBuilder buffer = new StringBuilder();
        for (Point p : list) {
            buffer.append("(" + p.x + "," + p.y + ")");
        }
        return buffer.toString();
    }

    public static TreeNode randomBST(int N, int min, int max) {
        int d = randomIntInRange(min, max);
        TreeNode root = new TreeNode(d);
        for (int i = 1; i < N; i++) {
            root.insertInOrder(randomIntInRange(min, max));
        }
        return root;
    }

    /* Creates tree by mapping the array left to right, top to bottom. */
    public static TreeNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = (TreeNode) queue.element();
                if (r.left == null) {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length) {
                    done = true;
                }
            }
            return root;
        } else {
            return null;
        }
    }

    public static String getLongTextBlob() {
        String book = "As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit. "
                + "Soon Lara spotted other landmarks�an outcropping of limestone beside the path that had a silhouette like a man�s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight."
                + "Lara had been back and forth along the river path many times in her short life. Her people had not created the path�it had always been there, like the river�but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara�s people were salt traders, and their livelihood took them on a continual journey. ";
        String book_mod = book.replace('.', ' ').replace(',', ' ')
                .replace('-', ' ');
        return book_mod;
    }

    public static String[] getLongTextBlobAsStringList() {
        return getLongTextBlob().split(" ");
    }

    public static Trie getTrieDictionary() {
        return new Trie(getListOfWords());
    }

    public static HashSet<String> getWordListAsHashSet() {
        String[] wordList = getListOfWords();
        HashSet<String> wordSet = new HashSet<String>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        return wordSet;
    }

    public static String[] getListOfWords() {
        // Words in the dictionary.
        String[] wordList = {"the", "of", "and", "a", "to", "in", "is", "be"};
        return wordList;
    }
}
