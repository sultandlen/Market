public class Market {
    private static final int TIME = 3; // completion time for one product

    public static int[] calculateCompletionTime(Queues queue){
        //calculate completion times for each customer and returns an array
        int[] completionTimes = new int[queue.size()];
        int completionTime = 0;
        int queueSize = queue.size();
        for (int i  = 0; i < queueSize; i++){
            completionTime += queue.remove() * TIME;
            completionTimes[i] = completionTime;
        }
        return completionTimes;
    }

    public static double calculateAverage(int[] completionTimes){
        // calculate average completion time for all customer
        double sum = 0;
        for(int i = 0; i < completionTimes.length; i++){
            sum += completionTimes[i]; // sum of all completion times
        }
        double average = (sum / completionTimes.length);
        return average;
    }


    public static void main(String[] args) {
        int[] numOfProducts = {8, 9, 6, 7, 10, 1, 11, 5, 3, 4, 2};

        //QUEUE
        System.out.println("\n---QUEUE---");
        Queue queue = new Queue(11);
        for(int i = 0; i < numOfProducts.length; i++){
            queue.insert(numOfProducts[i]);
        }

        int[] completionTimesQ = calculateCompletionTime(queue);

        for(int i  = 0; i < completionTimesQ.length; i++){
            System.out.println("Completion time for the " + (i + 1) + ". customer: " + completionTimesQ[i]);
        }

        double average = calculateAverage(completionTimesQ);
        System.out.printf("\nAverage of all completion times in queue: " + "%.2f%n", average);




        //PRIORITY QUEUE
        System.out.println("\n---PRIORITY QUEUE---");
        PriorityQueue priorityQueue = new PriorityQueue(11);
        for (int numOfProduct : numOfProducts) {
            priorityQueue.insert(numOfProduct);
        }

        int[] completionTimesPQ = calculateCompletionTime(priorityQueue);

        for(int i  = 0; i < completionTimesPQ.length; i++){
            System.out.println("Completion time for the " + (i + 1) + ". customer: " + completionTimesPQ[i]);
        }

        double average2 = calculateAverage(completionTimesPQ);
        System.out.printf("\nAverage of all completion times in priority queue: " + "%.2f%n", average2);
    }
}
