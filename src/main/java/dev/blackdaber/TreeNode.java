package dev.blackdaber;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
class TreeNode {
	private final int value;

	@ToString.Exclude
	private final List<TreeNode> children;
}

class TreeSolution {

	private final List<TreeNode> result = new ArrayList<>();
	private int n;

	public List<TreeNode> searchNodes(TreeNode root, int n) {
		if (root == null) return result;
		this.n = n;

		this.search(root);
		return result;
	}

	public void search(TreeNode parent) {
		if (parent == null) return;
		if (parent.getValue() > n) this.result.add(parent);

		for (var child : parent.getChildren()) this.search(child);

	}

	public static void test() {
		var root = new TreeNode(3, List.of(
				new TreeNode(4, List.of(
						new TreeNode(7, List.of(
								new TreeNode(6, List.of())
						)),
						new TreeNode(8, List.of(
								new TreeNode(6, List.of())
						)),
						new TreeNode(1, List.of())
				)),
				new TreeNode(5, List.of(
						new TreeNode(3, List.of()),
						new TreeNode(4, List.of())
						)),
				new TreeNode(1, List.of(
						new TreeNode(6, List.of()),
						new TreeNode(3, List.of()),
						new TreeNode(2, List.of()),
						new TreeNode(8, List.of()),
						new TreeNode(10, List.of())
				)),
				new TreeNode(4, List.of())
		));

		var solution = new TreeSolution();

		System.out.println(solution.searchNodes(root, 3));
	}
}
