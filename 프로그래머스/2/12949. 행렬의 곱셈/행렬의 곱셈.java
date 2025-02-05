class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {

            // TODO 1 : 행렬 arr1과 arr2의 행과 열의 수
            int r1 = arr1.length;
            int c1 = arr1[0].length;
            int r2 = arr2.length;
            int c2 = arr2[0].length;

            // TODO 2 : 결과를 저장할 2차원 배열 초기화
            int[][] answer = new int[r1][c2];
            
            // TODO 3 : 첫번째 행렬 arr1의 각 행과 두번째 행렬 arr2의 각 열에 대해
            for(int i = 0; i < r1; i++) {
                for(int j = 0; j < c2; j++) {
                    // TODO 4 : 두 행렬의 데이터를 곱해 결과 리스트에 더함
                    for(int k = 0; k < c1; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }
            
            return answer;
        }
    }