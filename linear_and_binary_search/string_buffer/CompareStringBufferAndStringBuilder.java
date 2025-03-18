package linear_and_binary_search.string_buffer;

public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        int numberOfStrings = 1_000_000;
        String str = "hello";

        // Measure time taken by StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numberOfStrings; i++) {
            stringBuffer.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // Measure time taken by StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfStrings; i++) {
            stringBuilder.append(str);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        // Output the time taken by both classes
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");
    }
}
