package datastructure.binaryTree;

/**
 * 根据前序和中序遍历数组，构建出二叉树逻辑结构，并以后序遍历方式打印，最后生成此树的镜像树
 * Creted by Dean on 2019-04-11.
 */
public class GenBinaryTree {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] middleOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = genBinaryTree(preOrder, middleOrder);

        System.out.println("后序遍历结果");
        treeNode.postOrderPrint();//后序打印结果，正确结果应该是{7, 4, 2, 5, 8, 6, 3, 1}

        System.out.println("镜像前序遍历结果");
        treeNode.mirrorTreePrint();//镜像树打印
        treeNode.preOrderPrint();//再次前序打印观察是否正确的生成了 镜像树

        TreeNode result = treeNode.frontSearch(3);
        System.out.println("查找结果为" + result);

    }

    private static TreeNode genBinaryTree(int[] preOrder, int[] middleOrder){
        return genBinaryTree(preOrder, 0, preOrder.length - 1, middleOrder, 0, middleOrder.length - 1);
    }


    private static TreeNode genBinaryTree(int[] preOrder, int ps, int pe, int[] middleOrder, int ms, int me){
        if (ps > pe || ms > me){
            //System.out.println("参数越界返回null");
            return null;
        }

        int rootValue = preOrder[ps];//前序的第一个元素肯定是根
        TreeNode rootNode = new TreeNode(rootValue);;

        //找到根节点在中序遍历数组中的下标
        for (int i = ms; i <= me; i++){
            if (middleOrder[i] == rootValue){//找到索引了
                //参数说明，前序左子树范围= ps + 1, ps + i，     中序左子树范围= ms, i - 1
                rootNode.left = genBinaryTree(preOrder, ps + 1, ps + i, middleOrder, ms, i - 1);
                //参数说明，前序右子树范围= i - ms + ps + 1, pe，中序右子树范围= i + 1, me
                rootNode.right = genBinaryTree(preOrder, i - ms + ps + 1, pe, middleOrder, i + 1, me);
                //可以画个图出来，拿第一个根来演算一下参数就出来了
                break;
            }
        }
        return rootNode;
    }

}

//二叉树 节点对象 声明
class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrderPrint() {

        System.out.println(this.value);

        if (this.left != null) {
            this.left.preOrderPrint();
        }
        if(this.right != null){
            this.right.preOrderPrint();
        }
    }

    //中序遍历
    public void inOrderPrint() {
        if (this.left != null) {
            this.left.inOrderPrint();
        }

        System.out.println(this.value);

        if(this.right != null){
            this.right.inOrderPrint();
        }
    }

    //后序遍历
    public void postOrderPrint() {
        if (this.left != null) {
            this.left.postOrderPrint();
        }
        if(this.right != null){
            this.right.postOrderPrint();
        }

        System.out.println(this.value);
    }

    //生成镜像树
    public void mirrorTreePrint(){
        TreeNode temp = this.left;
        this.left = this.right;
        this.right  = temp;

        if (this.left != null) {
            this.left.mirrorTreePrint();
        }
        if (this.right != null) {
            this.right.mirrorTreePrint();
        }
    }

    //前序查找，中序及后序查找类似
    public TreeNode frontSearch(int i){
        if (i == this.value){
            return this;
        }
        TreeNode result = null;
        if (this.left != null){
            result = this.left.frontSearch(i);
            if (result != null){
                return result;
            }
        }
        if (this.right != null){
            result = this.right.frontSearch(i);
            if (result != null){
                return result;
            }
        }
        return result;
    }


    @Override
    public String toString() {
        String leftValue = this.left == null ? "null" : String.valueOf(this.left.value);
        String righttValue = this.right == null ? "null" : String.valueOf(this.right.value);
        return "value=" + this.value + ", leftValue=" + leftValue + ", rightValue=" + righttValue;
    }

}
