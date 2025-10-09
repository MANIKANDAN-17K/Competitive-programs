
class Solution {
    private List<List<Integer>> result = new ArrayList<>();;
    public List<List<Integer>> generate(int numRows) {
        for(int i = 1; i <= numRows; i++){
            result.add(pascalTriangle(i));
        }
        return result;
    }
    public List<Integer> pascalTriangle(int row){
        
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        long ans = 1;

        for(int col = 1;col < row;col++){
            ans = ans * (row - col);
            ans = ans / col;
            rowList.add((int) ans);
        }
        return rowList;

    }
}
