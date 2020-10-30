public class Numbers {
    private long value;
    private boolean infinite;

    public Numbers(boolean inf, long value){
        this.value = value;
        this.infinite = inf;
    }
    public void print(){
        if(infinite)
            System.out.print("inf");
        else
            System.out.print(value);
    }
    
    public void print_adja(){
        if(infinite)
            System.out.print(0);
        else
            System.out.print(1);
    }
    public void print_valeur(){
        if(infinite)
            System.out.print("inf");
        else
            System.out.print(value);
    }
    
    public Numbers plus(Numbers b){
        return new Numbers(this.infinite ||b.infinite, this.value + b.value);
    }

    public static boolean diff (Numbers a, Numbers b){
        return a.infinite != b.infinite || a.value != b.value;
    }


    public Numbers min(Numbers a, Numbers b){
        Numbers n = a.plus(b);
        if(this.infinite)
            return n;
        if(n.infinite)
            return this;
        return this.value < n.value ? this : n;
    }
    
}
