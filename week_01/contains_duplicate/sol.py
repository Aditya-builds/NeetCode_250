class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:
        seen = set()
        for i in nums:
            if i not in seen:
                seen.add(i)
            else: 
                return True
        return False