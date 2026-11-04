class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        seen = {}

        for i in range(len(nums)):

            comp = target - nums[i]
            if comp not in seen:
                seen[nums[i]] = i

            elif comp in seen:
                return [seen[comp],i]




class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        hash = {}
        for i in range(len(nums)):
            if nums[i] not in hash:
                complement = target - nums[i]
                hash[complement] = i

            elif nums[i] in hash:
                return [hash[nums[i]],i]