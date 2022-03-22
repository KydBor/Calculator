public class OperationHistory extends Database{
    private double[] array = new double[5];
    private int counter = 0;



    @Override
    void save(Object value) {
        double castedValue = (double) value;
        if (counter < array.length) {
            array[counter] = castedValue;
            counter++;
        } else {
            counter = 0;
            array[counter] = castedValue;
        }
    }

    @Override
    void printAllInfo() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
