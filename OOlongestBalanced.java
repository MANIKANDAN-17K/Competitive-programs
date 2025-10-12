class Solution {
    public int longestBalanced(String s) {
        q3 res=new q3();
        return res.solve(s);
    }
}
class q3 {
public int solve(String s) {
int n = s == null ? 0 : s.length();
if (n == 0) {
// System.out.println("res:0");
return 0;
}
int best = 0;
// System.out.println("single :(");
int run = 1;
for (int i = 1; i < n; i++) {
if (s.charAt(i) == s.charAt(i - 1)) {
run++;
} else {
if (run > best) {
best = run;
// System.out.println("new best=" + best);
}
run = 1;
}
}
if (run > best) {
best = run;
// System.out.println("newnew best=" + best);
}
// System.out.println("pairs chek");
char[] letters = {'a', 'b', 'c'};
for (int p = 0; p < 3; p++) {
for (int q = p + 1; q < 3; q++) {
char x = letters[p];
char y = letters[q];
// System.out.println("processing pair " + x + "," + y);
int idx = 0;
while (idx < n) {
while (idx < n && s.charAt(idx) != x && s.charAt(idx) != y) idx++;
if (idx >= n) break;
int start = idx;
while (idx < n && (s.charAt(idx) == x || s.charAt(idx) == y)) idx++;
int end = idx;
int sum = 0;
HashMap<Integer, Integer> first = new HashMap<>();
first.put(0, start - 1);
for (int k = start; k < end; k++) {
char c = s.charAt(k);
sum += (c == x ? 1 : -1);
if (first.containsKey(sum)) {
int len = k - first.get(sum);
if (len > best) {
best = len;
}
} else {
first.put(sum, k);
}
}
}
}
}
int ca = 0;
int cb = 0;
int cc = 0;
HashMap<Long, Integer> seen = new HashMap<>();
long key0 = (((long)0) << 32) ^ ((long)0 & 0xffffffffL);
seen.put(key0, -1);
for (int i = 0; i < n; i++) {
char c = s.charAt(i);
if (c == 'a') ca++;
else if (c == 'b') cb++;
else cc++;
int d1 = ca - cb;
int d2 = ca - cc;
long key = (((long)d1) << 32) ^ ((long)d2 & 0xffffffffL);
if (seen.containsKey(key)) {
int prev = seen.get(key);
int len = i - prev;
if (len > best) {
best = len;
}
} else {
seen.put(key, i);
}
}
// System.out.println("res:" + best);
return best;
}
}
