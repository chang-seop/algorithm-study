package StudyFiles.BinarySearchTree.StudyFile;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        // 예제에 있는 트리와 동일하게 구성
        tree.add(23);
        tree.add(12);
        tree.add(40);
        tree.add(7);
        tree.add(16);
        tree.add(1);
        tree.add(14);
        tree.add(17);
        tree.add(29);
        tree.add(55);
        tree.add(61);

        System.out.print("전위 순회 : ");
        tree.preorder();    // 전위 순회
        System.out.println();

        System.out.print("중위 순회 : ");
        tree.inorder(); 	// 중위 순회
        System.out.println();

        System.out.print("후위 순회 : ");
        tree.postorder();   // 후위 순회
        System.out.println();

        System.out.print("역중위 순회 : ");
        tree.reverseInorder();	// 역중위 순회
        System.out.println();
    }
}
