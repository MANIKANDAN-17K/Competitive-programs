"""
Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the following conditions:

    The substrings do not overlap, that is for any two substrings s[i..j] and s[x..y], either j < x or i > y is true.
    A substring that contains a certain character c must also contain all occurrences of c.

Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same number of substrings, return the one with minimum total length. It can be shown that there exists a unique solution of minimum total length.

Notice that you can return the substrings in any order.

 

Example 1:

Input: s = "adefaddaccc"
Output: ["e","f","ccc"]
Explanation: The following are all the possible substrings that meet the conditions:
[
  "adefaddaccc"
  "adefadda",
  "ef",
  "e",
  "f",
  "ccc",
]
If we choose the first string, we cannot choose anything else and we'd get only 1. If we choose "adefadda", we are left with "ccc" which is the only one that doesn't overlap, thus obtaining 2 substrings. Notice also, that it's not optimal to choose "ef" since it can be split into two. Therefore, the optimal way is to choose ["e","f","ccc"] which gives us 3 substrings. No other solution of the same number of substrings exist.

Example 2:

Input: s = "abbaccd"
Output: ["d","bb","cc"]
Explanation: Notice that while the set of substrings ["d","abba","cc"] also has length 3, it's considered incorrect since it has larger total length.

 

Constraints:

    1 <= s.length <= 105
    s contains only lowercase English letters.

"""

class Seg:
    def __init__(self,left=-1,right=-1):
        self.left = left
        self.right = right

    def __lt__(self,rhs):
        return (
            self.left > rhs.right
            if self.right == rhs.right
            else self.right < rhs.right
        )
class Solution:
    def maxNumOfSubstrings(self, s: str) -> list[str]:
        seg = [Seg() for _ in range(26)]
        for i in range(len(s)):
            char_idx = ord(s[i]) - ord("a")
            if seg[char_idx].left == -1:
                seg[char_idx].left = seg[char_idx].right = i
            else:
                seg[char_idx].right = i

        for i in range(26):
            if seg[i].left != -1:
                j = seg[i].left
                while j <= seg[i].right:
                    char_idx = ord(s[j]) - ord("a")
                    if(
                        seg[i].left <= seg[char_idx].left and seg[char_idx].right <= seg[i].right
                    ):
                        pass
                    else:
                        seg[i].left = min(seg[i].left,seg[char_idx].left)
                        seg[i].right = max(seg[i].right,seg[char_idx].right)
                        j = seg[i].left
                    j += 1
        seg.sort()
        ans = list()
        end = -1
        for segment in seg:
            left,right = segment.left,segment.right
            if left == -1:
                continue
            if end == -1 or left > end:
                end = right
                ans.append(s[left : right + 1])

        return ans 
        
