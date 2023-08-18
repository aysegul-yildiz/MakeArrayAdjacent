import java.util.Arrays;

public class ArrayAdjacent {
public static void main(String[] args) 
{
    // Ayşegül Yıldız
    
    // create two dimensional array
    int [][] lists = {
                        {5, 4, 9, 4, 9, 5},
                        {4, 2, 4, 5, 5},
                        {5, 4, 5, 4, 1},
                        {5, 4, 1},
                        {1, 1, 1},
                        {4, 5},
                    };
    // call the test method
    testAdjacent(lists);
}

public static int[] makeAdjacent( int[] list)
{
    // for loop to search 4 in the list
    for ( int i = 0; i < list.length; i++ )
    {
        if ( list[i] == 4 )
        {
            // if it is in the first place search for 5 and put it after 4 and increment other characters
            if ( i == 0 )
            {
                for ( int a = 1; a < list.length; a++ )
                {
                    if ( list[a] == 5 )
                    {                 
                        for ( int b = a; b > i; b-- )
                        {
                            list [ b ] = list[ b - 1 ];
                        }
                        list[i+1] = 5;
                    }
                }
            }
            else 
            {
                // search for 5 
                for ( int a = 0; a < list.length; a++ )
                {
                    if ( list[a] == 5 )
                    {
                        // if 5 is after 4 put it rigth after 4 and increment other characters' places between 4 and 5
                        if ( a > i )
                        {
                            for ( int b = a; b > i; b-- )
                            {
                                list [ b ] =list[ b - 1 ];
                            }
                            list[i+1] = 5;
                        }
                        // if 5 is before 4 put it rigth after 4 and decrement other characters' places between 4 and 5
                        else if ( a < i )
                        {
                            for ( int b = a; b < i; b++ )
                            {
                                list [ b ] = list [ b + 1 ];
                            }
                            list[ i ] = 5;
                        }
                    }
                } 
            }
        }
    }
    return list;
}
    
public static void testAdjacent( int[][] lists )
{
    // apply the make adjacent method and print original list and updated list for every row of the two dimensional array
    for ( int i = 0; i < lists.length; i++)
    {
        int[] list =  Arrays.copyOf(lists[i], lists[i].length);
        System.out.print("Original: " + Arrays.toString(list));
        System.out.println(" Result: " + Arrays.toString(makeAdjacent(list)));
    }  
}
    
}