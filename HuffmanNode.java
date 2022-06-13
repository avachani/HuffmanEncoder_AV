
/**
 * HuffmanNode Class
 * Specefic to details of HuffmanNode not overall tree
 *
 * @Abhi Vachani
 * @11/12/2021
 */
public class HuffmanNode implements Comparable
{
    public String letter;
    public Double frequency;
    public HuffmanNode left, right;

    // Contructor creates new HuffmanNode
    public HuffmanNode(String letter, Double frequency) 
    {
        this.letter = letter;
        this.frequency = frequency;
        this.left = null;
        this.right = null;

    }

    // Constructor creates new HuffmanNode from two children
    public HuffmanNode(HuffmanNode left, HuffmanNode right) 
    {
        this.letter = left.letter + right.letter;
        this.frequency = left.frequency + right.frequency;
        this.left = null;
        this.right = null;
    }

    // Casts object o into HuffmanNode object
    public int compareTo(Object o) 
    {
        HuffmanNode huff = (HuffmanNode)o;
        return this.frequency.compareTo(huff.frequency);
    }

    // To string method
    public String toString() 
    {
        return "<"+letter+", "+frequency+">";
    }
}

