package arrayexercises;

public class ArrayOfNumbers {
    public static void main(String[] args) {
        int[] n = {1, 56, 12, 200, 78, 64, 112, 484};

        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum = sum + n[i];
            System.out.println("The sum of numbers in an array is:" + sum);
        }

        int max=n[0];
        for(int i=0; i<n.length; i++){
            if(max<n[i]){
                max=n[i];
            }
        }
        System.out.println(max);

        int min=n[0];
        for(int i=0; i<n.length; i++){
            if(min>n[i]){
                min=n[i];
            }
        }
        System.out.println(min);
    }
}


