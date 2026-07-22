class TypeCastExample{
    public static void main(String[] args) {
        int TypeCastVariable = 10;
        double implicitTypeCastVariable = TypeCastVariable;
        int ExplicitTypeCastVariable = (int)implicitTypeCastVariable;
        System.out.print(TypeCastVariable + " - is the original TypeCastVariable\n" + implicitTypeCastVariable + " - is the variable on which implicit type cast is done\n" + ExplicitTypeCastVariable + " - is the variable in which explicit type cast is done\n");
    }
}