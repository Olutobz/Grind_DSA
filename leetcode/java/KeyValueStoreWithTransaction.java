package java;

import java.util.HashMap;
import java.util.Map;

/* Design a data structure to implement the following set of operations
  Or Implement a local datastore that supports multi level isolated transaction.
    get(x)
    set(x, ..)
    begin()
    commit()
    end()
* */
public class KeyValueStoreWithTransaction {

    /*  1. Access to the next transactions
       2. get key and value for any transaction id
   */
    private static class Transaction {
        Map<String, String> store = new HashMap<>();
        Transaction next;
    }

    /* 1. Retrieve most recent transaction completed
       2. Get the total number of transactions
    * */
    private static class TransactionStack {
        int size;
        Transaction top;
    }

    private final TransactionStack tStack = new TransactionStack();

    private final Map<String, String> globalStore = new HashMap<>();

    // starts new transaction
    public void begin() {
        Transaction temp = new Transaction();
        temp.next = tStack.top;
        tStack.top = temp;
        tStack.size++;
    }

    public void end() {
        if (tStack.top != null) {
            Transaction curr = tStack.top;
            tStack.top = curr.next;
            tStack.size--;
            curr.next.store.clear();
        }

    }

    // removes key-value if it exists
    public void delete(String key) {
        Transaction curr = tStack.top;
        if (curr != null) {
            curr.store.remove(key);
        } else {
            globalStore.remove(key);
        }
    }

    //  Remove last transaction
    public void rollBack() {
        if (tStack.top != null) {
            tStack.top.store.clear();
        }
    }

    /* Gets most recent value of key if it exists. Can look at all transactions to find key
     * */
    public String get(String key) {
        Transaction curr = tStack.top;
        if (curr != null) {
            return curr.store.get(key);
        }
        return globalStore.get(key);
    }

    /* Sets the value of the specified key for either global transaction
       or whatever transaction we are on
    */
    public void set(String key, String value) {
        Transaction currTransaction = tStack.top;
        if (currTransaction != null) {
            currTransaction.store.put(key, value);
        } else {
            globalStore.put(key, value);
        }

    }

    // Merge current transaction with previous
    public void commit() {
        Transaction curr = tStack.top;
        while (curr != null) {
            globalStore.putAll(curr.store);
            curr = curr.next;
        }

    }

    // optional
    public Transaction peek() {
        return tStack.top;
    }


    public static void main(String[] args) {
        KeyValueStoreWithTransaction store = new KeyValueStoreWithTransaction();
        store.begin();
        store.set("v1", "a");
        store.set("v2", "b");
        store.set("v3", "c");

        store.begin();
        store.set("v1", "A");
        store.set("v2", "B");
        store.set("v3", "C");
        System.out.println("v1->" + store.get("v1"));
        System.out.println("v2->" + store.get("v2"));
        System.out.println("v3->" + store.get("v3"));
        store.commit();
        store.end();

    }

}
