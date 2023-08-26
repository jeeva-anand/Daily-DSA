
class NestedIndexModification{

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            i *= 2;
            System.out.print(i);
            for (int j = 0; j < i; j++) {
                System.out.print("\t"+j);
            }
            System.out.println();
        }
    }
}