public class A5Numbers {
    private long value;
    private boolean infinite;

    /**
     * Constructor
     * @param inf whether the number is infinite or not
     * @param value the value if the number is not infinite
     */
    public A5Numbers(boolean inf, long value){
        this.value = value;
        this.infinite = inf;
    }

    /**
     * Function that returns whether the number is infinite or not
     * @return a boolean, whether the number is infinite or not
     */
    public boolean isInfinite()
    {
        return this.infinite;
    }
    /**
     * Function that returns the value of the number
     * @return the value
     */
    public long value()
    {
        return this.value;
    }

    /**
     * Function that sums the number and another one in parameters
     * @param b the number that is being summed
     * @return the sum of instance plus b
     */

    public A5Numbers plus(A5Numbers b){
        return new A5Numbers(this.infinite ||b.infinite, this.value + b.value);
    }
    /**
     * Function that compares two numbers passed in parameters and returns whether the two are different
     * @param a first number being compared
     * @param b second number being compared
     * @return true if the numbers are different
     */
    public static boolean diff (A5Numbers a, A5Numbers b){

        //return a.infinite != b.infinite && (a.infinite && b.value;
        return (a.infinite == b.infinite && !a.infinite && b.value != a.value ) || (a.infinite !=b.infinite);
    }

    /**
     * Override of toString method
     * @return the equivalent in string of the number (inf if infinite)
     */
    @Override
    public String toString()
    {
        return this.infinite ? "inf" : Long.toString(this.value);
    }
    /**
     * Function that compares two numbers passed in parameters and returns the smallest of them
     * @param a first number being compared
     * @param b second number being compared
     * @return the smallest between a and b
     */
    public A5Numbers min(A5Numbers a, A5Numbers b){
        A5Numbers n = a.plus(b);
        if(this.infinite)
            return n;
        if(n.infinite)
            return this;
        return this.value < n.value ? this : n;
    }

}
