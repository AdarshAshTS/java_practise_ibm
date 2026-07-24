class ExceptionHandlingTest{
    public static void main(String[] args) {
        int i = 0;
        int[] arr = new int[5];
        try {
            arr[2] = 1000;
            System.err.println(arr[2]);
            System.out.println(10/i);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Finished");
        }
    }
}