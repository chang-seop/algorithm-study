package StudyFiles.BinarySearchTree.StudyFile;

import java.util.Comparator;

public class BinarySearchTree<E> {

    private Node<E> root;
    private int size;

    private final Comparator<? super E> comparator;

    public BinarySearchTree() {
        this(null);
    }


    public BinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }

    /**
     * Binary Search Tree에 삽입하는 메소드
     *
     * @param value 삽입하고자 하는 데이터
     * @return 정상적으로 삽입 되었을 경우 true, 중복 원소를 삽입할 경우 false를 반환
     */
    public boolean add(E value) {

        /*
         * comparator(사용자 지정 비교기)가 없을 경우(=null)에는 Comparable,
         * 있을 경우에는 Comparator를 사용하는 메소드로 보낸다.
         * 그리고, 각 메소드는 정상적으로 삽입이 완료되었다면 null을 반환할 것이고,
         * 중복 원소를 삽입 할 경우 해당 value를 반환할 것이기 때문에
         * 비교 연산으로 null인지 아닌지 여부를 반환한다.
         */
        if(comparator == null) {
            return addUsingComparable(value) == null;
        }
        return addUsingComparator(value, comparator) == null;
    }

    // Comparable을 이용한 add메소드
    private E addUsingComparable(E value) {

        Node<E> current = root; // 탐색할 노드를 가리키는 current node

        // 만약 current가 null, 즉 root가 null이면 root에 새 노드를 만들고 null반환
        if(current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        Node<E> currentParent;	// current의 직전 탐색 노드를 가리키는 노드

        // 삽입 할 노드가 비교 될 수 있도록 한 변수를 만든다.
        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue = (Comparable<? super E>) value;

        int compResult;	// 비교 결과(양수, 0, 음수)를 담고 있을 변수

        do {
            // 다음 순회에서 current의 부모노드를 가리킬 수 있도록 현재 current를 저장
            currentParent = current;

            compResult = compValue.compareTo(current.value);

            /*
             * 비교 결과 value 보다 current.value 보다 작으면
             * current를 current의 왼쪽 자식으로 갱신하고,
             * value보다 current.value가 크다면 current를 오른쪽
             * 자식으로 갱신하며, 같을 경우 순회를 중단하고 value를 반환한다.
             */
            if(compResult < 0) {
                current = current.left;
            } else if(compResult > 0) {
                current = current.right;
            }
            else {
                return value;
            }

        } while(current != null);


        // 순회가 완료되어 삽입해야 할 위치를 찾았다면 삽입 할 value를 노드로 만든다.
        Node<E> newNode = new Node<E>(value, currentParent);

        // 직전 비교 결과에 따라 currentParent의 오른쪽 혹은 왼쪽 노드에 새 노드를 연결해준다.
        if(compResult < 0) {
            currentParent.left = newNode;
        }
        else {
            currentParent.right = newNode;
        }

        size++;
        return null;
    }

    // Comparator을 이용한 add
    private E addUsingComparator(E value, Comparator<? super E> comp) {

        Node<E> current = root;
        if(current == null) {
            root = new Node<E>(value, null);
            size++;
            return null;
        }

        Node<E> currentParent;
        int compResult;
        do {
            currentParent = current;
            compResult = comp.compare(value, current.value);
            if(compResult < 0) {
                current = current.left;
            }
            else if(compResult > 0) {
                current = current.right;
            }
            else {
                return value;
            }
        } while(current != null);

        Node<E> newNode = new Node<E>(value, currentParent);
        if(compResult < 0) {
            currentParent.left = newNode;
        }
        else {
            currentParent.right = newNode;
        }
        size++;
        return null;
    }

    /**
     * 삭제 메소드
     * @param o 삭제할 값
     * @return 삭제 된 노드의 value 값 혹은 매칭 값이 없을 경우 null을 반환한다.
     */
    public E remove(Object o) {

        if (root == null) {
            return null;
        }
        if (comparator == null) {
            return removeUsingComparable(o);
        } else {
            return removeUsingComparator(o, comparator);
        }
    }

    /**
     * Comparable을 이용한 데이터 삭제
     *
     * @param value 삭제하고자 하는 데이터
     * @return 정상적으로 삭제되었을 경우 value를 반환하나, 삭제할 노드가 없을경우 null을 반환한다.
     */
    private E removeUsingComparable(Object value) {
        @SuppressWarnings("unchecked")
        E oldVal = (E) value;
        Node<E> parent = null, current = root;
        // 삭제하고자 하는 노드가 부모 노드로부터 왼쪽 자식 노드인지 오른쪽 자식 노드인지 알기 위한 변수
        boolean hasLeft = false;

        if (root == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue = (Comparable<? super E>) value;

        // 삭제할 노드를 찾는다.
        do {
            int resComp = compValue.compareTo(current.value);
            if (resComp == 0) {
                break;
            }

            parent = current;
            if (resComp < 0) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        } while (current != null);

        // 만약 탐색 끝에 삭제해야할 노드를 찾지 못했다면 null 반환
        if (current == null) {
            return null;
        }

        // 부모 노드가 없을 경우 == 삭제하는 노드가 root일 경우
        if (parent == null) {
            deleteNode(current);
            size--;
            return oldVal;
        }

        // 삭제 노드가 부모노드의 왼쪽 자식일 경우
        if (hasLeft) {
            parent.left = deleteNode(current);
            // 만약 새로 이어질 노드가 존재한다면, 해당 대체 노드의 부모노드도 갱신
            if (parent.left != null) {
                parent.left.parent = parent;
            }
        }
        // 삭제 노드가 부모노드의 오른쪽 자식일 경우
        else {
            parent.right = deleteNode(current);
            // 만약 새로 이어질 노드가 존재한다면, 해당 대체 노드의 부모노드도 갱신
            if (parent.right != null) {
                parent.right.parent = parent;
            }
        }
        size--;
        return oldVal;
    }

    /**
     * Comparator을 이용한 데이터 삭제
     *
     * @param value 삭제하고자 하는 데이터
     * @param comparator 사용자에 의해 BinarySearchTree에 지정 된 비교기
     * @return 정상적으로 삭제되었을 경우 value를 반환하나, 삭제할 노드가 없을경우 null을 반환한다.
     */
    private E removeUsingComparator(Object value, Comparator<? super E> comp) {
        @SuppressWarnings("unchecked")
        E oldVal = (E) value;
        Node<E> parent = null, current = root;
        boolean hasLeft = false;

        if (root == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        E compValue = (E) value;

        // 삭제할 노드를 찾는다.
        do {
            int resComp = comp.compare(compValue, current.value);
            if (resComp == 0) {
                break;
            }

            parent = current;
            if (resComp < 0) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        } while (current != null);

        if (current == null) {
            return null;
        }

        if (parent == null) {
            deleteNode(current);
            size--;
            return oldVal;
        }

        if (hasLeft) {
            parent.left = deleteNode(current);
            if (parent.left != null) {
                parent.left.parent = parent;
            }
        } else {
            parent.right = deleteNode(current);
            if (parent.right != null) {
                parent.right.parent = parent;
            }
        }
        size--;
        return oldVal;
    }

    /**
     * 삭제 할 노드에 대해 삭제를 수행하는 메소드
     *
     * @param node 삭제 할 노드
     * @return 삭제 후 대체 되고 난 뒤의 해당 위치의 노드를 반환
     */
    private Node<E> deleteNode(Node<E> node) {

        if (node != null) {
            // 자식노드가 없을 경우
            if (node.left == null && node.right == null) {
                // 삭제하려는 노드가 root일 경우 root를 끊어버리고 종료한다.
                if (node == root) {
                    root = null;
                }
                // 그 외에는 단말 노드이므로 해당 노드만 삭제한다.
                // 자연스럽게 node의 부모노드는 null을 참조하게 됨
                else {
                    node = null;
                }
                return null;
            }

            // 양쪽의 자식노드가 모두 있을 경우
            if (node.left != null && node.right != null) {
                // 대체 노드를 찾아온다.
                Node<E> replacement = getSuccessorAndUnlink(node);

                // 삭제 된 노드에 대체 노드의 값을 대체해준다.
                node.value = replacement.value;
            }
            // 왼쪽 노드만 존재할 경우
            else if (node.left != null) {
                /*
                 *  삭제할 노드가 root일 경우 왼쪽자식 노드(대체되는 노드)를
                 *  삭제할 노드로 옮긴 다음 root를 대체노드를 가리키도록 변경한다
                 */
                if (node == root) {
                    node = node.left;
                    root = node;
                    root.parent = null;
                } else {
                    node = node.left;
                }
            }
            // 오른쪽 노드만 존재할 경우
            else {
                /*
                 *  삭제할 노드가 root일 경우 오른쪽자식 노드(대체되는 노드)를
                 *  삭제할 노드로 옮긴 다음 root를 대체노드를 가리키도록 변경한다
                 */
                if (node == root) {
                    node = node.right;
                    root = node;
                    root.parent = null;
                } else {
                    node = node.right;
                }
            }
        }

        return node;
    }

    /**
     * 삭제되는 노드의 자리를 대체할 노드(후계자)를 찾는 메소드
     * (오른쪽 자식 노드 중 가장 작은 노드를 찾음)
     *
     * @param node 삭제되는 노드(=대체되어야 할 노드)
     * @return 대체할 노드
     */
    private Node<E> getSuccessorAndUnlink(Node<E> node) {

        Node<E> currentParent = node; // 대체 할 노드의 부모노드를 가리키는 노드
        Node<E> current = node.right; // 초기에 오른쪽 자식 노드를 가리키도록 한다.

        /**
         * 처음 탐색하게되는 오른쪽 자식 노드(current)에서
         * current의 왼쪽 자식이 없다는 것은 current노드,
         * 즉 오른쪽 첫 자식노드가 대체되는 노드가 된다는 것이다.
         *
         * 그렇기 때문에 대체해야하는 노드는 삭제되는 노드의 오른쪽 자식이 되며
         * 이에 대체되는 노드 자리(currentParent)의 오른쪽 자식은
         * current의 오른쪽 자식을 가리키고, currentParent는 이후
         * current의 값이 반환되고, 상위 메소드에서 currentParent자리에
         * 값이 대체되게 된다.
         */
        if (current.left == null) {
            currentParent.right = current.right;
            if (currentParent.right != null) {
                currentParent.right.parent = currentParent;
            }
            current.right = null;
            return current;

        }

        // 가장 작은 노드를 찾을 때 까지 반복한다.
        while (current.left != null) {
            currentParent = current;
            current = current.left;
        }

        /*
         * 만약 후계자가 될 노드(가장 작은 노드)의 오른쪽 노드가 존재한다면
         * currentParent의 왼쪽 자식노드는 오른쪽 자식노드와 연결되어야 한다.
         *
         * 만약 current.right = null 이라면
         * 후계자가 될 노드의 자식노드는 존재하지 않으므로 자연스럽게
         * 후계자 노드의 부모노드는 후계자가 다른노드로 대체되러 가기 때문에
         * 후계자의 부모노드의 왼쪽자식노드는 자연스럽게 null을 가리키게 된다.
         */
        currentParent.left = current.right;
        if (currentParent.left != null) {
            currentParent.left.parent = currentParent;
        }

        current.right = null;
        return current;
    }


    /**
     * BinarySearchTree에 있는 원소의 개수를 반환해주는 메소드
     *
     * @return BinarySearchTree에 있는 원소의 개수를 반환
     */
    public int size() {
        return this.size;
    }

    /**
     * BinarySearchTree가 비어있는지를 판단하는 메소드
     *
     * @return BinarySearchTree가 비어있을 경우 true, 아닐경우 false를 반환
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 해당 객체가 BinarySearchTree에 존재하는지를 판단하는 메소드
     *
     * @param o 찾고자 하는 객체
     * @return 해당 객체가 존재 할 경우 true, 아닐 경우 false를 반환
     */
    public boolean contains(Object o) {
        // comparator가 null 일경우 Comparable로 비교하도록 한다.
        if (comparator == null) {
            return containsUsingComparable(o);
        }
        return containsUsingComparator(o, comparator);
    }

    /**
     * Comparable을 이용한 객체 존재 여부를 판단하는 메소드
     *
     * @param o 찾고자 하는 객체
     * @return 해당 객체가 존재 할 경우 true, 아닐 경우 false를 반환
     */
    private boolean containsUsingComparable(Object o) {

        // 비교 가능한 변수로 만든다
        @SuppressWarnings("unchecked")
        Comparable<? super E> value = (Comparable<? super E>) o;

        Node<E> node = root;
        while (node != null) {
            int res = value.compareTo(node.value);
            if (res < 0) {
                node = node.left;
            } else if (res > 0) {
                node = node.right;
            }
            // res == 0 이라는 것은 같다는 의미로 true를 반환
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * Comparable을 이용한 객체 존재 여부를 판단하는 메소드
     *
     * @param o 찾고자 하는 객체
     * @param comparator 사용자에 의해 BinarySearchTree에 지정 된 비교기
     * @return 해당 객체가 존재 할 경우 true, 아닐 경우 false를 반환
     */
    private boolean containsUsingComparator(Object o, Comparator<? super E> comparator) {
        @SuppressWarnings("unchecked")
        E value = (E) o;

        Node<E> node = root;
        while (node != null) {
            int res = comparator.compare(value, node.value);
            if (res < 0) {
                node = node.left;
            } else if (res > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * BinarySearchTree를 초기화 하는 메소드
     */
    public void clear() {
        size = 0;
        /*
         *  root를 끊어주면 하위 모든 노드들도 더이상
         *  참조할 수 없기 때문에 GC 처리 된다.
         */
        root = null;
    }


    /**
     * 전위 순회
     * (부모 노드 > 왼쪽 자식 노드 > 오른쪽 자식 노드)
     */
    public void preorder() {
        preorder(this.root);
    }

    public void preorder(Node<E> o) {
        // null이 아닐 떄 까지 재귀적으로 순회
        if(o != null) {
            System.out.print(o.value + " ");	// 부모 노드
            preorder(o.left);	// 왼쪽 자식 노드
            preorder(o.right);	// 오른쪽 자식 노드
        }
    }

    /**
     * 중위 순회
     * (왼쪽 자식 노드 > 부모 노드 > 오른쪽 자식 노드)
     */
    public void inorder() {
        inorder(this.root);
    }

    public void inorder(Node<E> o) {
        if(o != null) {
            inorder(o.left);	// 왼쪽 자식 노드
            System.out.print(o.value + " ");	// 부모 노드
            inorder(o.right);	// 오른쪽 자식 노드
        }
    }

    /**
     * 후위 순회
     * (왼쪽 자식 노드 > 오른쪽 자식 노드 > 부모 노드)
     */
    public void postorder() {
        postorder(this.root);
    }

    public void postorder(Node<E> o) {
        if(o != null) {
            postorder(o.left);	// 왼쪽 자식 노드
            postorder(o.right);	// 오른쪽 자식 노드
            System.out.print(o.value + " ");	// 부모 노드
        }
    }

    /**
     * 역 중위 순회
     */
    public void reverseInorder() {
        reverseInorder(this.root);
    }

    public void reverseInorder(Node<E> o) {
        if (o != null) {
            reverseInorder(o.right);	// 오른쪽 자식 노드
            System.out.print(o.value + " ");	// 부모 노드
            reverseInorder(o.left); 	// 왼쪽 자식 노드

        }
    }
}