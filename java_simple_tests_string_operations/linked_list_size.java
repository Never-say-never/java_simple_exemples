private static int linkedListSize(Set A){
    Object[] a = A.toArray();
    int length = a.length;
    int linkedListLength = 0;
    int index = 0;
    while(index < length){
        index = (int) a[index];
        System.out.println("index:" + index);
        if(index < 0){
            return linkedListLength;
        }
        ++linkedListLength;
    }
    
    return linkedListLength;
}
