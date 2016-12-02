def isBST(tree, referenceVal):
    if (tree == null):
        return True
    left = tree.left
    right = tree.right
    leftResult = True
    rightResult = True
    
    if (left == null and right == null):
        return True
    elif ((left != null) and (left.val < tree.val and (referenceVal == None or left.val > referenceVal)):
        leftResult = isBST(left, tree.val)
    elif ((right != null) and (right.val > tree.val and (referenceVal == None or right.val < referenceVal)):
        rightResult = isBST(right, tree.val)
    else:
        return False
    return leftResult and rightResult
     
isBST(t, v)
        


       t=        5                      5
               /   \                      \
              3      8                     2
               \    /  
                4  2
       v= None