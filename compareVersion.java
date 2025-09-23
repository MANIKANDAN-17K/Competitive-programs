class Solution {
    public int compareVersion(String version1, String version2) {
      String[] lenght1 = version1.split("\\.");
      String[] lenght2 = version2.split("\\.");
      int len = Math.max(lenght1.length,lenght2.length);
      for(int i = 0;i<len;i++){
        int num1 = i < lenght1.length ? Integer.parseInt(lenght1[i]) : 0;
        int num2 = i < lenght2.length ? Integer.parseInt(lenght2[i]) : 0;
        if( num1 < num2) return -1;
        if( num1 > num2) return 1;
      }
      return 0;
    }
}
