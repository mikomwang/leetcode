class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        dictionary = {}
        finalString = ""
        for i in range(len(s)):
            if s[i] in dictionary:
                dictionary[s[i]] += 1
            else:
                dictionary[s[i]] = 1
        print dictionary
        while dictionary != {}:
            target = max(dictionary.values())
            print target
            for key, value in dictionary.items():
                if value == target:
                    for _ in range(value):
                        finalString += key
                    dictionary.pop(key)
        return finalString

# naive solution. wut