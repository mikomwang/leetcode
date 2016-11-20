class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: TreeNode
        :type key: int
        :rtype: TreeNode
        """
        if key == root.val:
            return self.reformTree(root.left, root.right)
        start = root
        while root.val != None and (key != root.left.val or key != root.right.val):
            if key > root.val:
                root = root.right
            elif key < root.val:
                root = root.left
        if root.val == None:
            return start
        elif root.left.val == key:
            root.left = self.reformTree(root.left.left, root.left.right)
        elif root.right.val == key:
            root.right = self.reformTree(root.right.left, root.right.right)
        return start
            
    
    def reformTree(self, root1, root2):
        allVals = []
        if root1 != None:
            allVals += self.accumulateValues(root1)
        if root2 != None:
            allVals += self.accumulateValues(root2)
        newTree = None
        if allVals != None:
            value = allVals[0]
            newTree = TreeNode(value)
            allVals.pop(value)
        while allVals != []:
            nextValue = allVals[0]
            self.insertIntoTree(newTree, nextValue) 
            allVals.pop(nextValue)
        return newTree

    def insertIntoTree(self, treeroot, value):
        if value < treeroot.val and treeroot.left == None:
            treeroot.left = TreeNode(value)
        elif value < treeroot.val and treeroot.left != None:
            self.insertIntoTree(treeroot.left, value)
        elif value > treeroot.val and treeroot.right == None:
            treeroot.right = TreeNode(value)
        elif value > treeroot.val and treeroot.right != None:
            self.insertIntoTree(treeroot.right, value)
    
    def accumulateValues(self, root):
        if root == None:
            return [] 
        returnlist = [root.val]
        returnlist += self.accumulateValues(root.left)
        returnlist += self.accumulateValues(root.right)
        return returnlist