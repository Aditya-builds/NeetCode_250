class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seen = set()
        for i in nums:
            if i not in seen:
                seen.add(i)
            elif i in seen:
                return True
        return False