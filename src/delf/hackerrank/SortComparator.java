package hackerrank;

import java.util.Comparator;

/**
 * Sorting: Comparator
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 */
public class SortComparator {
    static class Checker implements Comparator<Player> {
        public int compare(Player a, Player b) {
            if (a.score == b.score) {
                return a.name.compareTo(b.name);
            }
            return b.score - a.score;
        }
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
