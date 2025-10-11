/**
 * This class provides a solution to identify and return a list of invalid transactions.
 * A transaction is considered invalid in the following scenarios:
 * 1. If the transaction amount exceeds MAX_AMOUNT.
 * 2. If the transaction occurs within MAX_DIFF time difference and in a different city than another transaction with the same name.
 */
class Solution {
    
    // Constants to be used in the class.
    private static final String DELIMITER = ",";
    private static final Integer MAX_AMOUNT = 1000;
    private static final Integer MAX_DIFF = 60;
    
    /**
     * This nested class represents a transaction entry with its properties.
     */
    private static class TransactionEntry {
        int id;
        String name;
        int time;
        int amount;
        String city;
        
        /**
         * Constructor for TransactionEntry.
         * @param id - The transaction ID.
         * @param name - The name involved in the transaction.
         * @param time - The time at which the transaction took place.
         * @param amount - The transaction amount.
         * @param city - The city where the transaction took place.
         */
        public TransactionEntry(int id, String name, int time, int amount, String city) {
            this.id = id;
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
    
    /**
     * This method returns a list of invalid transactions from a given list of transaction strings.
     * @param transactions - The input array of transaction strings.
     * @return A list of invalid transactions as strings.
     */
    public List<String> invalidTransactions(String[] transactions) {
        // Return an empty list if the input is null.
        if (transactions == null) {
            return Collections.emptyList();
        }
        
        // Create a mapping of transaction name to transaction entries.
        Map<String, List<TransactionEntry>> nameToTransactions = new HashMap<>();
        for (int i = 0; i < transactions.length; ++i) {
            String[] splittedTransaction = transactions[i].split(DELIMITER);
            TransactionEntry entry = new TransactionEntry(i, splittedTransaction[0], Integer.parseInt(splittedTransaction[1]), Integer.parseInt(splittedTransaction[2]), splittedTransaction[3]);
            List<TransactionEntry> listTransactions = nameToTransactions.getOrDefault(entry.name, new ArrayList<>()); 
            listTransactions.add(entry);
            nameToTransactions.put(entry.name, listTransactions);
        }
        
        // Initialize a list to store invalid transactions.
        List<String> invalidTransactions = new ArrayList<>();
        
        // Iterate through each list of transactions grouped by name and check for invalid transactions.
        for(Map.Entry<String, List<TransactionEntry>> entry : nameToTransactions.entrySet()) {
            checkList(entry.getValue(), invalidTransactions, transactions);
        }
        
        // Return the list of invalid transactions.
        return invalidTransactions;
    }
    
    /**
    * This method checks a list of transaction entries for invalid transactions and adds them to the invalidTransactions list.
    * @param entries - A list of TransactionEntry objects.
    * @param invalidTransactions - A list to store invalid transaction strings.
    * @param transactions - The original input array of transaction strings.
    */
    private void checkList(List<TransactionEntry> entries, List<String> invalidTransactions, String[] transactions) {
        // Iterate through each transaction entry in the list.
        for (TransactionEntry entry1 : entries) {
            // If the transaction amount exceeds MAX_AMOUNT, add it to the list of invalid transactions and continue to the next entry.
            if (entry1.amount > MAX_AMOUNT) {
                invalidTransactions.add(transactions[entry1.id]);
                continue;
            }
            
            // Iterate through each transaction entry in the list again to compare with the current entry.
            for (TransactionEntry entry2 : entries) {
                // If the entries have different IDs, the time difference between them is within MAX_DIFF, and they occur in different cities, 
                // consider the transaction as invalid and add it to the invalidTransactions list.
                if (entry1.id != entry2.id && Math.abs(entry1.time - entry2.time) <= MAX_DIFF && !entry1.city.equals(entry2.city)) {
                    invalidTransactions.add(transactions[entry1.id]);
                    // Break the inner loop since the invalid transaction has already been identified and added to the list.
                    break;
                }
            }
        }
    }
}