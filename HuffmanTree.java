/**
 * HuffmanTree Class
 *
 * @Abhi Vachani
 * @11/12/2021
 */
public class HuffmanTree
{
    HuffmanNode root;
    
    // HuffmanTree Constructor
    public HuffmanTree(HuffmanNode huff) 
    {
        this.root = huff;
    }
    
    // Calls printLegend
    public void printLegend()
    {
        printLegend(root, "");
        
    }
    
    // Recursive method
    private void printLegend(HuffmanNode t, String s) 
    {
        // Not leaf
        if (t.letter.length() > 1)
        {
            printLegend(t.left, s+"0");
            printLegend(t.right, s+"1");
        }
        else 
        {
            // Is a leaf
            System.out.println(t.letter+"="+s);     
        }
    }
    
    // Makes binary heap from legend
    public static BinaryHeap legendToHeap(String legend)
    {
        
        BinaryHeap B = new BinaryHeap();
        String[] letters = legend.split(" ");
        
        for (int i = 0; i < letters.length; i = i + 2)
        {
            String letter = letters[i];
            
            Double Frequency = Double.parseDouble(letters[i + 1]);
            
            B.insert(new HuffmanNode(letter, Frequency));
            
            
            
        }
        
        return B;
        
        
       
        
        
    }
    
    // Returns huffman tree from heap
    public static HuffmanTree createFromHeap(BinaryHeap b)
    {
        
        
        
        while (b.getSize() > 1) 
        {
            HuffmanNode minFreq1 = (HuffmanNode)b.deleteMin();
            HuffmanNode minFreq2 = (HuffmanNode)b.deleteMin();
            
            HuffmanNode newNode = new HuffmanNode(minFreq1, minFreq2);
            
            newNode.left = minFreq1;
            newNode.right = minFreq2;
            
            b.insert(newNode);
            
            
        }
        
        HuffmanTree t = new HuffmanTree((HuffmanNode)b.findMin());
        return t;
        
        
    }
    
    // Main 
    public static void main(String[] args)
    {
        // Hardcoded string
        String legend = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2";
        
        BinaryHeap binaryHeap = legendToHeap(legend);
        binaryHeap.printHeap();
        HuffmanTree htree = createFromHeap(binaryHeap);
        htree.printLegend();
        
        
    }
}
/*
 * Output: 
<V, 1.0> <W, 2.0> <N, 5.0> <S, 8.0> <G, 3.0> <A, 20.0> <L, 6.0> <E, 24.0> <O, 10.0> <I, 17.0> <H, 4.0> 
A=00
O=010
G=01100
V=011010
W=011011
L=0111
E=10
I=110
S=1110
H=11110
N=11111
 */