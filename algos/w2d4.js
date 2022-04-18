// https://www.cs.usfca.edu/~galles/visualization/BST.html
// http://btv.melezinek.cz/binary-search-tree.html

class BSTNode {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
};

class BST {
    constructor() {
        this.root = null;
    }

    isEmpty() {
        return this.root === null;
    };

    insert(node, current) {
        // default current to root if no current exists
        if (current === undefined) {
            current = this.root;
        };

        // if empty tree, new node becomes root
        if (current === null) {
            this.root = node;
            return;
        };

        if (current.val > node.val) { // go left
            // check if null and insert
            if (current.left === null) { // <-- base case for inserting left
                current.left = node;
                return;
            } else {
                // otherwise recurse left
                return this.insert(node, current.left); // <-- move current to current.left
            }
        } else if (current.val < node.val) { // go right
            // check if null and insert
            if (current.right === null) { // <-- base case for inserting left
                current.right = node;
                return;
            } else {
                // otherwise recurse right
                return this.insert(node, current.right);
            }
        }
    };

    find(val, current) { }
    
    // recursive
    getSmallestFromSubtree(current){}
    

    // --- HELPER METHOD for printing the BST ---
    // Logs this tree horizontally with the root on the left.
    print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
        if (!node) {
            return;
        }

        spaceCnt += spaceIncr;
        this.print(node.right, spaceCnt);

        console.log(
            " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) + `${node.val}`
        );

        this.print(node.left, spaceCnt);
    }

    /* alt tree
                  root
              <-- 25 -->
            /            \
          15             44 <---
        /    \         /    \
      10     22      35     70
    /   \   /  \    /  \   /  \
   4    12     24         66  90
*/

 
};

// Recursion is:
// - function that calls itself
// - and modifies the inputs
// - so that the inputs lead to a 'base case' and end the recursive call


//               root
//          <-- 50 -->
//         /          \
//       40           60 <---
//     /    \        /    \
//   20     45     55     70
var myBST = new BST();
myBST.insert(new BSTNode(50))
myBST.insert(new BSTNode(40))
myBST.insert(new BSTNode(60))
myBST.insert(new BSTNode(20))
myBST.insert(new BSTNode(45))
myBST.insert(new BSTNode(55))
myBST.insert(new BSTNode(70))

myBST.insert(new BSTNode(56))
myBST.insert(new BSTNode(61))

console.log(myBST);
myBST.print();
// myBST.getLargestFromSubtree();
// myBST.getSmallestFromSubtree();

console.log("*".repeat(30));
// myBST.delete(60);
myBST.delete(60);
myBST.print();
console.log(myBST);
// console.log("¯\\_(ツ)_/¯🎈");
// myBST.print();