/**
* r
* one
* twoq
* dst43yerg
**/
public class testDecode{

    public final static void main(String[] args) {
        Set<Has> set = new TreeSet<>();
        
        set.add(new Has("one"));
        set.add(new Has("twoq"));
        set.add(new Has("r"));
        set.add(new Has("one"));
        set.add(new Has("dst43yerg"));
        
        Iterator t = set.iterator();
        while(t.hasNext()){
            Has str = (Has) t.next();
            System.out.println(str.getG());
        }
    }
    
}

class Has implements Comparable<Has>{
    
    private String g;

    public Has(String g) {
        this.g = g;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.g);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Has other = (Has) obj;
        if (!Objects.equals(this.g, other.g)) {
            return false;
        }
        return true;
    }

    
    @Override
    public int compareTo(Has o) {
        if(this.g.length() > o.g.length()){
            return 1;
        }
        
        if(this.g.length() < o.g.length()){
            return -1;
        }
        
        return 0;
    }
}
