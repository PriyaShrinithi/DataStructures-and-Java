class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode()
    {

    }
}
public class InvertTree
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root != null)
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root!=null)
            invertTree(root.left);
        if(root!=null)
            invertTree(root.right);

            return root;
    }
}
