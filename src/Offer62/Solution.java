package Offer62;

/**
 * Title:序列化二叉树(前序遍历的应用,遇到Null用特殊字符"#"代替) 
 * Description: 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author rico
 * @created 2017年7月8日 上午10:07:52
 */
public class Solution {

	/**     
	 * @description 前序遍历序列化二叉树
	 * @author rico       
	 * @created 2017年7月9日 上午8:34:24     
	 * @param root
	 * @return     
	 */
	String Serialize(TreeNode root) {
		if (root == null) {
			return "# ";
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(root.val);
			sb.append(" ");
			sb.append(Serialize(root.left));
			sb.append(Serialize(root.right));
			return sb.toString();
		}
	}

	TreeNode Deserialize(String str) {
		String[] seq = str.split(" ");

		return Deserialize(seq);
	}

	int index = 0;

	TreeNode Deserialize(String[] strs) {
		if (index < strs.length) {
			String val = strs[index++];
			if (val.equals("#")) {
				return null;
			} else {
				TreeNode node = new TreeNode(Integer.valueOf(val));
				node.left = Deserialize(strs);
				node.right = Deserialize(strs);
				return node;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(12);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(11);

		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		Solution s = new Solution();

		String str = s.Serialize(node1);
		System.out.println("原：" + str);
		TreeNode root = s.Deserialize(str);
		System.out.println("验：" + s.Serialize(root));
	}
}
