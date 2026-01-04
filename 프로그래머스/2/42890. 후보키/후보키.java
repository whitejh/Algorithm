import java.util.*;

class Solution {
    List<Set<Integer>> candicateKeys;
    List<List<Integer>> combiList;
    int n;

    public int solution(String[][] relation) {
        n = relation[0].length;

        candicateKeys = new ArrayList<>();
        combiList = new ArrayList<>();

        // 조합 생성
        for (int i = 1; i <= n; i++) {
            getCombi(n, 0, i, new ArrayList<>());
        }

        for (int i = 0; i < combiList.size(); i++) {
            // 유일성
            if (!checkU(relation, combiList.get(i))) continue;

            // 최소성
            boolean isM = true;
            for (Set<Integer> key : candicateKeys) {
                if (combiList.get(i).containsAll(key)) {
                    isM = false;
                    break;
                }
            }

            if (isM) {
                candicateKeys.add(new HashSet<>(combiList.get(i)));
            }
        }

        return candicateKeys.size();
    }

    public void getCombi(int n, int start, int max, List<Integer> curList) {
        if (max == curList.size()) {
            combiList.add(new ArrayList<>(curList));
            return;
        }

        for (int i = start; i < n; i++) {
            curList.add(i);
            getCombi(n, i + 1, max, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public boolean checkU(String[][] relation, List<Integer> combi) {
        Set<String> check = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx : combi) {
                sb.append(relation[i][idx]);
            }
            if (!check.add(sb.toString())) return false;
        }

        return true;
    }
}
