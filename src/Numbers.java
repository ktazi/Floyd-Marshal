public class Numbers {
    private long value;
    private boolean infinite;

    public Numbers(boolean inf, long value){
        this.value = value;
        this.infinite = inf;
    }
    public void print(){
        if(infinite)
            System.out.print("∞");
        else
            System.out.print(value);
    }
    public Numbers plus(Numbers b){
        return new Numbers(this.infinite ||b.infinite, this.value + b.value);
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
