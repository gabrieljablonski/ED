package DoubleSidedStack;

public class DoubleSidedStack {
    private static final int N = 10;
    private int right_stack_top;
    private int left_stack_top;
    
    private int[] array = new int[N];
    
    public DoubleSidedStack()
    {
        left_stack_top = -1;
        right_stack_top = N;
        
        for(int i = 0; i < N; i++)
        {
            array[i] = -1;
        }
    }
    
    public void push(int stack_n, int element) throws java.lang.RuntimeException
    {
        if(is_full(stack_n))
        {
            throw new java.lang.RuntimeException("Stack full.");
        }
        switch (stack_n) {
            case 1:
                array[++left_stack_top] = element;
                if(left_stack_top == right_stack_top) right_stack_top++;
                break;
            case 2:
                array[--right_stack_top] = element;
                if(left_stack_top == right_stack_top) left_stack_top--;
                break;
            default:
                throw new java.lang.RuntimeException("Invalid stack number");
        }
    }
    
    public int pop(int stack_n) throws java.lang.RuntimeException
    {
        if(is_empty(stack_n))
        {
            throw new java.lang.RuntimeException("Stack empty.");
        }
        int n;
        switch (stack_n) {
            case 1:
                n = array[left_stack_top];
                array[left_stack_top--] = -1;
                return(n);
            case 2:
                n = array[right_stack_top];
                array[right_stack_top++] = -1;
                return(n);
            default:
                throw new java.lang.RuntimeException("Invalid stack number");
        }
    }
    
    public boolean is_empty(int stack_n) throws java.lang.RuntimeException
    {
        switch(stack_n)
        {
            case 1:
                return left_stack_top == -1;
            case 2:
                return right_stack_top == N;
            default:
                throw new java.lang.RuntimeException("Invalid stack number");
        }
    }
    
    public boolean is_full(int stack_n) throws java.lang.RuntimeException
    {
        switch(stack_n)
        {
            case 1:
                return left_stack_top == N - 1;
            case 2:
                return right_stack_top == 0;
            default:
                throw new java.lang.RuntimeException("Invalid stack number");
        }
    }
    
    public void print_array()
    {
        for(int i:array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
