class MorseTree
{

  //declares private variable root
  private TreeNode root;


  //MorseTree constructor
  public MorseTree() 
  { 
    root = new TreeNode("0"); 
  }

  //second MorseTree constructor
  public MorseTree(String letter)
  {
     root = new TreeNode(letter);
 }

/* Subclass for Nodes */
  public class TreeNode
  {
    private String letter;
    private TreeNode left;
    private TreeNode right;

    //TreeNode Constructor
    public TreeNode(String initValue)
    {
      letter = initValue;
      left = null;
      right = null;
    }

    //returns the letter value
    public  String getLetter(){
      return letter;
    }

    //returns node to the left
    public TreeNode getLeft() 
    { 
      return left; 
    }

    //returns node to the right
    public TreeNode getRight() 
    { 
      return right; 
    }

    //sets letter value
    public void setLetter(String newVal){
      letter = newVal;
    }

    //sets the node to the left
    public void setLeft (TreeNode newLeft) 
    { 
      left = newLeft; 
    }

    //sets the node to the right
    public void setRight (TreeNode newRight) 
    { 
      right = newRight; 
    }
  }

  //recursive method to insert item in correct position
  private void recInsertItem (TreeNode current, TreeNode toInsert, 
int count)
  {
    if (toInsert.getLetter().substring(count,count + 1) == null)
      return;
    if (toInsert.getLetter().substring(count,count + 1).equals(".")) {
      if (current.left == null) {
        current.left = toInsert;
        return;
      }
      else recInsertItem (current.left, toInsert, count+1);
    }
    else {
      if (current.right == null) {
        current.right = toInsert;
        return;
      }
      else recInsertItem(current.right, toInsert, count+1);
    }
  }

  //method to call recInsertItem from Main
  public void InsertItem(String item)
  {
    //TreeNode temp = new TreeNode (item);
    if (root == null) 
    {
     root = new TreeNode(item);
     return;
    }
    else
    {
      int count = 2;
      recInsertItem (root, new TreeNode(item), count);
    }
  }

  //method to call translate2 from Main
  public String translate(String code){

    int count = 0;
    if(code.length() == count)
    {
      return null;
    }
    else{
      return translate2(code, 0, root);
    }
    
  }

  //method to translate given morse code into letters
  private String translate2(String code, int count, TreeNode letter)
  {
    if(code.length() == count){
      return letter.getLetter().substring(0,1);
    } 
    else if(code.substring(count, count + 1).equals("-")){
      return translate2(code, count+1, letter.getRight());
    }
    else if(code.substring(count, count + 1).equals(".")){
      return translate2(code, count+1, letter.getLeft());
    }
    else{
      return "fail";
    }
  }
  
}